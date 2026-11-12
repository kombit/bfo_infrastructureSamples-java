
package oio.sagdok._3_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistreringType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistreringType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}FraTidspunkt"/&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}LivscyklusKode"/&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}BrugerRef" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistreringType", propOrder = {
    "fraTidspunkt",
    "livscyklusKode",
    "brugerRef"
})
@XmlSeeAlso({
    oio.sts.beskedfordeler.vaerdiliste._1_0.RegistreringType.class
})
public class RegistreringType {

    @XmlElement(name = "FraTidspunkt", required = true)
    protected TidspunktType fraTidspunkt;
    @XmlElement(name = "LivscyklusKode", required = true)
    @XmlSchemaType(name = "string")
    protected LivscyklusKodeType livscyklusKode;
    @XmlElement(name = "BrugerRef")
    protected UnikIdType brugerRef;

    /**
     * Gets the value of the fraTidspunkt property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getFraTidspunkt() {
        return fraTidspunkt;
    }

    /**
     * Sets the value of the fraTidspunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setFraTidspunkt(TidspunktType value) {
        this.fraTidspunkt = value;
    }

    /**
     * Gets the value of the livscyklusKode property.
     * 
     * @return
     *     possible object is
     *     {@link LivscyklusKodeType }
     *     
     */
    public LivscyklusKodeType getLivscyklusKode() {
        return livscyklusKode;
    }

    /**
     * Sets the value of the livscyklusKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LivscyklusKodeType }
     *     
     */
    public void setLivscyklusKode(LivscyklusKodeType value) {
        this.livscyklusKode = value;
    }

    /**
     * Gets the value of the brugerRef property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getBrugerRef() {
        return brugerRef;
    }

    /**
     * Sets the value of the brugerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setBrugerRef(UnikIdType value) {
        this.brugerRef = value;
    }

}
