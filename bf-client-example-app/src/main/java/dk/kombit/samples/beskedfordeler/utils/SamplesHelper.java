package dk.kombit.samples.beskedfordeler.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import java.security.KeyStore;


import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import dk.kombit.samples.beskedfordeler.utils.exception.KeyManagerException;
import dk.kombit.samples.beskedfordeler.utils.exception.KeyStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Class containing various helper functions and constants for BF samples.
 *
 */
public class SamplesHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(SamplesHelper.class);

	private static final ClientProperties clientProperties = ClientProperties.getInstance();

	public static final String BESKEDFORDELER_HOSTNAME 			= clientProperties.getBeskedfordelerHostname();
	public static final int	   BESKEDFORDELER_PORT_NUMBER 		= clientProperties.getBeskedfordelerPortNumber();

	public static final QName HAENDELSESBESKED_QNAME = clientProperties.getHaendelsesbeskedQname();
	public static final String URN_OIO_CVRNR_PREFIX = clientProperties.getUrnOioCvrnrPrefix();

	public static final String BESKEDFORDELER_RABBITMQ_VIRTUAL_HOST = clientProperties.getBeskedfordelerRabbitmqVirtualHost();
	public static final String PUBLISH_EXCHANGE_NAME 				= clientProperties.getPublishExchangeName();
	public static final String DISTRIBUTION_QUEUE_NAME				= clientProperties.getDistributionQueueName();
	public static final String PUBLISH_REPLY_QUEUE 					= clientProperties.getPublishReplyQueue();

	public static final String REQUEST_CVR_NUMBER = clientProperties.getRequestCvrNumber();

	public static final String OUTBOUND_MESSAGE_STORE_FILENAME = clientProperties.getOutboundMessageStoreFilename();
	public static final String INBOUND_MESSAGE_STORE_FILENAME = clientProperties.getInboundMessageStoreFilename();
	public static final String MESSAGE_FILE = clientProperties.getMessageFile();
	public static final String ANVENDERSYSTEM_ID = clientProperties.getAnvendersystemId();
	public static final String DUESLAG_ID = clientProperties.getDueslagId();

	private static final String KEYSTORE_FILENAME = clientProperties.getKeystoreFilename();
	private static final String KEYSTORE_PASSWORD = clientProperties.getKeystorePassword();

	private static final String TRUSTSTORE_FILENAME = clientProperties.getTruststoreFilename();
	private static final String TRUSTSTORE_PASSWORD = clientProperties.getTruststorePassword();
	public static final Boolean OVERRIDE_CVR_NR_FLAG = clientProperties.getOverrideCvrNrFlag();

	public static final ClassLoader classLoader = SamplesHelper.class.getClassLoader();

	private SamplesHelper() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Creates a Java {@link KeyManager} instance based on keystore and password above.
	 * @return instance of {@link KeyManager}
	 */
	public static KeyManager[] getKeyManagers() throws KeyManagerException {
		try {
			KeyStore ksKeys = createKeyStoreForKeys();
			// KeyManagers decide which key material to use
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(ksKeys, KEYSTORE_PASSWORD.toCharArray());
			return kmf.getKeyManagers();
		} catch (Exception e) {
			throw new KeyManagerException("Caught exception while instantiating keymanager",e);
		}
	}

	/**
	 * Creates a {@link KeyStore} instance based on keystore and password above
	 * @return instance of {@link KeyStore}
	 */
	private static KeyStore createKeyStoreForKeys() throws KeyStoreException {
		try {
			// First initialize the key and trust material
			KeyStore ksKeys = KeyStore.getInstance("JKS");
			char[] passphrase = KEYSTORE_PASSWORD.toCharArray();
			ksKeys.load(new FileInputStream(KEYSTORE_FILENAME), passphrase);
			return ksKeys;
		} catch (Exception e) {
			throw new KeyStoreException("Caught exception while instantiating keystore",e);
		}
	}

    /**
     * Convert a string to an object of a given class.
     *
     * @param cl Type of object
     * @param s Input string
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, String s) throws JAXBException
    {
        return unmarshal(cl, new StringReader(s));
    }

    /**
     * Convert the contents of a Reader to an object of a given class.
     *
     * @param cl Type of object
     * @param r Reader to be read
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, Reader r) throws JAXBException
    {
        return unmarshal(cl, new StreamSource(r));
    }
    /**
     * Convert the contents of a Source to an object of a given class.
     *
     * @param cl Type of object
     * @param s Source to be used
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T unmarshal(Class<T> cl, Source s) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(cl);
        Unmarshaller u = ctx.createUnmarshaller();
        return u.unmarshal(s, cl).getValue();
    }

    /**
     * Convert an object to a string.
     *
     * @param obj Object that needs to be serialized / marshalled.
     * @param rootName the name of the root element as a QName
     * @return String representation of obj
     * @throws JAXBException
     */
    public static <T> String marshal(T obj, QName rootName) throws JAXBException
    {
    	StringWriter sw = new StringWriter();
        marshal(obj, sw, rootName);
        return sw.toString();
    }

    /**
     * Convert an object to a string and send it to a Writer.
     *
     * @param obj Object that needs to be serialized / marshalled
     * @param wr Writer used for outputting the marshalled object
     * @param rootName the name of the root element as a QName
     * @throws JAXBException
     */
    public static <T> void marshal(T obj, Writer wr, QName rootName) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
        Marshaller m = ctx.createMarshaller();
//        @SuppressWarnings("rawtypes")
        JAXBElement<?> jaxbElement = new JAXBElement(rootName, obj.getClass(), obj);
		m.marshal(jaxbElement, wr);
    }

    /**
     * @param xmlDocument a String containing an XML structure to prettyprint
     * @return a String containing a prettyprinted XML structure
     */
    public static String prettyPrintXML(String xmlDocument) {
    	try {
	    	DocumentBuilderFactory dbFactory;
	    	DocumentBuilder dBuilder;
	    	Document original = null;
	    	try {
	    		dbFactory = DocumentBuilderFactory.newInstance();
				dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
	    		dbFactory.setNamespaceAware(true);
	    		dBuilder = dbFactory.newDocumentBuilder();
	    		original = dBuilder.parse(new InputSource(new StringReader(xmlDocument)));
	    	} catch (SAXException | IOException | ParserConfigurationException e) {
	    		e.printStackTrace();
	    	}
	    	StringWriter stringWriter = new StringWriter();
	    	StreamResult xmlOutput = new StreamResult(stringWriter);
	    	TransformerFactory tf = TransformerFactory.newInstance();
			tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
	    	Transformer transformer = tf.newTransformer();
	    	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    	transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	    	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    	transformer.transform(new DOMSource(original), xmlOutput);
	    	return xmlOutput.getWriter().toString();
	    } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
	    }
    }

    /**
     * Returns a trustmanager to use for establing a secured AMQP connection
     * @return array of {@link TrustManager} to be used for securing AMQP connection
     */
    public static TrustManager[] getTrustManagers() {
        TrustManagerFactory tmf = null;
		try {
			tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
		} catch (Exception e) {
			LOGGER.error("Caught exception while instantiating TrustManagerFactory", e);
		}
	    try {
			KeyStore tsKeys = KeyStore.getInstance("JKS");
			char[] passphrase = TRUSTSTORE_PASSWORD.toCharArray();
			tsKeys.load(classLoader.getResourceAsStream(TRUSTSTORE_FILENAME), passphrase);
			tmf.init(tsKeys);
		} catch (Exception e) {
			LOGGER.error("Caught exception while initializing TrustManagerFactory", e);
		}
        return tmf.getTrustManagers();
    }
}
