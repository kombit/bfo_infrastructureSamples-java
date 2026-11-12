
package oio.sts.beskedfordeler._1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import oio.sagdok._3_0.BasicOutputType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oio.sts.beskedfordeler._1_0 package. 
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

    private final static QName _AfsendBeskedInput_QNAME = new QName("urn:oio:sts:beskedfordeler:1.0.0", "AfsendBeskedInput");
    private final static QName _AfsendBeskedOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:1.0.0", "AfsendBeskedOutput");
    private final static QName _FlytBeskedTilFejlkoeInput_QNAME = new QName("urn:oio:sts:beskedfordeler:1.0.0", "FlytBeskedTilFejlkoeInput");
    private final static QName _FlytBeskedTilFejlkoeOutput_QNAME = new QName("urn:oio:sts:beskedfordeler:1.0.0", "FlytBeskedTilFejlkoeOutput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oio.sts.beskedfordeler._1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AfsendBeskedInputType }
     * 
     */
    public AfsendBeskedInputType createAfsendBeskedInputType() {
        return new AfsendBeskedInputType();
    }

    /**
     * Create an instance of {@link FlytBeskedTilFejlkoeInputType }
     * 
     */
    public FlytBeskedTilFejlkoeInputType createFlytBeskedTilFejlkoeInputType() {
        return new FlytBeskedTilFejlkoeInputType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfsendBeskedInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AfsendBeskedInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:1.0.0", name = "AfsendBeskedInput")
    public JAXBElement<AfsendBeskedInputType> createAfsendBeskedInput(AfsendBeskedInputType value) {
        return new JAXBElement<AfsendBeskedInputType>(_AfsendBeskedInput_QNAME, AfsendBeskedInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:1.0.0", name = "AfsendBeskedOutput")
    public JAXBElement<BasicOutputType> createAfsendBeskedOutput(BasicOutputType value) {
        return new JAXBElement<BasicOutputType>(_AfsendBeskedOutput_QNAME, BasicOutputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlytBeskedTilFejlkoeInputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FlytBeskedTilFejlkoeInputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:1.0.0", name = "FlytBeskedTilFejlkoeInput")
    public JAXBElement<FlytBeskedTilFejlkoeInputType> createFlytBeskedTilFejlkoeInput(FlytBeskedTilFejlkoeInputType value) {
        return new JAXBElement<FlytBeskedTilFejlkoeInputType>(_FlytBeskedTilFejlkoeInput_QNAME, FlytBeskedTilFejlkoeInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicOutputType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicOutputType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oio:sts:beskedfordeler:1.0.0", name = "FlytBeskedTilFejlkoeOutput")
    public JAXBElement<BasicOutputType> createFlytBeskedTilFejlkoeOutput(BasicOutputType value) {
        return new JAXBElement<BasicOutputType>(_FlytBeskedTilFejlkoeOutput_QNAME, BasicOutputType.class, null, value);
    }

}
