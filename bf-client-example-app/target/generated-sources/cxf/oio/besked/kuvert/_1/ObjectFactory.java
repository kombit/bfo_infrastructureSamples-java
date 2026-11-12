
package oio.besked.kuvert._1;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import oio.sagdok._3_0.TidspunktType;
import oio.sagdok._3_0.UnikIdType;
import oio.sagdok.organisation._2_0.AktoerType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oio.besked.kuvert._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Haendelsesbesked_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Haendelsesbesked");
    private final static QName _BeskedId_QNAME = new QName("urn:oio:besked:kuvert:1.0", "BeskedId");
    private final static QName _BeskedVersion_QNAME = new QName("urn:oio:besked:kuvert:1.0", "BeskedVersion");
    private final static QName _Beskedkuvert_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Beskedkuvert");
    private final static QName _GyldighedFra_QNAME = new QName("urn:oio:besked:kuvert:1.0", "GyldighedFra");
    private final static QName _GyldighedTil_QNAME = new QName("urn:oio:besked:kuvert:1.0", "GyldighedTil");
    private final static QName _Beskeddata_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Beskeddata");
    private final static QName _LeveranceinformationLokalUdvidelse_QNAME = new QName("urn:oio:besked:kuvert:1.0", "LeveranceinformationLokalUdvidelse");
    private final static QName _LeveranceruteLokalUdvidelse_QNAME = new QName("urn:oio:besked:kuvert:1.0", "LeveranceruteLokalUdvidelse");
    private final static QName _ObjektRegistreringLokalUdvidelse_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektRegistreringLokalUdvidelse");
    private final static QName _BeskedfordelerSignatur_QNAME = new QName("urn:oio:besked:kuvert:1.0", "BeskedfordelerSignatur");
    private final static QName _Modtagerhandling_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Modtagerhandling");
    private final static QName _Handling_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Handling");
    private final static QName _Responsmodtager_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Responsmodtager");
    private final static QName _Filtreringsdata_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Filtreringsdata");
    private final static QName _Beskedtype_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Beskedtype");
    private final static QName _BeskedAnsvarligAktoer_QNAME = new QName("urn:oio:besked:kuvert:1.0", "BeskedAnsvarligAktoer");
    private final static QName _TilladtModtager_QNAME = new QName("urn:oio:besked:kuvert:1.0", "TilladtModtager");
    private final static QName _TvaergaaendeProces_QNAME = new QName("urn:oio:besked:kuvert:1.0", "TvaergaaendeProces");
    private final static QName _RelateretObjekt_QNAME = new QName("urn:oio:besked:kuvert:1.0", "RelateretObjekt");
    private final static QName _ObjektId_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektId");
    private final static QName _ObjektType_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektType");
    private final static QName _ObjektRolle_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektRolle");
    private final static QName _Leveranceinformation_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Leveranceinformation");
    private final static QName _Dannelsestidspunkt_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Dannelsestidspunkt");
    private final static QName _TransaktionsId_QNAME = new QName("urn:oio:besked:kuvert:1.0", "TransaktionsId");
    private final static QName _Kildesystem_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Kildesystem");
    private final static QName _KildesystemIPAdresse_QNAME = new QName("urn:oio:besked:kuvert:1.0", "KildesystemIPAdresse");
    private final static QName _KildesystemAkkreditiver_QNAME = new QName("urn:oio:besked:kuvert:1.0", "KildesystemAkkreditiver");
    private final static QName _Sikkerhedsklassificering_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Sikkerhedsklassificering");
    private final static QName _Leveranceruter_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Leveranceruter");
    private final static QName _Leverancerute_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Leverancerute");
    private final static QName _Fordelingssystem_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Fordelingssystem");
    private final static QName _ModtagelsesTidspunkt_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ModtagelsesTidspunkt");
    private final static QName _LeveranceTidspunkt_QNAME = new QName("urn:oio:besked:kuvert:1.0", "LeveranceTidspunkt");
    private final static QName _ModtagetFraSystem_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ModtagetFraSystem");
    private final static QName _ErLeveretIHenholdTil_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ErLeveretIHenholdTil");
    private final static QName _AntalLeveranceforsoeg_QNAME = new QName("urn:oio:besked:kuvert:1.0", "AntalLeveranceforsoeg");
    private final static QName _ObjektRegistrering_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektRegistrering");
    private final static QName _AfsenderSystemSignatur_QNAME = new QName("urn:oio:besked:kuvert:1.0", "AfsenderSystemSignatur");
    private final static QName _ObjektRegistreringId_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektRegistreringId");
    private final static QName _RegistreringsAktoer_QNAME = new QName("urn:oio:besked:kuvert:1.0", "RegistreringsAktoer");
    private final static QName _Registreringstidspunkt_QNAME = new QName("urn:oio:besked:kuvert:1.0", "Registreringstidspunkt");
    private final static QName _ObjektAnsvarligMyndighed_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektAnsvarligMyndighed");
    private final static QName _ObjektHandling_QNAME = new QName("urn:oio:besked:kuvert:1.0", "ObjektHandling");
    private final static QName _OpgaveEmne_QNAME = new QName("urn:oio:besked:kuvert:1.0", "OpgaveEmne");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oio.besked.kuvert._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HaendelsesbeskedType }
     * 
     */
    public HaendelsesbeskedType createHaendelsesbeskedType() {
        return new HaendelsesbeskedType();
    }

    /**
     * Create an instance of {@link BeskedkuvertType }
     * 
     */
    public BeskedkuvertType createBeskedkuvertType() {
        return new BeskedkuvertType();
    }

    /**
     * Create an instance of {@link BeskeddataType }
     * 
     */
    public BeskeddataType createBeskeddataType() {
        return new BeskeddataType();
    }

    /**
     * Create an instance of {@link LeveranceinformationLokalUdvidelseType }
     * 
     */
    public LeveranceinformationLokalUdvidelseType createLeveranceinformationLokalUdvidelseType() {
        return new LeveranceinformationLokalUdvidelseType();
    }

    /**
     * Create an instance of {@link LeveranceruteLokalUdvidelseType }
     * 
     */
    public LeveranceruteLokalUdvidelseType createLeveranceruteLokalUdvidelseType() {
        return new LeveranceruteLokalUdvidelseType();
    }

    /**
     * Create an instance of {@link ObjektRegistreringLokalUdvidelseType }
     * 
     */
    public ObjektRegistreringLokalUdvidelseType createObjektRegistreringLokalUdvidelseType() {
        return new ObjektRegistreringLokalUdvidelseType();
    }

    /**
     * Create an instance of {@link BeskedfordelerSignaturType }
     * 
     */
    public BeskedfordelerSignaturType createBeskedfordelerSignaturType() {
        return new BeskedfordelerSignaturType();
    }

    /**
     * Create an instance of {@link ModtagerhandlingType }
     * 
     */
    public ModtagerhandlingType createModtagerhandlingType() {
        return new ModtagerhandlingType();
    }

    /**
     * Create an instance of {@link FiltreringsdataType }
     * 
     */
    public FiltreringsdataType createFiltreringsdataType() {
        return new FiltreringsdataType();
    }

    /**
     * Create an instance of {@link RelateretObjektType }
     * 
     */
    public RelateretObjektType createRelateretObjektType() {
        return new RelateretObjektType();
    }

    /**
     * Create an instance of {@link LeveranceinformationType }
     * 
     */
    public LeveranceinformationType createLeveranceinformationType() {
        return new LeveranceinformationType();
    }

    /**
     * Create an instance of {@link LeveranceruterType }
     * 
     */
    public LeveranceruterType createLeveranceruterType() {
        return new LeveranceruterType();
    }

    /**
     * Create an instance of {@link LeveranceruteType }
     * 
     */
    public LeveranceruteType createLeveranceruteType() {
        return new LeveranceruteType();
    }

    /**
     * Create an instance of {@link ObjektRegistreringType }
     * 
     */
    public ObjektRegistreringType createObjektRegistreringType() {
        return new ObjektRegistreringType();
    }

    /**
     * Create an instance of {@link AfsenderSystemSignaturType }
     * 
     */
    public AfsenderSystemSignaturType createAfsenderSystemSignaturType() {
        return new AfsenderSystemSignaturType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HaendelsesbeskedType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HaendelsesbeskedType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Haendelsesbesked")
    public JAXBElement<HaendelsesbeskedType> createHaendelsesbesked(HaendelsesbeskedType value) {
        return new JAXBElement<HaendelsesbeskedType>(_Haendelsesbesked_QNAME, HaendelsesbeskedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "BeskedId")
    public JAXBElement<UnikIdType> createBeskedId(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_BeskedId_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "BeskedVersion")
    public JAXBElement<String> createBeskedVersion(String value) {
        return new JAXBElement<String>(_BeskedVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeskedkuvertType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BeskedkuvertType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Beskedkuvert")
    public JAXBElement<BeskedkuvertType> createBeskedkuvert(BeskedkuvertType value) {
        return new JAXBElement<BeskedkuvertType>(_Beskedkuvert_QNAME, BeskedkuvertType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "GyldighedFra")
    public JAXBElement<TidspunktType> createGyldighedFra(TidspunktType value) {
        return new JAXBElement<TidspunktType>(_GyldighedFra_QNAME, TidspunktType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "GyldighedTil")
    public JAXBElement<TidspunktType> createGyldighedTil(TidspunktType value) {
        return new JAXBElement<TidspunktType>(_GyldighedTil_QNAME, TidspunktType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeskeddataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BeskeddataType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Beskeddata")
    public JAXBElement<BeskeddataType> createBeskeddata(BeskeddataType value) {
        return new JAXBElement<BeskeddataType>(_Beskeddata_QNAME, BeskeddataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeveranceinformationLokalUdvidelseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LeveranceinformationLokalUdvidelseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "LeveranceinformationLokalUdvidelse")
    public JAXBElement<LeveranceinformationLokalUdvidelseType> createLeveranceinformationLokalUdvidelse(LeveranceinformationLokalUdvidelseType value) {
        return new JAXBElement<LeveranceinformationLokalUdvidelseType>(_LeveranceinformationLokalUdvidelse_QNAME, LeveranceinformationLokalUdvidelseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeveranceruteLokalUdvidelseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LeveranceruteLokalUdvidelseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "LeveranceruteLokalUdvidelse")
    public JAXBElement<LeveranceruteLokalUdvidelseType> createLeveranceruteLokalUdvidelse(LeveranceruteLokalUdvidelseType value) {
        return new JAXBElement<LeveranceruteLokalUdvidelseType>(_LeveranceruteLokalUdvidelse_QNAME, LeveranceruteLokalUdvidelseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjektRegistreringLokalUdvidelseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObjektRegistreringLokalUdvidelseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektRegistreringLokalUdvidelse")
    public JAXBElement<ObjektRegistreringLokalUdvidelseType> createObjektRegistreringLokalUdvidelse(ObjektRegistreringLokalUdvidelseType value) {
        return new JAXBElement<ObjektRegistreringLokalUdvidelseType>(_ObjektRegistreringLokalUdvidelse_QNAME, ObjektRegistreringLokalUdvidelseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeskedfordelerSignaturType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BeskedfordelerSignaturType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "BeskedfordelerSignatur")
    public JAXBElement<BeskedfordelerSignaturType> createBeskedfordelerSignatur(BeskedfordelerSignaturType value) {
        return new JAXBElement<BeskedfordelerSignaturType>(_BeskedfordelerSignatur_QNAME, BeskedfordelerSignaturType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModtagerhandlingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ModtagerhandlingType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Modtagerhandling")
    public JAXBElement<ModtagerhandlingType> createModtagerhandling(ModtagerhandlingType value) {
        return new JAXBElement<ModtagerhandlingType>(_Modtagerhandling_QNAME, ModtagerhandlingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Handling")
    public JAXBElement<UnikIdType> createHandling(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_Handling_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Responsmodtager")
    public JAXBElement<AktoerType> createResponsmodtager(AktoerType value) {
        return new JAXBElement<AktoerType>(_Responsmodtager_QNAME, AktoerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FiltreringsdataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FiltreringsdataType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Filtreringsdata")
    public JAXBElement<FiltreringsdataType> createFiltreringsdata(FiltreringsdataType value) {
        return new JAXBElement<FiltreringsdataType>(_Filtreringsdata_QNAME, FiltreringsdataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Beskedtype")
    public JAXBElement<UnikIdType> createBeskedtype(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_Beskedtype_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "BeskedAnsvarligAktoer")
    public JAXBElement<AktoerType> createBeskedAnsvarligAktoer(AktoerType value) {
        return new JAXBElement<AktoerType>(_BeskedAnsvarligAktoer_QNAME, AktoerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "TilladtModtager")
    public JAXBElement<UnikIdType> createTilladtModtager(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_TilladtModtager_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "TvaergaaendeProces")
    public JAXBElement<UnikIdType> createTvaergaaendeProces(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_TvaergaaendeProces_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelateretObjektType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelateretObjektType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "RelateretObjekt")
    public JAXBElement<RelateretObjektType> createRelateretObjekt(RelateretObjektType value) {
        return new JAXBElement<RelateretObjektType>(_RelateretObjekt_QNAME, RelateretObjektType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektId")
    public JAXBElement<UnikIdType> createObjektId(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ObjektId_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektType")
    public JAXBElement<UnikIdType> createObjektType(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ObjektType_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektRolle")
    public JAXBElement<UnikIdType> createObjektRolle(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ObjektRolle_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeveranceinformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LeveranceinformationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Leveranceinformation")
    public JAXBElement<LeveranceinformationType> createLeveranceinformation(LeveranceinformationType value) {
        return new JAXBElement<LeveranceinformationType>(_Leveranceinformation_QNAME, LeveranceinformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Dannelsestidspunkt")
    public JAXBElement<TidspunktType> createDannelsestidspunkt(TidspunktType value) {
        return new JAXBElement<TidspunktType>(_Dannelsestidspunkt_QNAME, TidspunktType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "TransaktionsId")
    public JAXBElement<UnikIdType> createTransaktionsId(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_TransaktionsId_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Kildesystem")
    public JAXBElement<AktoerType> createKildesystem(AktoerType value) {
        return new JAXBElement<AktoerType>(_Kildesystem_QNAME, AktoerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "KildesystemIPAdresse")
    public JAXBElement<String> createKildesystemIPAdresse(String value) {
        return new JAXBElement<String>(_KildesystemIPAdresse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "KildesystemAkkreditiver")
    public JAXBElement<String> createKildesystemAkkreditiver(String value) {
        return new JAXBElement<String>(_KildesystemAkkreditiver_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Sikkerhedsklassificering")
    public JAXBElement<UnikIdType> createSikkerhedsklassificering(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_Sikkerhedsklassificering_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeveranceruterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LeveranceruterType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Leveranceruter")
    public JAXBElement<LeveranceruterType> createLeveranceruter(LeveranceruterType value) {
        return new JAXBElement<LeveranceruterType>(_Leveranceruter_QNAME, LeveranceruterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeveranceruteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LeveranceruteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Leverancerute")
    public JAXBElement<LeveranceruteType> createLeverancerute(LeveranceruteType value) {
        return new JAXBElement<LeveranceruteType>(_Leverancerute_QNAME, LeveranceruteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Fordelingssystem")
    public JAXBElement<UnikIdType> createFordelingssystem(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_Fordelingssystem_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ModtagelsesTidspunkt")
    public JAXBElement<TidspunktType> createModtagelsesTidspunkt(TidspunktType value) {
        return new JAXBElement<TidspunktType>(_ModtagelsesTidspunkt_QNAME, TidspunktType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "LeveranceTidspunkt")
    public JAXBElement<TidspunktType> createLeveranceTidspunkt(TidspunktType value) {
        return new JAXBElement<TidspunktType>(_LeveranceTidspunkt_QNAME, TidspunktType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ModtagetFraSystem")
    public JAXBElement<AktoerType> createModtagetFraSystem(AktoerType value) {
        return new JAXBElement<AktoerType>(_ModtagetFraSystem_QNAME, AktoerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ErLeveretIHenholdTil")
    public JAXBElement<UnikIdType> createErLeveretIHenholdTil(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ErLeveretIHenholdTil_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "AntalLeveranceforsoeg")
    public JAXBElement<BigInteger> createAntalLeveranceforsoeg(BigInteger value) {
        return new JAXBElement<BigInteger>(_AntalLeveranceforsoeg_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjektRegistreringType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObjektRegistreringType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektRegistrering")
    public JAXBElement<ObjektRegistreringType> createObjektRegistrering(ObjektRegistreringType value) {
        return new JAXBElement<ObjektRegistreringType>(_ObjektRegistrering_QNAME, ObjektRegistreringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfsenderSystemSignaturType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AfsenderSystemSignaturType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "AfsenderSystemSignatur")
    public JAXBElement<AfsenderSystemSignaturType> createAfsenderSystemSignatur(AfsenderSystemSignaturType value) {
        return new JAXBElement<AfsenderSystemSignaturType>(_AfsenderSystemSignatur_QNAME, AfsenderSystemSignaturType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektRegistreringId")
    public JAXBElement<UnikIdType> createObjektRegistreringId(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ObjektRegistreringId_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AktoerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "RegistreringsAktoer")
    public JAXBElement<AktoerType> createRegistreringsAktoer(AktoerType value) {
        return new JAXBElement<AktoerType>(_RegistreringsAktoer_QNAME, AktoerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TidspunktType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "Registreringstidspunkt")
    public JAXBElement<TidspunktType> createRegistreringstidspunkt(TidspunktType value) {
        return new JAXBElement<TidspunktType>(_Registreringstidspunkt_QNAME, TidspunktType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektAnsvarligMyndighed")
    public JAXBElement<UnikIdType> createObjektAnsvarligMyndighed(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ObjektAnsvarligMyndighed_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "ObjektHandling")
    public JAXBElement<UnikIdType> createObjektHandling(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_ObjektHandling_QNAME, UnikIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnikIdType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:besked:kuvert:1.0", name = "OpgaveEmne")
    public JAXBElement<UnikIdType> createOpgaveEmne(UnikIdType value) {
        return new JAXBElement<UnikIdType>(_OpgaveEmne_QNAME, UnikIdType.class, null, value);
    }

}
