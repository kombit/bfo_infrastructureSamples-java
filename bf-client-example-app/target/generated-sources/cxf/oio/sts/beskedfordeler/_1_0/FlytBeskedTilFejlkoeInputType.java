
package oio.sts.beskedfordeler._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.besked.kuvert._1.HaendelsesbeskedType;


/**
 * <p>Java class for FlytBeskedTilFejlkoeInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlytBeskedTilFejlkoeInputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Haendelsesbesked"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlytBeskedTilFejlkoeInputType", propOrder = {
    "haendelsesbesked"
})
public class FlytBeskedTilFejlkoeInputType {

    @XmlElement(name = "Haendelsesbesked", namespace = "urn:oio:besked:kuvert:1.0", required = true)
    protected HaendelsesbeskedType haendelsesbesked;

    /**
     * Gets the value of the haendelsesbesked property.
     * 
     * @return
     *     possible object is
     *     {@link HaendelsesbeskedType }
     *     
     */
    public HaendelsesbeskedType getHaendelsesbesked() {
        return haendelsesbesked;
    }

    /**
     * Sets the value of the haendelsesbesked property.
     * 
     * @param value
     *     allowed object is
     *     {@link HaendelsesbeskedType }
     *     
     */
    public void setHaendelsesbesked(HaendelsesbeskedType value) {
        this.haendelsesbesked = value;
    }

}
