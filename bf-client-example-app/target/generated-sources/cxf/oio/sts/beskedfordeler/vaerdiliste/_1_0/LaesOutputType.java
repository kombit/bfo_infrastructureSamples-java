
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.BasicOutputType;


/**
 * <p>Java class for LaesOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LaesOutputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oio:sagdok:3.0.0}BasicOutputType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}LaesResultat" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LaesOutputType", propOrder = {
    "laesResultat"
})
public class LaesOutputType
    extends BasicOutputType
{

    @XmlElement(name = "LaesResultat")
    protected LaesResultatType laesResultat;

    /**
     * Gets the value of the laesResultat property.
     * 
     * @return
     *     possible object is
     *     {@link LaesResultatType }
     *     
     */
    public LaesResultatType getLaesResultat() {
        return laesResultat;
    }

    /**
     * Sets the value of the laesResultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaesResultatType }
     *     
     */
    public void setLaesResultat(LaesResultatType value) {
        this.laesResultat = value;
    }

}
