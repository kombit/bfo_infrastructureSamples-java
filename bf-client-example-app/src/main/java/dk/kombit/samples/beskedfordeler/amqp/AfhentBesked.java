package dk.kombit.samples.beskedfordeler.amqp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Envelope;
import dk.kombit.bf.beskedkuvert.HaendelsesbeskedType;

import dk.kombit.samples.beskedfordeler.sts.TokenHandler;
import dk.kombit.samples.beskedfordeler.utils.exception.KeyManagerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.kombit.samples.beskedfordeler.utils.SamplesHelper;
import dk.kombit.samples.beskedfordeler.utils.SimpelPersistering;

/**
 * Sample class illustrating how to obtain a security token and fetch a message from a queue in Beskedfordeler.
 * You must set up the application.properties file with keystore and truststore, CVR numbers, certificates
 * and hostname/portnumber. Then you must set dueslagId below to the queue to connect to.
 */
public class AfhentBesked {
	private static final Logger LOGGER = LoggerFactory.getLogger(AfhentBesked.class);

	private static String decodedToken;
	private static Connection conn;
	private static Channel channel;

    private static String dueslagId = SamplesHelper.DUESLAG_ID;
    private static String outputFile = SamplesHelper.INBOUND_MESSAGE_STORE_FILENAME;

    public static void main(String[] args) throws Exception {
    	LOGGER.info("main: Startup time: {}", (new Date()));

		LOGGER.info("main: Fetching token...");
		decodedToken = TokenHandler.getToken();
    	
		LOGGER.debug("dueslag = {}", dueslagId);

		LOGGER.info("main: Opening connection...");
        openConnection();

    	LOGGER.info("main: Processing messages...");
        processMessages();

    	LOGGER.info("main: Exit time: {}", (new Date()));
    }

	private static void processMessages() {
        try {
			LOGGER.info("processMessages(): Waiting for messages...");
			//handleIncomingMessage();
			handleMessage();

		} catch (Exception e) {
			LOGGER.error("processMessages(): Caught exception while handling messages",e);
		}
	}

	/**
	 * DeliverCallback implementation.
	 * Prefer it over {@link Consumer} for a lambda-oriented syntax,
	 * if you don't need to implement all the application callbacks.
	 */
	private static void handleIncomingMessage() throws IOException {
		LOGGER.info("handleIncomingMessage(): Connecting to queue {}", dueslagId);
		boolean autoAck = false;

		// Setup deliver callback function to watch for messages on the queue
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			long deliveryTag = delivery.getEnvelope().getDeliveryTag();
			String messageString = new String(delivery.getBody(), StandardCharsets.UTF_8);

			LOGGER.info("handleIncomingMessage(): Received message body\n{}", messageString);

			// Example of simple persistence of the message
			persistMessage(messageString);

			// Acknowledge a single delivery
			channel.basicAck(deliveryTag, false);

			// Close connection after handling first message - to simplify testing process
			closeConnection();
		};

		// Setup cancel callback function
		CancelCallback cancelCallback = consumerTag -> LOGGER.debug("handleIncomingMessage(): Callback has been canceled");

		channel.basicConsume(dueslagId, autoAck, deliverCallback, cancelCallback);
	}

	/**
	 * DefaultConsumer implementation.
	 * For a lambda-oriented syntax, use DeliverCallback.
	 */
	private static void handleMessage() throws IOException {
		LOGGER.info("handleMessage(): Connecting to queue {}", dueslagId);
		boolean autoAck = false;

		// Setup consumer to watch for messages on the queue
		Consumer defaultConsumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag,
									   Envelope envelope,
									   AMQP.BasicProperties properties,
									   byte[] body)
					throws IOException
			{
				long deliveryTag = envelope.getDeliveryTag();
				String messageString = new String(body, StandardCharsets.UTF_8);

				LOGGER.info("handleMessage(): Received message body\n{}", messageString);

				// Example of simple persistence of the message
				persistMessage(messageString);

				// Acknowledge a single delivery
				channel.basicAck(deliveryTag, false);

				// Close connection after handling first message - to simplify testing process
				closeConnection();
			}
		};
		channel.basicConsume(dueslagId, autoAck, defaultConsumer);
	}

	/**
	 * Opens connection using parameters from application.properties, setting up token for connection establishment.
	 *
	 * @throws Exception thrown if errors occur while attempting to connect
	 */
    private static void openConnection() throws NoSuchAlgorithmException, KeyManagementException, IOException, TimeoutException, KeyManagerException {
		// Setup AMQP connection
		LOGGER.debug("Opening connection to AMQP host on {} : {}",  SamplesHelper.BESKEDFORDELER_HOSTNAME, SamplesHelper.BESKEDFORDELER_PORT_NUMBER);

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
    		LOGGER.warn("Caught exception closing connection",e);
    	}
    }

	/**
	 * Persist incoming message to xml file
	 */
	private static void persistMessage(String messageString) {
		HaendelsesbeskedType haendelsesbesked = prepareHaendelsesbesked(messageString);
		try {
			SimpelPersistering.persistMessage(haendelsesbesked, outputFile);
		} catch (Exception e) {
			LOGGER.error("Caught exception when persisting message",e);
		}
	}

	/**
	 * Helper function
	 */
	private static HaendelsesbeskedType prepareHaendelsesbesked(String messageString) {
		HaendelsesbeskedType haendelsesbesked = null;
		try {
			haendelsesbesked = SamplesHelper.unmarshal(HaendelsesbeskedType.class, messageString);
		} catch (JAXBException e) {
			LOGGER.error("Caught exception when preparing HaendelsesbeskedType",e);
		}
		return haendelsesbesked;
	}
}
