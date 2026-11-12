
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoegInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegInputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oio:sagdok:3.0.0}SoegInputType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}SoegObjekt" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegInputType", propOrder = {
    "soegObjekt"
})
public class SoegInputType
    extends oio.sagdok._3_0.SoegInputType
{

    @XmlElement(name = "SoegObjekt")
    protected SoegObjektType soegObjekt;

    /**
     * Gets the value of the soegObjekt property.
     * 
     * @return
     *     possible object is
     *     {@link SoegObjektType }
     *     
     */
    public SoegObjektType getSoegObjekt() {
        return soegObjekt;
    }

    /**
     * Sets the value of the soegObjekt property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegObjektType }
     *     
     */
    public void setSoegObjekt(SoegObjektType value) {
        this.soegObjekt = value;
    }

}
