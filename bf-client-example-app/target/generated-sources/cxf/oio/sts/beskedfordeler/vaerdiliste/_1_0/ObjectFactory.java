
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import oio.sagdok._3_0.LaesInputType;
import oio.sagdok._3_0.ListInputType;
import oio.sagdok._3_0.SoegOutputType;
import oio.sagdok._3_0.UuidNoteInputType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oio.sts.beskedfordeler.vaerdiliste._1_0 package. 
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

    private final static QName _Vaerdiliste_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "Vaerdiliste");
    private final static QName _AttributListe_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "AttributListe");
    private final static QName _TilstandListe_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "TilstandListe");
    private final static QName _RelationListe_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "RelationListe");
    private final static QName _Registrering_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "Registrering");
    private final static QName _Egenskab_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "Egenskab");
    private final static QName _ImportInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "ImportInput");
    private final static QName _ImportOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "ImportOutput");
    private final static QName _PassiverInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "PassiverInput");
    private final static QName _PassiverOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "PassiverOutput");
    private final static QName _SletInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SletInput");
    private final static QName _SletOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SletOutput");
    private final static QName _OpretInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "OpretInput");
    private final static QName _OpretOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "OpretOutput");
    private final static QName _RetInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "RetInput");
    private final static QName _RetOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "RetOutput");
    private final static QName _LaesInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "LaesInput");
    private final static QName _LaesOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "LaesOutput");
    private final static QName _ListInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "ListInput");
    private final static QName _ListOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "ListOutput");
    private final static QName _SoegInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegInput");
    private final static QName _SoegOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegOutput");
    private final static QName _RegistreringBesked_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "RegistreringBesked");
    private final static QName _RegistreringOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "RegistreringOutput");
    private final static QName _LaesResultat_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "LaesResultat");
    private final static QName _SoegObjekt_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegObjekt");
    private final static QName _FiltreretOejebliksbillede_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "FiltreretOejebliksbillede");
    private final static QName _SoegAttributListe_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegAttributListe");
    private final static QName _SoegTilstandListe_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegTilstandListe");
    private final static QName _SoegRelationListe_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegRelationListe");
    private final static QName _SoegEgenskab_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "SoegEgenskab");
    private final static QName _TilfoejVaerdierInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "TilfoejVaerdierInput");
    private final static QName _TilfoejVaerdierOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "TilfoejVaerdierOutput");
    private final static QName _FjernVaerdierInput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "FjernVaerdierInput");
    private final static QName _FjernVaerdierOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", "FjernVaerdierOutput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oio.sts.beskedfordeler.vaerdiliste._1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VaerdilisteType }
     * 
     */
    public VaerdilisteType createVaerdilisteType() {
        return new VaerdilisteType();
    }

    /**
     * Create an instance of {@link AttributListeType }
     * 
     */
    public AttributListeType createAttributListeType() {
        return new AttributListeType();
    }

    /**
     * Create an instance of {@link TilstandListeType }
     * 
     */
    public TilstandListeType createTilstandListeType() {
        return new TilstandListeType();
    }

    /**
     * Create an instance of {@link RelationListeType }
     * 
     */
    public RelationListeType createRelationListeType() {
        return new RelationListeType();
    }

    /**
     * Create an instance of {@link RegistreringType }
     * 
     */
    public RegistreringType createRegistreringType() {
        return new RegistreringType();
    }

    /**
     * Create an instance of {@link EgenskabType }
     * 
     */
    public EgenskabType createEgenskabType() {
        return new EgenskabType();
    }

    /**
     * Create an instance of {@link ImportInputType }
     * 
     */
    public ImportInputType createImportInputType() {
        return new ImportInputType();
    }

    /**
     * Create an instance of {@link RegistreringOutputType }
     * 
     */
    public RegistreringOutputType createRegistreringOutputType() {
        return new RegistreringOutputType();
    }

    /**
     * Create an instance of {@link OpretInputType }
     * 
     */
    public OpretInputType createOpretInputType() {
        return new OpretInputType();
    }

    /**
     * Create an instance of {@link OpretOutputType }
     * 
     */
    public OpretOutputType createOpretOutputType() {
        return new OpretOutputType();
    }

    /**
     * Create an instance of {@link RetInputType }
     * 
     */
    public RetInputType createRetInputType() {
        return new RetInputType();
    }

    /**
     * Create an instance of {@link LaesOutputType }
     * 
     */
    public LaesOutputType createLaesOutputType() {
        return new LaesOutputType();
    }

    /**
     * Create an instance of {@link ListOutputType }
     * 
     */
    public ListOutputType createListOutputType() {
        return new ListOutputType();
    }

    /**
     * Create an instance of {@link SoegInputType }
     * 
     */
    public SoegInputType createSoegInputType() {
        return new SoegInputType();
    }

    /**
     * Create an instance of {@link RegistreringBeskedType }
     * 
     */
    public RegistreringBeskedType createRegistreringBeskedType() {
        return new RegistreringBeskedType();
    }

    /**
     * Create an instance of {@link LaesResultatType }
     * 
     */
    public LaesResultatType createLaesResultatType() {
        return new LaesResultatType();
    }

    /**
     * Create an instance of {@link SoegObjektType }
     * 
     */
    public SoegObjektType createSoegObjektType() {
        return new SoegObjektType();
    }

    /**
     * Create an instance of {@link FiltreretOejebliksbilledeType }
     * 
     */
    public FiltreretOejebliksbilledeType createFiltreretOejebliksbilledeType() {
        return new FiltreretOejebliksbilledeType();
    }

    /**
     * Create an instance of {@link SoegAttributListeType }
     * 
     */
    public SoegAttributListeType createSoegAttributListeType() {
        return new SoegAttributListeType();
    }

    /**
     * Create an instance of {@link SoegTilstandListeType }
     * 
     */
    public SoegTilstandListeType createSoegTilstandListeType() {
        return new SoegTilstandListeType();
    }

    /**
     * Create an instance of {@link SoegRelationListeType }
     * 
     */
    public SoegRelationListeType createSoegRelationListeType() {
        return new SoegRelationListeType();
    }

    /**
     * Create an instance of {@link SoegEgenskabType }
     * 
     */
    public SoegEgenskabType createSoegEgenskabType() {
        return new SoegEgenskabType();
    }

    /**
     * Create an instance of {@link TilfoejVaerdierInputType }
     * 
     */
    public TilfoejVaerdierInputType createTilfoejVaerdierInputType() {
        return new TilfoejVaerdierInputType();
    }

    /**
     * Create an instance of {@link TilfoejVaerdierOutputType }
     * 
     */
    public TilfoejVaerdierOutputType createTilfoejVaerdierOutputType() {
        return new TilfoejVaerdierOutputType();
    }

    /**
     * Create an instance of {@link FjernVaerdierInputType }
     * 
     */
    public FjernVaerdierInputType createFjernVaerdierInputType() {
        return new FjernVaerdierInputType();
    }

    /**
     * Create an instance of {@link FjernVaerdierOutputType }
     * 
     */
    public FjernVaerdierOutputType createFjernVaerdierOutputType() {
        return new FjernVaerdierOutputType();
    }

    /**
     * Create an instance of {@link VaerdiElementType }
     * 
     */
    public VaerdiElementType createVaerdiElementType() {
        return new VaerdiElementType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VaerdilisteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VaerdilisteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "Vaerdiliste")
    public JAXBElement<VaerdilisteType> createVaerdiliste(VaerdilisteType value) {
        return new JAXBElement<VaerdilisteType>(_Vaerdiliste_QNAME, VaerdilisteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributListeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AttributListeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "AttributListe")
    public JAXBElement<AttributListeType> createAttributListe(AttributListeType value) {
        return new JAXBElement<AttributListeType>(_AttributListe_QNAME, AttributListeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TilstandListeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TilstandListeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "TilstandListe")
    public JAXBElement<TilstandListeType> createTilstandListe(TilstandListeType value) {
        return new JAXBElement<TilstandListeType>(_TilstandListe_QNAME, TilstandListeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelationListeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelationListeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "RelationListe")
    public JAXBElement<RelationListeType> createRelationListe(RelationListeType value) {
        return new JAXBElement<RelationListeType>(_RelationListe_QNAME, RelationListeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "Registrering")
    public JAXBElement<RegistreringType> createRegistrering(RegistreringType value) {
        return new JAXBElement<RegistreringType>(_Registrering_QNAME, RegistreringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EgenskabType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EgenskabType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "Egenskab")
    public JAXBElement<EgenskabType> createEgenskab(EgenskabType value) {
        return new JAXBElement<EgenskabType>(_Egenskab_QNAME, EgenskabType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImportInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "ImportInput")
    public JAXBElement<ImportInputType> createImportInput(ImportInputType value) {
        return new JAXBElement<ImportInputType>(_ImportInput_QNAME, ImportInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "ImportOutput")
    public JAXBElement<RegistreringOutputType> createImportOutput(RegistreringOutputType value) {
        return new JAXBElement<RegistreringOutputType>(_ImportOutput_QNAME, RegistreringOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UuidNoteInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UuidNoteInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "PassiverInput")
    public JAXBElement<UuidNoteInputType> createPassiverInput(UuidNoteInputType value) {
        return new JAXBElement<UuidNoteInputType>(_PassiverInput_QNAME, UuidNoteInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "PassiverOutput")
    public JAXBElement<RegistreringOutputType> createPassiverOutput(RegistreringOutputType value) {
        return new JAXBElement<RegistreringOutputType>(_PassiverOutput_QNAME, RegistreringOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UuidNoteInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UuidNoteInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SletInput")
    public JAXBElement<UuidNoteInputType> createSletInput(UuidNoteInputType value) {
        return new JAXBElement<UuidNoteInputType>(_SletInput_QNAME, UuidNoteInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SletOutput")
    public JAXBElement<RegistreringOutputType> createSletOutput(RegistreringOutputType value) {
        return new JAXBElement<RegistreringOutputType>(_SletOutput_QNAME, RegistreringOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpretInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OpretInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "OpretInput")
    public JAXBElement<OpretInputType> createOpretInput(OpretInputType value) {
        return new JAXBElement<OpretInputType>(_OpretInput_QNAME, OpretInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpretOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OpretOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "OpretOutput")
    public JAXBElement<OpretOutputType> createOpretOutput(OpretOutputType value) {
        return new JAXBElement<OpretOutputType>(_OpretOutput_QNAME, OpretOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "RetInput")
    public JAXBElement<RetInputType> createRetInput(RetInputType value) {
        return new JAXBElement<RetInputType>(_RetInput_QNAME, RetInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "RetOutput")
    public JAXBElement<RegistreringOutputType> createRetOutput(RegistreringOutputType value) {
        return new JAXBElement<RegistreringOutputType>(_RetOutput_QNAME, RegistreringOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaesInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LaesInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "LaesInput")
    public JAXBElement<LaesInputType> createLaesInput(LaesInputType value) {
        return new JAXBElement<LaesInputType>(_LaesInput_QNAME, LaesInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaesOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LaesOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "LaesOutput")
    public JAXBElement<LaesOutputType> createLaesOutput(LaesOutputType value) {
        return new JAXBElement<LaesOutputType>(_LaesOutput_QNAME, LaesOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "ListInput")
    public JAXBElement<ListInputType> createListInput(ListInputType value) {
        return new JAXBElement<ListInputType>(_ListInput_QNAME, ListInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "ListOutput")
    public JAXBElement<ListOutputType> createListOutput(ListOutputType value) {
        return new JAXBElement<ListOutputType>(_ListOutput_QNAME, ListOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegInput")
    public JAXBElement<SoegInputType> createSoegInput(SoegInputType value) {
        return new JAXBElement<SoegInputType>(_SoegInput_QNAME, SoegInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegOutput")
    public JAXBElement<SoegOutputType> createSoegOutput(SoegOutputType value) {
        return new JAXBElement<SoegOutputType>(_SoegOutput_QNAME, SoegOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringBeskedType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringBeskedType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "RegistreringBesked")
    public JAXBElement<RegistreringBeskedType> createRegistreringBesked(RegistreringBeskedType value) {
        return new JAXBElement<RegistreringBeskedType>(_RegistreringBesked_QNAME, RegistreringBeskedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistreringOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "RegistreringOutput")
    public JAXBElement<RegistreringOutputType> createRegistreringOutput(RegistreringOutputType value) {
        return new JAXBElement<RegistreringOutputType>(_RegistreringOutput_QNAME, RegistreringOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaesResultatType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LaesResultatType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "LaesResultat")
    public JAXBElement<LaesResultatType> createLaesResultat(LaesResultatType value) {
        return new JAXBElement<LaesResultatType>(_LaesResultat_QNAME, LaesResultatType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegObjektType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegObjektType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegObjekt")
    public JAXBElement<SoegObjektType> createSoegObjekt(SoegObjektType value) {
        return new JAXBElement<SoegObjektType>(_SoegObjekt_QNAME, SoegObjektType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FiltreretOejebliksbilledeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FiltreretOejebliksbilledeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "FiltreretOejebliksbillede")
    public JAXBElement<FiltreretOejebliksbilledeType> createFiltreretOejebliksbillede(FiltreretOejebliksbilledeType value) {
        return new JAXBElement<FiltreretOejebliksbilledeType>(_FiltreretOejebliksbillede_QNAME, FiltreretOejebliksbilledeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegAttributListeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegAttributListeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegAttributListe")
    public JAXBElement<SoegAttributListeType> createSoegAttributListe(SoegAttributListeType value) {
        return new JAXBElement<SoegAttributListeType>(_SoegAttributListe_QNAME, SoegAttributListeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegTilstandListeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegTilstandListeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegTilstandListe")
    public JAXBElement<SoegTilstandListeType> createSoegTilstandListe(SoegTilstandListeType value) {
        return new JAXBElement<SoegTilstandListeType>(_SoegTilstandListe_QNAME, SoegTilstandListeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegRelationListeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegRelationListeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegRelationListe")
    public JAXBElement<SoegRelationListeType> createSoegRelationListe(SoegRelationListeType value) {
        return new JAXBElement<SoegRelationListeType>(_SoegRelationListe_QNAME, SoegRelationListeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoegEgenskabType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoegEgenskabType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "SoegEgenskab")
    public JAXBElement<SoegEgenskabType> createSoegEgenskab(SoegEgenskabType value) {
        return new JAXBElement<SoegEgenskabType>(_SoegEgenskab_QNAME, SoegEgenskabType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TilfoejVaerdierInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TilfoejVaerdierInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "TilfoejVaerdierInput")
    public JAXBElement<TilfoejVaerdierInputType> createTilfoejVaerdierInput(TilfoejVaerdierInputType value) {
        return new JAXBElement<TilfoejVaerdierInputType>(_TilfoejVaerdierInput_QNAME, TilfoejVaerdierInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TilfoejVaerdierOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TilfoejVaerdierOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "TilfoejVaerdierOutput")
    public JAXBElement<TilfoejVaerdierOutputType> createTilfoejVaerdierOutput(TilfoejVaerdierOutputType value) {
        return new JAXBElement<TilfoejVaerdierOutputType>(_TilfoejVaerdierOutput_QNAME, TilfoejVaerdierOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FjernVaerdierInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FjernVaerdierInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "FjernVaerdierInput")
    public JAXBElement<FjernVaerdierInputType> createFjernVaerdierInput(FjernVaerdierInputType value) {
        return new JAXBElement<FjernVaerdierInputType>(_FjernVaerdierInput_QNAME, FjernVaerdierInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FjernVaerdierOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FjernVaerdierOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0", name = "FjernVaerdierOutput")
    public JAXBElement<FjernVaerdierOutputType> createFjernVaerdierOutput(FjernVaerdierOutputType value) {
        return new JAXBElement<FjernVaerdierOutputType>(_FjernVaerdierOutput_QNAME, FjernVaerdierOutputType.class, null, value);
    }

}
