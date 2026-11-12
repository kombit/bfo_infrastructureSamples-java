
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FjernVaerdierInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FjernVaerdierInputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}UUIDIdentifikator"/&gt;
 *         &lt;element name="Vaerdier" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FjernVaerdierInputType", propOrder = {
    "uuidIdentifikator",
    "vaerdier"
})
public class FjernVaerdierInputType {

    @XmlElement(name = "UUIDIdentifikator", namespace = "urn:oio:sagdok:3.0.0", required = true)
    protected String uuidIdentifikator;
    @XmlElement(name = "Vaerdier")
    protected List<String> vaerdier;

    /**
     * Gets the value of the uuidIdentifikator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUIDIdentifikator() {
        return uuidIdentifikator;
    }

    /**
     * Sets the value of the uuidIdentifikator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUIDIdentifikator(String value) {
        this.uuidIdentifikator = value;
    }

    /**
     * Gets the value of the vaerdier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vaerdier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVaerdier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVaerdier() {
        if (vaerdier == null) {
            vaerdier = new ArrayList<String>();
        }
        return this.vaerdier;
    }

}
