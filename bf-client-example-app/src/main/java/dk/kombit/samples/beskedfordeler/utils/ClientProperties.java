package dk.kombit.samples.beskedfordeler.utils;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Client properties class for getting properties from application.properties file.
 */
public class ClientProperties {

    private static final String PROPERTIES_NAME = "/application.properties";
    private static ClientProperties clientProperties;
    private final Properties properties;

    private static final String KEYSTORE_FILENAME = "org.apache.ws.security.crypto.merlin.keystore.file";
    private static final String KEYSTORE_PASSWORD = "org.apache.ws.security.crypto.merlin.keystore.password";

    private static final String TRUSTSTORE_FILENAME = "safewhere.endpoint.truststore.file";
    private static final String TRUSTSTORE_PASSWORD = "safewhere.endpoint.truststore.password";

    private static final String BESKEDFORDELER_HOSTNAME = "beskedfordeler.hostname";
    private static final String BESKEDFORDELER_PORT_NUMBER = "beskedfordeler.port.number";

    private static final String HAENDELSESBESKED_QNAME_NAMESPACE_URI = "haendelsesbesked.qname.namespace.uri";
    private static final String HAENDELSESBESKED_QNAME_LOCAL_PART = "haendelsesbesked.qname.local.part";
    private static final String URN_OIO_CVRNR_PREFIX = "urn.oio.cvrnr.prefix";

    private static final String BESKEDFORDELER_RABBITMQ_VIRTUAL_HOST = "rabbitmq.beskedfordeler.virtual.host";
    private static final String PUBLISH_EXCHANGE_NAME = "rabbitmq.publish.exchange.name";
    private static final String DISTRIBUTION_QUEUE_NAME = "rabbitmq.distribution.queue.name";
    private static final String PUBLISH_REPLY_QUEUE = "rabbitmq.publish.reply.queue";

    private static final String REQUEST_CVR_NUMBER = "safewhere.token.request.claim.cvr";
    private static final String REQUEST_APPLYS_TO = "safewhere.token.request.applysTo";

    private static final String OUTBOUND_MESSAGE_STORE_FILENAME = "outbound.message.store.filename";
    private static final String INBOUND_MESSAGE_STORE_FILENAME = "inbound.message.store.filename";

    private static final String MESSAGE_FILE = "message.file";
    private static final String ANVENDERSYSTEM_ID="anvendersystem.id";
    private static final String DUESLAG_ID="dueslag.id";

    /**
     * Method creates a new instance of ClientProperties
     * @return clientProperties
     */
    public static ClientProperties getInstance() {
        if (clientProperties == null) {
            clientProperties = new ClientProperties();
        }

        return clientProperties;
    }

    /**
     * Method is responsible for reading the properties from the application.properties file
     */
    private ClientProperties() {
        properties = new Properties();

        try (InputStream inputStream = getClass().getResourceAsStream(PROPERTIES_NAME)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read " + PROPERTIES_NAME);
        }
    }

    /**
     * Get methods for variables and constansts
     * @return varibles and constants
     */

    public String getKeystoreFilename() {
        return properties.getProperty(KEYSTORE_FILENAME);
    }
    public String getKeystorePassword() { return properties.getProperty(KEYSTORE_PASSWORD); }

    public String getTruststoreFilename() {
        return properties.getProperty(TRUSTSTORE_FILENAME);
    }

    public String getTruststorePassword() { return properties.getProperty(TRUSTSTORE_PASSWORD); }

    public String getBeskedfordelerHostname() {
        return properties.getProperty(BESKEDFORDELER_HOSTNAME);
    }

    public int getBeskedfordelerPortNumber() {
        return Integer.parseInt(properties.getProperty(BESKEDFORDELER_PORT_NUMBER));
    }

    public QName getHaendelsesbeskedQname() {
        String qnameNamespaceUri = properties.getProperty(HAENDELSESBESKED_QNAME_NAMESPACE_URI);
        String qnameLocalPart = properties.getProperty(HAENDELSESBESKED_QNAME_LOCAL_PART);
        return new QName(qnameNamespaceUri,qnameLocalPart);
    }

    public String getUrnOioCvrnrPrefix() {
        return properties.getProperty(URN_OIO_CVRNR_PREFIX);
    }

    public String getBeskedfordelerRabbitmqVirtualHost() {
        return properties.getProperty(BESKEDFORDELER_RABBITMQ_VIRTUAL_HOST);
    }

    public String getPublishExchangeName() {
        return properties.getProperty(PUBLISH_EXCHANGE_NAME);
    }

    public String getDistributionQueueName() {
        return properties.getProperty(DISTRIBUTION_QUEUE_NAME);
    }

    public String getPublishReplyQueue() {
        return properties.getProperty(PUBLISH_REPLY_QUEUE);
    }

    public String getRequestCvrNumber() {
        return properties.getProperty(REQUEST_CVR_NUMBER);
    }

    public String getRequestApplysTo() {
        return properties.getProperty(REQUEST_APPLYS_TO);
    }

    public String getOutboundMessageStoreFilename() {
        return properties.getProperty(OUTBOUND_MESSAGE_STORE_FILENAME);
    }

    public String getInboundMessageStoreFilename() {
        return properties.getProperty(INBOUND_MESSAGE_STORE_FILENAME);
    }

    public String getMessageFile() {
        return properties.getProperty(MESSAGE_FILE);
    }

    public String getAnvendersystemId() {
        return properties.getProperty(ANVENDERSYSTEM_ID);
    }

    public String getDueslagId() {
        return properties.getProperty(DUESLAG_ID);
    }

}
