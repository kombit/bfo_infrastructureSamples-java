package dk.kombit.restdelivery.connectors;

import dk.kombit.restdelivery.config.ConnectorConfig;
import dk.kombit.restdelivery.config.SecureConnectorConfig;
import dk.kombit.restdelivery.utils.ClientProperties;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

/**
 * Creates server connectors based on provided configuration.
 */
public class ConnectorFactory {

    private static final ClientProperties clientProperties = ClientProperties.getInstance();

    private static final String TRUSTSTORE_RESOURCE_PATH = "/" + clientProperties.getTruststoreResourcePath();
    private static final String TRUSTSTORE_PASSWORD = clientProperties.getTruststorePassword();

    private ConnectorFactory() {}

    /**
     * Creates connector
     *
     * @param server Servlet server instance
     * @param cc Connection configuration for connector
     * @return Server connector
     * @throws CertificateException if any of the certificates in the keystore could not be loaded
     * @throws NoSuchAlgorithmException if the algorithm used to check the integrity of the keystore cannot be found
     * @throws KeyStoreException if no Provider supports a KeyStoreSpi implementation for the specified type
     * @throws IOException I/O problem
     */
    public static ServerConnector createConnector(Server server, ConnectorConfig cc) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

        if(cc instanceof SecureConnectorConfig) {
            SecureConnectorConfig scc = (SecureConnectorConfig) cc;
            return createSecureConnector(server, scc.getPort(), scc.getCertificateResourcePath(), scc.getPassword());
        }

        return createPlainConnector(server, cc.getPort());
    }

    /**
     * Creates plain connector
     *
     * @param server Servlet server instance
     * @param port Bind port to servlet connector
     * @return Servlet connector
     */
    private static ServerConnector createPlainConnector(Server server, int port) {

        HttpConfiguration httpConfig = new HttpConfiguration();
        httpConfig.setOutputBufferSize(32768);

        ServerConnector http = new ServerConnector(server,new HttpConnectionFactory(httpConfig));
        http.setPort(port);
        http.setIdleTimeout(30000);

        return http;
    }

    /**
     * Creates secure connector
     *
     * @param server Servlet server instance
     * @param port Bind port to servlet connector
     * @param certificateResourcePath Keystore resource path
     * @param password Keystore password
     * @return Servlet connector
     * @throws CertificateException if any of the certificates in the keystore could not be loaded
     * @throws NoSuchAlgorithmException if the algorithm used to check the integrity of the keystore cannot be found
     * @throws KeyStoreException if no Provider supports a KeyStoreSpi implementation for the specified type
     * @throws IOException I/O problem
     */
    private static ServerConnector createSecureConnector(Server server, int port, String certificateResourcePath, String password)
            throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {

        InputStream isKs = ConnectorFactory.class.getResourceAsStream(certificateResourcePath);
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(isKs, password.toCharArray());

        InputStream isTs = ConnectorFactory.class.getResourceAsStream(TRUSTSTORE_RESOURCE_PATH);
        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(isTs, TRUSTSTORE_PASSWORD.toCharArray());

        SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
        sslContextFactory.setKeyStorePassword(password);
        sslContextFactory.setKeyStore(ks);
        sslContextFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);
        sslContextFactory.setTrustStore(ts);
        sslContextFactory.setNeedClientAuth(true);

        HttpConfiguration httpsConfig = new HttpConfiguration();
        httpsConfig.setOutputBufferSize(32768);
        SecureRequestCustomizer src = new SecureRequestCustomizer();
        src.setSniHostCheck(false);
        src.setStsMaxAge(2000, TimeUnit.SECONDS);
        src.setStsIncludeSubDomains(true);
        httpsConfig.addCustomizer(src);

        ServerConnector https = new ServerConnector(server,
                new SslConnectionFactory(sslContextFactory, HttpVersion.HTTP_1_1.asString()),
                new HttpConnectionFactory(httpsConfig));
        https.setPort(port);
        https.setIdleTimeout(500000);

        return https;
    }
}
