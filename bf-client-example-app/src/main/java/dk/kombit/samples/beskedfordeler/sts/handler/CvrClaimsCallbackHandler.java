package dk.kombit.samples.beskedfordeler.sts.handler;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.ws.security.trust.claims.ClaimsCallback;

/**
 * Cvr Claims callback handler class
 */
public class CvrClaimsCallbackHandler implements CallbackHandler {

    private final String cvr;

    public CvrClaimsCallbackHandler(String cvr) {
        this.cvr = cvr;
    }

    public void handle(Callback[] callbacks)
            throws UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof ClaimsCallback) {
                ClaimsCallback callback = (ClaimsCallback) callbacks[i];
                callback.setClaims(createClaims());

            } else {
                throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
            }
        }
    }

    private Element createClaims() {
        Document doc = DOMUtils.getEmptyDocument();
        Element claimsElement = doc.createElementNS("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Claims");
        claimsElement.setAttributeNS(null, "Dialect",
                "http://docs.oasis-open.org/wsfed/authorization/200706/authclaims");
        Element claimType = doc.createElementNS("http://docs.oasis-open.org/wsfed/authorization/200706", "ClaimType");
        claimType.setAttributeNS(null, "Uri", "dk:gov:saml:attribute:CvrNumberIdentifier");
        Element value = doc.createElementNS(null, "Value");
        value.setTextContent(cvr);
        claimType.appendChild(value);
        claimsElement.appendChild(claimType);
        return claimsElement;
    }

}