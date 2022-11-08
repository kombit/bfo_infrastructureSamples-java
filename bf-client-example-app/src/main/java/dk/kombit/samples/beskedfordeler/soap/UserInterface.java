package dk.kombit.samples.beskedfordeler.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInterface.class);

    /**
     * The showUserInterface method is responsible for showing the console based interface
     *
     * @return
     * @throws IOException
     */
    public boolean showUserInterface() throws IOException, JAXBException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chosenOption = 99; //to avoid initialization error in try catch

        System.out.println("*********************************************");
        System.out.println("Choose example:");
        System.out.println("(1) Create Vaerdiliste");
        System.out.println("(2) Modify Vaerdiliste");
        System.out.println("(3) Delete Vaerdiliste");
        System.out.println("(4) List Vaerdiliste");
        System.out.println("(0) Exit");
        System.out.print("\r\nChoose: ");

        try {
            chosenOption = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            LOGGER.debug("Wrong format: {}", e);
        }
        return control(chosenOption);
    }

    /**
     * The control method is responsible for running the examples according to the user input
     * @param choice
     *
     */
    private boolean control(int choice) throws JAXBException {
        boolean shouldContinue = true;

        switch (choice) {
            case 1: // Create Vaerdiliste (opret)
                VaerdilisteServiceClient.createVaerdiliste();
                break;
            case 2: // Modify Vaerdiliste (tilfoej)
                VaerdilisteServiceClient.modifyVaerdiliste();
                break;
            case 3: // Delete Vaerdiliste (slet)
                VaerdilisteServiceClient.deleteVaerdiliste();
                break;
            case 4: // List Vaerdiliste (list)
                VaerdilisteServiceClient.listVaerdiliste();
                break;
            case 0: //Exit
                shouldContinue = false;
                break;
            default:
                System.out.println("Error: Enter valid input");
        }
        return shouldContinue;
    }
}
