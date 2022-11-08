package dk.kombit.restdelivery.config;

/**
 * Configuration element describing plain connector
 */
public class ConnectorConfig {

    private int port;

    public ConnectorConfig(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
