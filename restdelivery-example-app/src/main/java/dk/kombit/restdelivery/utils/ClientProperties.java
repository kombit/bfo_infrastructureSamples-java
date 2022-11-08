package dk.kombit.restdelivery.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClientProperties {
    private static final String PROPERTIES_NAME = "/application.properties";
    private static ClientProperties clientProperties;
    private final Properties properties;

    private static final String KEYSTORE_FILENAME = "keystore.file";
    private static final String KEYSTORE_PASSWORD = "keystore.password";

    private static final String TRUSTSTORE_RESOURCE_PATH = "truststore.resource.path";
    private static final String TRUSTSTORE_PASSWORD = "truststore.password";

    private static final String PORT = "app.port";

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

    public String getTruststoreResourcePath() { return properties.getProperty(TRUSTSTORE_RESOURCE_PATH); }
    public String getTruststorePassword() { return properties.getProperty(TRUSTSTORE_PASSWORD); }

    public String getPort() { return properties.getProperty(PORT); }

}
