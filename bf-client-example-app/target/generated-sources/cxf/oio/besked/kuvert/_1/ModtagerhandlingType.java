
package oio.besked.kuvert._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.UnikIdType;
import oio.sagdok.organisation._2_0.AktoerType;


/**
 * <p>Java class for ModtagerhandlingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModtagerhandlingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Handling" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Responsmodtager" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModtagerhandlingType", propOrder = {
    "handling",
    "responsmodtager"
})
public class ModtagerhandlingType {

    @XmlElement(name = "Handling")
    protected UnikIdType handling;
    @XmlElement(name = "Responsmodtager")
    protected AktoerType responsmodtager;

    /**
     * Gets the value of the handling property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getHandling() {
        return handling;
    }

    /**
     * Sets the value of the handling property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setHandling(UnikIdType value) {
        this.handling = value;
    }

    /**
     * Gets the value of the responsmodtager property.
     * 
     * @return
     *     possible object is
     *     {@link AktoerType }
     *     
     */
    public AktoerType getResponsmodtager() {
        return responsmodtager;
    }

    /**
     * Sets the value of the responsmodtager property.
     * 
     * @param value
     *     allowed object is
     *     {@link AktoerType }
     *     
     */
    public void setResponsmodtager(AktoerType value) {
        this.responsmodtager = value;
    }

}
