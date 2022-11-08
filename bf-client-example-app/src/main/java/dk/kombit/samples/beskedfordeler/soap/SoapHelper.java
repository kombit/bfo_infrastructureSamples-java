package dk.kombit.samples.beskedfordeler.soap;

import dk.kombit.samples.beskedfordeler.utils.ClientProperties;
import dk.kombit.samples.beskedfordeler.utils.SamplesHelper;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;

public class SoapHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoapHelper.class);
    private static final ClientProperties clientProperties = ClientProperties.getInstance();
    private static final String KEYSTORE_PASSWORD = clientProperties.getKeystorePassword();

    /**
     * Methods that loads keystore from file and returns KeyStore object
     *
     * @param keyStoreFile path to keystore
     * @param keyStorePassword password to keystore
     *
     * @return TLSClientParameters
     */
    public static KeyStore loadKeyStore(String keyStoreFile, String keyStorePassword)
            throws GeneralSecurityException, IOException {

        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        if (keyStoreFile != null && keyStorePassword != null) {
            try (InputStream keyStoreIn = new FileInputStream(keyStoreFile)) {
                ks.load(keyStoreIn, keyStorePassword.toCharArray());
                return ks;
            }
        }
        return null;
    }

    /**
     * Method that sets TLS/SSL client parameters
     *
     * @param keyStore object
     * @param trustStore object
     *
     * @return TLSClientParameters
     */
    public static TLSClientParameters createTlsClientParameters(KeyStore keyStore, KeyStore trustStore)
            throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {

        TLSClientParameters tlsClientParameters = new TLSClientParameters();

        KeyManagerFactory keyMgrFactory = KeyManagerFactory
                .getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyMgrFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());
        tlsClientParameters.setKeyManagers(keyMgrFactory.getKeyManagers());

        TrustManagerFactory trustMgrFactory = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustMgrFactory.init(trustStore);
        tlsClientParameters.setTrustManagers(trustMgrFactory.getTrustManagers());

        return tlsClientParameters;
    }

    /**
     * Loads an XML file from supplied file, must contain a {@link Class<T>} root element.
     *
     * @param cl Type of object
     * @param fileName Input string
     * @return Object of the given type
     * @throws JAXBException
     */
    public static <T> T loadFromFile(Class<T> cl, String fileName) throws JAXBException {
        String content = null;
        try {
            content = new String(Files.readAllBytes(new File(fileName).toPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Caught exception reading file \"" + fileName + "\"", e);
        }
        LOGGER.debug("Read file {}, got:\n{}", fileName, content);
        return SamplesHelper.unmarshal(cl, content);
    }

    /**
     * Validates an XML file from supplied file against xsd schema.
     *
     * @param fileName Input string
     */
    public static void validateXML(String fileName, String schemaFilePath) {
        try {
            Source xmlFile = new StreamSource(new File(fileName));
            File schemaFile = new File(schemaFilePath);

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
