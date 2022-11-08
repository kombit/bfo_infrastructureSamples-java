package dk.kombit.restdelivery.config;

/**
 * Configuration element describing secure connector
 */
public class SecureConnectorConfig extends ConnectorConfig {

    private String certificateResourcePath;
    private String password;

    public SecureConnectorConfig(int port, String certificateResourcePath, String password) {
        super(port);
        this.certificateResourcePath = certificateResourcePath;
        this.password = password;
    }

    public String getCertificateResourcePath() {
        return certificateResourcePath;
    }

    public void setCertificateResourcePath(String certificateResourcePath) {
        this.certificateResourcePath = certificateResourcePath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
