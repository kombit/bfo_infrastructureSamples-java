package dk.kombit.samples.beskedfordeler.sts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import dk.kombit.samples.beskedfordeler.sts.impl.OioStsClient;
import org.apache.wss4j.common.saml.SamlAssertionWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class defines token handler which allows getting token, cache it
 * and checks validity in terms of expiration.
 */
public class TokenHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenHandler.class);
    private static SecurityTokenService tokenService;
    private static final ConcurrentHashMap<String, String> tokens = new ConcurrentHashMap<>();
    private static Instant validFromTime = null;
    private static Instant validToTime = null;

    private TokenHandler() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Gets token and checks its validity in therms of expiration (NotBefore/NotOnOrAfter).
     *
     * @return String
     * @throws IOException thrown if errors occur when application.properties file cannot be loaded
     */
    public static String getToken() throws IOException {
        final Properties p = new Properties();
        try (InputStream fin = new FileInputStream("src/main/resources/application.properties")) {
            p.load(fin);
        }

        final String tokenRequestCvr = p.getProperty("safewhere.token.request.claim.cvr");
        final String tokenServiceEndpointLocation = p.getProperty("safewhere.endpoint.url");
        final String applysTo = p.getProperty("safewhere.token.request.applysTo");

        String cachedToken = tokens.get(tokenRequestCvr);

        if (cachedToken == null || isNotValid()) {
            LOGGER.info("Token is null or expired, fetching new token...");
            String token = fetchToken(p, tokenRequestCvr, tokenServiceEndpointLocation, applysTo);
            tokens.put(tokenRequestCvr, token);
            return token;
        } else {
            return cachedToken;
        }
    }

    /**
     * Fetch token from Security Token Service.
     * @param p Properties instance
     * @param tokenRequestCvr CVR requesting party number
     * @param tokenServiceEndpointLocation Security Token Service endpoint
     * @param applysTo role (i.e. Aflever/Modtag)
     *
     * @return String token assertion
     */
    private static String fetchToken(Properties p, String tokenRequestCvr, String tokenServiceEndpointLocation, String applysTo) {
        System.setProperty("javax.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");

        String tokenAssertion = null;

        try {
            tokenService = new SecurityTokenService(p, tokenServiceEndpointLocation);
            tokenService.setLoggingEnabled(true);
            SamlAssertionWrapper assertion = tokenService.getSamlAssertion(tokenRequestCvr, applysTo);
            tokenAssertion = assertion.assertionToString();

            validFromTime = assertion.getNotBefore();
            validToTime = assertion.getNotOnOrAfter().minusSeconds(10);

            LOGGER.debug("Got token for CVR {}: Assertion ID: {}, expires: {}", tokenRequestCvr, assertion.getId(), assertion.getNotOnOrAfter());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return tokenAssertion;
    }

    public static OioStsClient getStsClient() {
        return tokenService.getStsClient();
    }

    /**
     * Helper function. Checks token validity in therms of expiration (NotBefore/NotOnOrAfter).
     *
     * @return true if token is valid. Otherwise false.
     */
    private static boolean isNotValid() {
        Instant now = Instant.now();
        return now.isBefore(validFromTime) || now.isAfter(validToTime);
    }
}
