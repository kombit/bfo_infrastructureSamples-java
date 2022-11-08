package dk.kombit.samples.beskedfordeler.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

public class SoapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);

    /**
     * Method supporting the mechanics of the program
     *
     * @throws IOException
     * @throws JAXBException
     * @throws GeneralSecurityException
     */
    private void run()
            throws IOException, JAXBException, GeneralSecurityException {
        VaerdilisteServiceClient.getVaerdilisteServiceClient();
        UserInterface userInterface = new UserInterface();
        boolean run = true;
        while (run) {
            run = userInterface.showUserInterface();
        }
    }

    /**
     * Main method of the examples
     *
     * @param args
     * @throws IOException
     * @throws JAXBException
     * @throws GeneralSecurityException
     */
    public static void main(String[] args)
            throws IOException, JAXBException, GeneralSecurityException {
        LOGGER.info("main: Startup time: {}", (new Date()));

        LOGGER.info("main: Run example...");
        new SoapClient().run();

        LOGGER.info("main: Exit time: {}", (new Date()));
    }
}
