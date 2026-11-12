
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.BasicOutputType;


/**
 * <p>Java class for RegistreringOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistreringOutputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oio:sagdok:3.0.0}BasicOutputType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}Registrering" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistreringOutputType", propOrder = {
    "registrering"
})
public class RegistreringOutputType
    extends BasicOutputType
{

    @XmlElement(name = "Registrering")
    protected RegistreringType registrering;

    /**
     * Gets the value of the registrering property.
     * 
     * @return
     *     possible object is
     *     {@link RegistreringType }
     *     
     */
    public RegistreringType getRegistrering() {
        return registrering;
    }

    /**
     * Sets the value of the registrering property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistreringType }
     *     
     */
    public void setRegistrering(RegistreringType value) {
        this.registrering = value;
    }

}
