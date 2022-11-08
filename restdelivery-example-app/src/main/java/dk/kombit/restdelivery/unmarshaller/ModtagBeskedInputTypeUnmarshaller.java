package dk.kombit.restdelivery.unmarshaller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import oio.sts._1_0.ModtagBeskedInputType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ModtagBeskedInputTypeUnmarshaller {

    private final Logger log = LoggerFactory.getLogger(ModtagBeskedInputTypeUnmarshaller.class);

    private JAXBContext jaxbContext;
    private Unmarshaller unmarshaller;
    private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    private DocumentBuilder db;

    public ModtagBeskedInputTypeUnmarshaller() {
        try {
            jaxbContext = JAXBContext.newInstance(ModtagBeskedInputType.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            dbf.setNamespaceAware(true);
            db = dbf.newDocumentBuilder();
        } catch (JAXBException | ParserConfigurationException e) {
            log.error("Unexpected error has occurred during marshall operation: " + e);
        }
    }

    public ModtagBeskedInputType getObject(String message) throws Exception {
        return getObject(message.getBytes());
    }

    private ModtagBeskedInputType getObject(byte[] message) throws Exception {
        try {
            Document doc = db.parse(new ByteArrayInputStream(message));
            Node firstChild = doc.getFirstChild();
            JAXBElement<ModtagBeskedInputType> jaxbElement = unmarshaller.unmarshal(firstChild, ModtagBeskedInputType.class);
            return jaxbElement.getValue();
        } catch (JAXBException | SAXException | IOException e) {
            throw new Exception("Unable to create ModtagBeskedInputType unmarshaller" + e);
        }
    }

}
