
package oio.sagdok.organisation._2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.SoegVirkningType;


/**
 * <p>Java class for SoegGyldighedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegGyldighedType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sagdok:organisation:2.0.0}GyldighedStatusKode" minOccurs="0"/&gt;
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
@XmlType(name = "SoegGyldighedType", propOrder = {
    "gyldighedStatusKode",
    "soegVirkning"
})
public class SoegGyldighedType {

    @XmlElement(name = "GyldighedStatusKode")
    @XmlSchemaType(name = "string")
    protected GyldighedStatusKodeType gyldighedStatusKode;
    @XmlElement(name = "SoegVirkning", namespace = "urn:oio:sagdok:3.0.0")
    protected SoegVirkningType soegVirkning;

    /**
     * Gets the value of the gyldighedStatusKode property.
     * 
     * @return
     *     possible object is
     *     {@link GyldighedStatusKodeType }
     *     
     */
    public GyldighedStatusKodeType getGyldighedStatusKode() {
        return gyldighedStatusKode;
    }

    /**
     * Sets the value of the gyldighedStatusKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GyldighedStatusKodeType }
     *     
     */
    public void setGyldighedStatusKode(GyldighedStatusKodeType value) {
        this.gyldighedStatusKode = value;
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
