
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.SoegVirkningType;


/**
 * <p>Java class for SoegEgenskabType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegEgenskabType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}BrugervendtNoegleTekst" minOccurs="0"/&gt;
 *         &lt;element name="Vaerdiliste" type="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}VaerdiElementType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}SoegVirkning" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegEgenskabType", propOrder = {
    "brugervendtNoegleTekst",
    "vaerdiliste",
    "soegVirkning"
})
public class SoegEgenskabType {

    @XmlElement(name = "BrugervendtNoegleTekst", namespace = "urn:oio:sagdok:3.0.0")
    protected String brugervendtNoegleTekst;
    @XmlElement(name = "Vaerdiliste")
    protected VaerdiElementType vaerdiliste;
    @XmlElement(name = "SoegVirkning", namespace = "urn:oio:sagdok:3.0.0")
    protected SoegVirkningType soegVirkning;

    /**
     * Gets the value of the brugervendtNoegleTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrugervendtNoegleTekst() {
        return brugervendtNoegleTekst;
    }

    /**
     * Sets the value of the brugervendtNoegleTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrugervendtNoegleTekst(String value) {
        this.brugervendtNoegleTekst = value;
    }

    /**
     * Gets the value of the vaerdiliste property.
     * 
     * @return
     *     possible object is
     *     {@link VaerdiElementType }
     *     
     */
    public VaerdiElementType getVaerdiliste() {
        return vaerdiliste;
    }

    /**
     * Sets the value of the vaerdiliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link VaerdiElementType }
     *     
     */
    public void setVaerdiliste(VaerdiElementType value) {
        this.vaerdiliste = value;
    }

    /**
     * Gets the value of the soegVirkning property.
     * 
     * @return
     *     possible object is
     *     {@link SoegVirkningType }
     *     
     */
    public SoegVirkningType getSoegVirkning() {
        return soegVirkning;
    }

    /**
     * Sets the value of the soegVirkning property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegVirkningType }
     *     
     */
    public void setSoegVirkning(SoegVirkningType value) {
        this.soegVirkning = value;
    }

}
