package dk.kombit.samples.beskedfordeler.sts.impl;

import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.staxutils.W3CDOMStreamWriter;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.security.trust.STSClient;
import org.apache.commons.codec.binary.Base64;

import javax.xml.stream.XMLStreamException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/**
 * This class defines the client implementation (based on CXF Security Token Service)
 * for getting a token from the token service.
 */
public class OioStsClient extends STSClient {

    private String endpointUrl = null;

    public OioStsClient() {
        super(BusFactory.newInstance().createBus());
    }

    public void setEndpointUrl(String url) {
        this.endpointUrl = url;
    }

    @Override
    protected void createClient() throws BusException, EndpointException {
        super.createClient();
        if (endpointUrl != null) {
            EndpointReferenceType target = client.getConduit().getTarget();
            if (target.getAddress() != null && !endpointUrl.equals(target.getAddress().getValue())) {
                target.getAddress().setValue(endpointUrl);
            }
        }
    }

    /**
     * The token service requires a non-standard way of supplying the certificate,
     * so we overwrite the method.
     */
    @Override
    protected void writeElementsForRSTPublicKey(W3CDOMStreamWriter writer, X509Certificate cert)
            throws XMLStreamException, CertificateEncodingException {
        writer.writeStartElement("wst", "UseKey", namespace);
        writer.writeStartElement("wsse", "BinarySecurityToken",
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        writer.writeAttribute("EncodingType",
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
        writer.writeAttribute("ValueType",
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3");

        String encodedCert = Base64.encodeBase64String(cert.getEncoded());
        writer.writeCharacters(encodedCert);

        writer.writeEndElement();
        writer.writeEndElement();
    }

}
