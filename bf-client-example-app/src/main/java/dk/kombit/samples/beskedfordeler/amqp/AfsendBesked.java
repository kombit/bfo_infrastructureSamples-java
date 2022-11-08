package dk.kombit.samples.beskedfordeler.amqp;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import dk.kombit.bf.beskedkuvert.FiltreringsdataType;
import dk.kombit.bf.beskedkuvert.HaendelsesbeskedType;
import dk.kombit.bf.beskedkuvert.ObjektRegistreringType;

import dk.kombit.samples.beskedfordeler.utils.SamplesHelper;
import dk.kombit.samples.beskedfordeler.utils.SimpelPersistering;

import dk.kombit.samples.beskedfordeler.sts.TokenHandler;
import dk.kombit.samples.beskedfordeler.utils.exception.KeyManagerException;
import oio.sagdok._3_0.StandardReturType;
import oio.sagdok._3_0.TidspunktType;
import oio.sagdok._3_0.UnikIdType;

import oio.sagdok.organisation._2_0.AktoerType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * Sample class illustrating how to obtain a security token and send a message to distribution by Beskedfordeler.
 * You must set up the application.properties with keystore and truststore, CVR numbers, certificates
 * and hostname/portnumber. Then you must set anvendersystemId below.
 */
public class AfsendBesked {
	private static final Logger LOGGER = LoggerFactory.getLogger(AfsendBesked.class);

	private static Connection conn;
	private static Channel channel;
	private static String decodedToken;

	private static final String OUTBOUND_MESSAGE_STORE_FILENAME = SamplesHelper.OUTBOUND_MESSAGE_STORE_FILENAME;
	private static String anvendersystemId = SamplesHelper.ANVENDERSYSTEM_ID;
	private static String messageFile = SamplesHelper.MESSAGE_FILE;

	private static boolean overrideCVRNumber = false;
	private static boolean issueNewMessageUUID = true;

	public static void main(String[] args) throws Exception {
		LOGGER.info("main: Startup time: {}", (new Date()));

		LOGGER.info("main: Fetching token...");
		decodedToken = TokenHandler.getToken();

		LOGGER.debug("message file ={}", messageFile);
		LOGGER.debug("anvendersystem UUID ={}", anvendersystemId);


		LOGGER.info("main: Building message...");
		//validate xml and load from file
		validateXML(messageFile);
		HaendelsesbeskedType haendelsesbesked = loadHaendelsesBeskedFromFile(messageFile);
		setupMessage(haendelsesbesked);
		String besked = SamplesHelper.marshal(haendelsesbesked, SamplesHelper.HAENDELSESBESKED_QNAME);
		String beskedMsg = SamplesHelper.prettyPrintXML(besked);
		LOGGER.debug("main: Got message\n{}", beskedMsg);

		LOGGER.info("main: Opening connection...");
		openConnection();

		LOGGER.info("main: Sending message...");
		simplePublish(haendelsesbesked);

		//LOGGER.info("main: Closing connection...");
		//closeConnection();

		LOGGER.info("main: Exit time: {}", (new Date()));
	}

	/**
	 * Modifies message with appropriate anvendersystemID, CVR numbers, current time
	 *
	 * @param haendelsesbesked instance of {@link HaendelsesbeskedType} to modify
	 */
	private static void setupMessage(HaendelsesbeskedType haendelsesbesked) {
		try {
			String besked1 = SamplesHelper.marshal(haendelsesbesked, SamplesHelper.HAENDELSESBESKED_QNAME);
			String beskedMsg = SamplesHelper.prettyPrintXML(besked1);
			LOGGER.debug("Message before setup:\n{}", beskedMsg);

			// ensure our anvendersystemId is set up in message (so sender == this sender)
			FiltreringsdataType filtreringsdata = haendelsesbesked.getBeskedkuvert().getFiltreringsdata();
			if (filtreringsdata != null) {
				AktoerType beskedAnsvarligAktoer = filtreringsdata.getBeskedAnsvarligAktoer();
				if (beskedAnsvarligAktoer != null) {
					String uuid = beskedAnsvarligAktoer.getUUIDIdentifikator();
					if (anvendersystemId != null && (!anvendersystemId.equals(uuid))) {
						LOGGER.warn("Warning: Anvendersystem was {} and message UUID has different value {}", anvendersystemId, uuid);
					}
					if (anvendersystemId != null) {
						beskedAnsvarligAktoer.setUUIDIdentifikator(anvendersystemId);
					}
				}
			}

			// ensure that CVR number is present in TilladtModtager and ObjektAnsvarligMyndighed
			String cvr = SamplesHelper.URN_OIO_CVRNR_PREFIX + SamplesHelper.REQUEST_CVR_NUMBER;
			List<UnikIdType> tilladtModtager = filtreringsdata.getTilladtModtager();
			List<ObjektRegistreringType> objektRegistrering = filtreringsdata.getObjektRegistrering();
			if (overrideCVRNumber) {
				// override message
				if (tilladtModtager == null) {
					tilladtModtager = new ArrayList<>();
				}
				if (!cvr.equals(tilladtModtager.get(0).getURNIdentifikator())) {
					LOGGER.info("Overriding CVR number for TilladtModtager in message with supplied CVR number {}", SamplesHelper.REQUEST_CVR_NUMBER);
					tilladtModtager.clear();
					UnikIdType id = new UnikIdType();
					id.setURNIdentifikator(cvr);
					tilladtModtager.add(id);
				}
				if (!cvr.equals(objektRegistrering.get(0).getObjektAnsvarligMyndighed().getURNIdentifikator())) {
					LOGGER.info("Overriding CVR number for ObjektAnsvarligMyndighed in message with supplied CVR number {}", SamplesHelper.REQUEST_CVR_NUMBER);
					objektRegistrering.get(0).getObjektAnsvarligMyndighed().setURNIdentifikator(cvr);
				}
			} else {
				// verify, don't override
				if (tilladtModtager == null || tilladtModtager.isEmpty()) {
					LOGGER.warn("Warning: no TilladtModtager in message");
				} else {
					if (tilladtModtager.size() > 1) {
						LOGGER.warn("Warning: multiple TilladtModtager in message");
					}
					boolean found = false;
					for (UnikIdType uid : tilladtModtager) {
						if (cvr.equals(uid.getURNIdentifikator())) {
							found = true;
							break;
						}
					}
					if (!found) {
						LOGGER.warn("Warning: TilladtModtager {} not in message", cvr);
					}
				}
				if (objektRegistrering == null || objektRegistrering.isEmpty()) {
					LOGGER.warn("Warning: no ObjektRegistrering in message");
				} else if (objektRegistrering.size() > 1) {
					LOGGER.warn("Warning: more than 1 ObjektRegistrering in message");
				} else if (!cvr.equals(objektRegistrering.get(0).getObjektAnsvarligMyndighed().getURNIdentifikator())) {
					LOGGER.error("ERROR: ObjektRegistrering.ObjektAnsvarligMyndighed in message not set to {}, publish will fail", cvr);
					LOGGER.debug("CVR number {} not equal to municipiality id in message: {}", cvr, objektRegistrering.get(0).getObjektAnsvarligMyndighed().getURNIdentifikator());
				}
			}

			// override message UUID
			if (issueNewMessageUUID) {
				String uuid = UUID.randomUUID().toString();
				LOGGER.info("Overriding BeskedId in message with {}", uuid);
				UnikIdType id = new UnikIdType();
				id.setUUIDIdentifikator(uuid);
				haendelsesbesked.setBeskedId(id);
			}
			// always set dannelsestidspunkt to now
			TidspunktType tt = new TidspunktType();
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			tt.setTidsstempelDatoTid(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
			haendelsesbesked.getBeskedkuvert().getLeveranceinformation().setDannelsestidspunkt(tt);
			besked1 = SamplesHelper.marshal(haendelsesbesked, SamplesHelper.HAENDELSESBESKED_QNAME);
			beskedMsg = SamplesHelper.prettyPrintXML(besked1);
			LOGGER.debug("Message after setup:\n{}", beskedMsg);
		} catch (Exception e) {
			LOGGER.error("Caught exception while setting up message", e);
		}
	}

	/**
	 * Publishes the supplied message.
	 *
	 * @param haendelsesbesked
	 * @throws Exception
	 */
	private static void simplePublish(HaendelsesbeskedType haendelsesbesked) throws JAXBException, IOException {
		channel.confirmSelect();

		String corrId = UUID.randomUUID().toString();
		String transactionId = UUID.randomUUID().toString();

		// Add security-token to the message header
		Map<String, Object> headers = new HashMap<>();
		headers.put("token", decodedToken);

		// Build message properties object
		AMQP.BasicProperties props = new AMQP.BasicProperties
				.Builder()
				.correlationId(corrId)
				// reply to property have to be set to point to pseudo queue associated with the channel (Direct Reply method)
				.replyTo(SamplesHelper.PUBLISH_REPLY_QUEUE)
				// custom headers: token have to be passed to the processing service in message header
				.headers(headers)
				.messageId(transactionId)
				.build();

		// Convert input object to XML-string
		String inputString = SamplesHelper.marshal(haendelsesbesked, SamplesHelper.HAENDELSESBESKED_QNAME);

		// Setup consumer to listen for the reply
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag,
									   Envelope envelope,
									   AMQP.BasicProperties properties,
									   byte[] body)
					throws IOException
			{
				long deliveryTag = envelope.getDeliveryTag();
				String messageString = new String(body, StandardCharsets.UTF_8);

				LOGGER.info("Receiving response from RabbitMq:\n{}", messageString);

				//channel.basicAck(deliveryTag, false);
				try {
					handleResponseFromBf(messageString, haendelsesbesked);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		channel.basicConsume(SamplesHelper.PUBLISH_REPLY_QUEUE, true, consumer);

		// Send message using AMQP
		LOGGER.info("simplePublish: Publising message with transactionId = {}", transactionId);
		LOGGER.info("simplePublish: Publising message: {}", inputString);

		channel.basicPublish(SamplesHelper.PUBLISH_EXCHANGE_NAME, SamplesHelper.DISTRIBUTION_QUEUE_NAME, true, false, props, inputString.getBytes(StandardCharsets.UTF_8));
	}

	private static void handleResponseFromBf(String message, HaendelsesbeskedType haendelsesbesked) throws Exception {
		boolean success = false;
		// Convert reply from XML-string to output object
		StandardReturType output = SamplesHelper.unmarshal(StandardReturType.class, message);

		// Handle the reply
		int statusKode = output.getStatusKode().intValue();
		if (statusKode == 20) {
			// Service executed successfully
			LOGGER.info("Publish executed successfully");

			// Example of simple persistance of the message
			SimpelPersistering.persistMessage(haendelsesbesked, OUTBOUND_MESSAGE_STORE_FILENAME);

			success = true;
		} else if (statusKode == 41) {
			// Token has expired, and has to be renewed.
			LOGGER.info("Renewing token");
		} else {
			// Service returned other status code
			LOGGER.error("Call returned status code: {} - {}", statusKode, output.getFejlbeskedTekst());
		}

		if (success) {
			LOGGER.info("Message sent sucessfully");
			closeConnection();
		} else {
			LOGGER.error("Failed to send message");
		}
	}

	/**
	 * Opens connection using parameters from application.properties, setting up token for connection establishment.
	 *
	 * @throws Exception thrown if errors occur while attempting to connect
	 */
	private static void openConnection() throws NoSuchAlgorithmException, KeyManagementException, IOException, TimeoutException, KeyManagerException {
		// Setup AMQP connection
		LOGGER.debug("Opening connection to AMQP host on {}:{}", SamplesHelper.BESKEDFORDELER_HOSTNAME, SamplesHelper.BESKEDFORDELER_PORT_NUMBER);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(SamplesHelper.BESKEDFORDELER_HOSTNAME);
		factory.setPort(SamplesHelper.BESKEDFORDELER_PORT_NUMBER);

		SSLContext sc = SSLContext.getInstance("TLS");
		KeyManager[] km = SamplesHelper.getKeyManagers();

		sc.init(km, null, new java.security.SecureRandom());
		factory.useSslProtocol(sc);

		factory.setVirtualHost(SamplesHelper.BESKEDFORDELER_RABBITMQ_VIRTUAL_HOST);

		// Setup SASL config using security-token
		factory.setSaslConfig(new TokenSaslConfig(decodedToken));

		// Open AMQP connection
		conn = factory.newConnection();
		channel = conn.createChannel();
	}

	/**
	 * Closes channel and connection to AMQP
	 */
	private static void closeConnection() {
		// Close AMPQ connection when no used anymore (reuse same connection for multiple messages for performance)
		LOGGER.debug("Closing connection");
		try {
			channel.close();
			conn.close();
		} catch (Exception e) {
			LOGGER.warn("Caught exception closing connection", e);
		}
	}

	/**
	 * Loads an XML file from supplied file, must contain a {@link HaendelsesbeskedType} root element.
	 *
	 * @param fileName
	 * @return
	 */
	private static HaendelsesbeskedType loadHaendelsesBeskedFromFile(String fileName) throws JAXBException {
		String content = null;
		try {
			content = new String(Files.readAllBytes(new File(fileName).toPath()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			LOGGER.error("Caught exception reading file \"" + fileName + "\"", e);
		}
		LOGGER.debug("Read file {}, got:\n{}", fileName, content);
		return SamplesHelper.unmarshal(HaendelsesbeskedType.class, content);
	}

	private static void validateXML(String fileName) {
		try {
			Source xmlFile = new StreamSource(new File(fileName));
			File schemaFile = new File("src\\main\\resources\\beskedfordeler\\xsd\\Beskedkuvert.xsd");

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
			validator.validate(xmlFile);
		} catch (SAXException | IOException e) {
			LOGGER.error(e.getMessage());
			System.exit(1);
		}
	}
}
