package dk.kombit.samples.beskedfordeler.soap;

import dk.kombit.samples.beskedfordeler.utils.ClientProperties;
import dk.kombit.vl.beskedfordeler.wsdl._1_0_0.Beskedfordeler;
import dk.kombit.vl.beskedfordeler.wsdl._1_0_0.BeskedfordelerPortType;
import oio.sagdok._3_0.ListInputType;
import oio.sagdok._3_0.UuidNoteInputType;
import oio.sts.beskedfordeler.vaerdiliste._1_0.*;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduitConfigurer;

import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;
import java.util.UUID;

import static dk.kombit.samples.beskedfordeler.soap.SoapHelper.createTlsClientParameters;
import static dk.kombit.samples.beskedfordeler.soap.SoapHelper.loadFromFile;
import static dk.kombit.samples.beskedfordeler.soap.SoapHelper.loadKeyStore;
import static dk.kombit.samples.beskedfordeler.soap.SoapHelper.validateXML;

/**
 * Class for handling requests/response to VaerdilisteService
 */
public class VaerdilisteServiceClient {

    private static final ClientProperties clientProperties = ClientProperties.getInstance();
    private static final String KEYSTORE_FILENAME = clientProperties.getKeystoreFilename();
    private static final String KEYSTORE_PASSWORD = clientProperties.getKeystorePassword();
    private static final String TRUSTSTORE_FILENAME = clientProperties.getTruststoreFilename();
    private static final String TRUSTSTORE_PASSWORD = clientProperties.getTruststorePassword();
    private static final String BESKEDFORDELER_HOSTNAME = clientProperties.getBeskedfordelerHostname();
    private static final String SERVICE_URL = "https://" + BESKEDFORDELER_HOSTNAME + "/sts-bf-soap/StsbeskedfordelerImpl";
    private static final String SCHEMA_FILE_PATH = "src\\main\\resources\\beskedfordeler\\xsd\\VaerdilisteOperationer.xsd";
    private static VaerdilisteServiceClient vaerdilisteServiceClient;
    private static BeskedfordelerPortType port;

    private Beskedfordeler beskedfordeler;

    public VaerdilisteServiceClient() throws GeneralSecurityException, IOException {
        beskedfordeler = new Beskedfordeler();
        port = beskedfordeler.getStsbeskedfordeler();

        Client cl = ClientProxy.getClient(port);

        cl.getInInterceptors().add(new LoggingInInterceptor());
        cl.getOutInterceptors().add(new LoggingOutInterceptor());

        final TLSClientParameters tcp = createTlsClientParameters(
                loadKeyStore(KEYSTORE_FILENAME, KEYSTORE_PASSWORD),
                loadKeyStore(TRUSTSTORE_FILENAME, TRUSTSTORE_PASSWORD)
        );

        cl.getBus().setExtension((s, s1, httpConduit) -> httpConduit.setTlsClientParameters(tcp), HTTPConduitConfigurer.class);
        cl.getBus().getFeatures().add(new LoggingFeature());

        ((BindingProvider)port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, SERVICE_URL);
    }

    /**
     * Method that allow other classes to get an instance of VaerdilisteServiceClient
     * to avoid creating multiple instances of the same class
     * If an instance of VaerdilisteService does not exist, one is created
     *
     * @return Instance of VaerdilisteService
     */
    public static VaerdilisteServiceClient getVaerdilisteServiceClient() throws GeneralSecurityException, IOException {
        if (vaerdilisteServiceClient == null)
            vaerdilisteServiceClient = new VaerdilisteServiceClient();
        return vaerdilisteServiceClient;
    }

    /**
     * Create vaerdiliste based on the xml request file.
     */
    public static void createVaerdiliste() throws JAXBException {
        String filePath = "src/main/resources/example_messages/vaerdiliste_opret.xml";
        validateXML(filePath, SCHEMA_FILE_PATH);
        OpretInputType opretInput = loadFromFile(OpretInputType.class, filePath);
        overrideListName(opretInput);

        port.opretvaerdiliste(opretInput);
    }

    /**
     * Modify vaerdiliste based on the xml request file.
     */
    public static void modifyVaerdiliste() throws JAXBException {
        String filePath = "src/main/resources/example_messages/vaerdiliste_tilfoejvaerdier.xml";
        validateXML(filePath, SCHEMA_FILE_PATH);
        TilfoejVaerdierInputType tilfoejVaerdierInput = loadFromFile(TilfoejVaerdierInputType.class, filePath);
        setupMessage(tilfoejVaerdierInput);

        port.tilfoejvaerdier(tilfoejVaerdierInput);
    }

    /**
     * Delete vaerdiliste based on the xml request file.
     */
    public static void deleteVaerdiliste() throws JAXBException {
        String filePath = "src/main/resources/example_messages/vaerdiliste_slet.xml";
        validateXML(filePath, SCHEMA_FILE_PATH);
        UuidNoteInputType uuidNoteInput = loadFromFile(UuidNoteInputType.class, filePath);
        setupMessage(uuidNoteInput);

        port.sletvaerdiliste(uuidNoteInput);
    }

    /**
     * List vaerdiliste based on the xml request file.
     */
    public static void listVaerdiliste() throws JAXBException {
        String filePath = "src/main/resources/example_messages/vaerdiliste_list.xml";
        validateXML(filePath, SCHEMA_FILE_PATH);
        ListInputType listInput = loadFromFile(ListInputType.class, filePath);
        setupMessage(listInput);

        port.listvaerdiliste(listInput);
    }

    /**
     * Modifies message with random list name.
     * It adds integer number  from [1, 9999] range
     * at the end of "Test list" string
     * and overrides vaerdiliste name with this string.
     *
     * This method is used only for demonstration purpose, to simplify usage of code examples.
     *
     * @param opretInput Input object to modify
     */
    private static void overrideListName(OpretInputType opretInput) {
        int randomInt = (int) Math.floor(Math.random()*(9999)+1);
        String listName = "Test list " + randomInt;
        opretInput.getAttributListe().getEgenskab().get(0).getVaerdiliste().setNavn(listName);
    }

    /**
     * Modifies message with appropriate input value
     * provided by the user.
     * If value is blank, no modification take place.
     *
     * This method is used only for demonstration purpose, to simplify usage of code examples.
     *
     * @param input Input object to modify
     */
    private static <T> void setupMessage(T input) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================");
        System.out.print("Enter vaerdiliste uuid or leave blank: ");
        String uuid = sc.nextLine();

        if (!uuid.isEmpty()) {
            while (!isUUID(uuid)) {
                System.out.print("Wrong UUID format. PLease try again. Enter vaerdiliste uuid or leave blank: ");
                uuid = sc.nextLine();
            }

            if (input instanceof ListInputType) {
                ListInputType listInput = (ListInputType)input;
                listInput.getUUIDIdentifikator().add(uuid);
            }
            if (input instanceof UuidNoteInputType) {
                UuidNoteInputType uuidNoteInput = (UuidNoteInputType)input;
                uuidNoteInput.setUUIDIdentifikator(uuid);
            }
            if (input instanceof TilfoejVaerdierInputType) {
                TilfoejVaerdierInputType tilfoejVaerdierInput = (TilfoejVaerdierInputType)input;
                tilfoejVaerdierInput.setUUIDIdentifikator(uuid);
            }
        }
    }

    /**
     * Validates whether input string is a valid UUID.
     * If yes returns true.
     * Returns false otherwise.
     *
     * This method is used only for demonstration purpose, to simplify usage of code examples.
     *
     * @param uuid string to validate
     * @return true or false
     */
    private static boolean isUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
