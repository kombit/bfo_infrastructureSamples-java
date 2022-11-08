package dk.kombit.restdelivery.marshaller;

import oio.sts._1_0.ModtagBeskedOutputType;
import oio.sts._1_0.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;

public class ModtagBeskedOutputTypeMarshaller {

    private static final Logger LOG = LoggerFactory.getLogger(ModtagBeskedOutputTypeMarshaller.class);

    private static JAXBContext jc = createJAXBContext();

    private static ObjectFactory objectFactory = new ObjectFactory();

    private static JAXBContext createJAXBContext() {
        try {
            return JAXBContext.newInstance(ModtagBeskedOutputType.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] marshal(ModtagBeskedOutputType element) {
        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            JAXBElement root = objectFactory.createModtagBeskedOutput(element);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(root, baos);
            return baos.toByteArray();
        } catch (Exception e) {
            LOG.warn("Unexpected exception has occurred during marhalling", e);
        }

        return null;
    }
}
