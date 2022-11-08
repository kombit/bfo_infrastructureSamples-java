package dk.kombit.restdelivery;

import dk.kombit.restdelivery.config.ConnectorConfig;
import dk.kombit.restdelivery.config.SecureConnectorConfig;
import dk.kombit.restdelivery.connectors.ConnectorFactory;
import dk.kombit.restdelivery.servlets.MessageReceivingServlet;
import dk.kombit.restdelivery.utils.ClientProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;

/**
 * Application providing services for rest delivery examples.
 *  <p>
 *  Following services are provided on ports:
 *  9043 - message receiving secure service (with TLS/SSL),
 *  9044 - message receiving insecure service
 */
public class RestDeliveryApp extends Server {

    private static final Logger log = LoggerFactory.getLogger(RestDeliveryApp.class);
    private static final ClientProperties clientProperties = ClientProperties.getInstance();
    private static final String KEYSTORE_FILENAME = clientProperties.getKeystoreFilename();
    private static final String PASSWORD = clientProperties.getKeystorePassword();
    private static final String PORT = clientProperties.getPort();
    private final ServletHandler context = new ServletHandler();

    public static void main(String[] args) {
        RestDeliveryApp rdma = new RestDeliveryApp();
        rdma.startServer();
        log.info("====== RestDeliveryApp service started. ======");
        log.info("Service is available on port {}", PORT);
    }

    public RestDeliveryApp() {
        Connector[] connectors = getConnectorsWithGivenConfigs(getDefaultMessageReceivingSecureConfig(), this);
        setConnectors(connectors);
        setHandler(context);
        context.addServletWithMapping(MessageReceivingServlet.class, "/push/*");
    }

    protected List<ConnectorConfig> getDefaultMessageReceivingSecureConfig() {
        String certificateResourcePath = "/" + KEYSTORE_FILENAME;
        ConnectorConfig config;
        if (PORT.equals("443")) { // secure connection
            config = new SecureConnectorConfig(Integer.parseInt(PORT), certificateResourcePath, PASSWORD);
        } else { // unsecure connection
            config = new ConnectorConfig(Integer.parseInt(PORT));
        }
        return Arrays.asList(config);
    }

    private Connector[] getConnectorsWithGivenConfigs(List<ConnectorConfig> configs, Server server) {

        Connector[] connectors = new Connector[configs.size()];

        for (int i = 0; i < configs.size(); i++) {
            try {
                connectors[i] = ConnectorFactory.createConnector(server, configs.get(i));
            } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
                final String message = "A connection cant be created with: " + configs.get(i).toString() + " to " + server.toString();
                throw new SecurityException(message, e);
            }
        }

        return connectors;
    }

    public void startServer() {
        try {
            this.start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
