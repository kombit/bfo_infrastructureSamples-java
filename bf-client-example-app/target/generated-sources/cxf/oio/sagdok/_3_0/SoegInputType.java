
package oio.sagdok._3_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoegInputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegInputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}FoersteResultatReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}MaksimalAntalKvantitet" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegInputType", propOrder = {
    "foersteResultatReference",
    "maksimalAntalKvantitet"
})
@XmlSeeAlso({
    oio.sts.beskedfordeler.vaerdiliste._1_0.SoegInputType.class
})
public class SoegInputType {

    @XmlElement(name = "FoersteResultatReference")
    protected BigInteger foersteResultatReference;
    @XmlElement(name = "MaksimalAntalKvantitet")
    protected BigInteger maksimalAntalKvantitet;

    /**
     * Gets the value of the foersteResultatReference property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFoersteResultatReference() {
        return foersteResultatReference;
    }

    /**
     * Sets the value of the foersteResultatReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFoersteResultatReference(BigInteger value) {
        this.foersteResultatReference = value;
    }

    /**
     * Gets the value of the maksimalAntalKvantitet property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaksimalAntalKvantitet() {
        return maksimalAntalKvantitet;
    }

    /**
     * Sets the value of the maksimalAntalKvantitet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaksimalAntalKvantitet(BigInteger value) {
        this.maksimalAntalKvantitet = value;
    }

}
