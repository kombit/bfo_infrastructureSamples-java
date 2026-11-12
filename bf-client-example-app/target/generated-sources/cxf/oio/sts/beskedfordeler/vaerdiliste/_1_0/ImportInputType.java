
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImportInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportInputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oio:sagdok:3.0.0}ImportInputType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}Vaerdiliste"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportInputType", propOrder = {
    "vaerdiliste"
})
public class ImportInputType
    extends oio.sagdok._3_0.ImportInputType
{

    @XmlElement(name = "Vaerdiliste", required = true)
    protected VaerdilisteType vaerdiliste;

    /**
     * Gets the value of the vaerdiliste property.
     * 
     * @return
     *     possible object is
     *     {@link VaerdilisteType }
     *     
     */
    public VaerdilisteType getVaerdiliste() {
        return vaerdiliste;
    }

    /**
     * Sets the value of the vaerdiliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link VaerdilisteType }
     *     
     */
    public void setVaerdiliste(VaerdilisteType value) {
        this.vaerdiliste = value;
    }

}
