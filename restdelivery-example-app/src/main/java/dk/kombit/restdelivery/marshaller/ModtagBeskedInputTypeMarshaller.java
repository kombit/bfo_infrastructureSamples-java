package dk.kombit.restdelivery.marshaller;

import oio.sts._1_0.ModtagBeskedInputType;
import oio.sts._1_0.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

public class ModtagBeskedInputTypeMarshaller {

    private static final Logger LOG = LoggerFactory.getLogger(ModtagBeskedInputTypeMarshaller.class);

    private static JAXBContext jc = createJAXBContext();

    private static ObjectFactory objectFactory = new ObjectFactory();

    private static JAXBContext createJAXBContext() {
        try {
            return JAXBContext.newInstance(ModtagBeskedInputType.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] marshal(ModtagBeskedInputType element) {
        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            JAXBElement root = objectFactory.createModtagBeskedInput(element);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(root, baos);
            return baos.toByteArray();
        } catch (Exception e) {
            LOG.warn("Unexpected exception has occurred during marhalling", e);
        }

        return null;
    }
}
