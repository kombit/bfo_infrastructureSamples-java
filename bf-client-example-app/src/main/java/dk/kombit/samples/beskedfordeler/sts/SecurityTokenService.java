package dk.kombit.samples.beskedfordeler.sts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;

import dk.kombit.samples.beskedfordeler.sts.interceptor.ContentTypeOutInterceptor;
import dk.kombit.samples.beskedfordeler.sts.interceptor.FrameworkHeaderOutInterceptor;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.rt.security.SecurityConstants;
import org.apache.cxf.ws.security.tokenstore.SecurityToken;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.saml.SamlAssertionWrapper;

import dk.kombit.samples.beskedfordeler.sts.exception.TokenIssueException;
import dk.kombit.samples.beskedfordeler.sts.handler.CvrClaimsCallbackHandler;
import dk.kombit.samples.beskedfordeler.sts.impl.OioStsClient;

import javax.net.ssl.TrustManagerFactory;

/**
 * This class defines Security Token Service class that set TLS/SSL connection parameters,
 * create Security Token Service Client and gets SAML Assertion.
 */
public class SecurityTokenService {
    private final OioStsClient stsClient;

    public SecurityTokenService(Properties cryptoProperties, String endpointLocation)
            throws GeneralSecurityException, IOException, WSSecurityException {
        stsClient = createStsClient(cryptoProperties);
        stsClient.setEndpointUrl(endpointLocation);
    }

    private TLSClientParameters createTlsClientParameters(KeyStore trustStore)
            throws KeyStoreException, NoSuchAlgorithmException {
        TLSClientParameters tlsClientParameters = new TLSClientParameters();
        TrustManagerFactory trustMgrFactory = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustMgrFactory.init(trustStore);
        tlsClientParameters.setTrustManagers(trustMgrFactory.getTrustManagers());
        return tlsClientParameters;
    }

    public OioStsClient getStsClient() {
        synchronized (stsClient) {
            return stsClient;
        }
    }

    /**
     * Gets SAML Assertion from Security Token Service
     * based CVR number and applysTo parameter.
     *
     * @param cvr CVR requesting party number
     * @param applysTo role (i.e. Aflever/Modtag)
     * @return SamlAssertionWrapper
     *
     * @throws TokenIssueException thrown if errors occur when issuing a token
     */
    public SamlAssertionWrapper getSamlAssertion(String cvr, String applysTo)
            throws TokenIssueException {
        synchronized (stsClient) {
            stsClient.setClaimsCallbackHandler(new CvrClaimsCallbackHandler(cvr));

            SecurityToken token;
            try {
                if (applysTo != null) {
                    token = stsClient
                            .requestSecurityToken(applysTo);
                } else {
                    token = stsClient
                            .requestSecurityToken();
                }
                return new SamlAssertionWrapper(token.getToken());
            } catch (Exception e) {
                throw new TokenIssueException("Token issue error: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Creates Security Token Service Client based on properties found in application.properties file.
     *
     * @param cryptoProperties Properties instance
     * @return OioStsClient
     */
    private OioStsClient createStsClient(Properties cryptoProperties)
            throws GeneralSecurityException, IOException, WSSecurityException {

        OioStsClient client = new OioStsClient();
        client.setWsdlLocation(cryptoProperties.getProperty("wsdl.file"));
        client.setEndpointName(
                "{http://schemas.microsoft.com/ws/2008/06/identity/securitytokenservice}CertificateWSTrustBinding_IWSTrust13Sync");
        client.setKeyType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/PublicKey");
        client.setWspNamespace("http://schemas.xmlsoap.org/ws/2004/09/policy");
        client.setAllowRenewing(false);

        client.setSoap11();

        client.getOutInterceptors()
                .add(new ContentTypeOutInterceptor());
        client.getOutInterceptors()
                .add(new FrameworkHeaderOutInterceptor());

        Crypto crypto = CryptoFactory.getInstance(
                cryptoProperties, this.getClass().getClassLoader(), null);

        client.getProperties().put(SecurityConstants.STS_TOKEN_CRYPTO, crypto);
        client.getProperties().put(SecurityConstants.SIGNATURE_CRYPTO, crypto);

        client.getProperties().put("ws-security.is-bsp-compliant", "false");
        client.getProperties().put("ws-security.add.inclusive.prefixes", "false");
        client.getProperties().put("ws-security.asymmetric.signature.algorithm",
                "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");

        String trustStoreFile = cryptoProperties.getProperty("safewhere.endpoint.truststore.file");
        String trustStorePassword = cryptoProperties.getProperty("safewhere.endpoint.truststore.password");

        if (trustStoreFile != null && trustStorePassword != null) {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            try (InputStream trustStoreIn = new FileInputStream(trustStoreFile)) {
                ks.load(trustStoreIn, trustStorePassword.toCharArray());
                client.setTlsClientParameters(createTlsClientParameters(ks));
            }
        }

        return client;
    }

    /**
     * Enables logging for Security Token Service request/response.
     *
     * @param b set as true if logging should be enabled.
     */
    public void setLoggingEnabled(boolean b) {
        if (b) {
            if (stsClient.getFeatures() != null) {
                stsClient.getFeatures().add(new LoggingFeature());
            } else {
                stsClient.setFeatures(Arrays.asList(new LoggingFeature()));
            }
        }
    }
}
