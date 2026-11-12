
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LaesResultatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LaesResultatType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}Registrering"/&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}FiltreretOejebliksbillede"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LaesResultatType", propOrder = {
    "registrering",
    "filtreretOejebliksbillede"
})
public class LaesResultatType {

    @XmlElement(name = "Registrering")
    protected RegistreringType registrering;
    @XmlElement(name = "FiltreretOejebliksbillede")
    protected FiltreretOejebliksbilledeType filtreretOejebliksbillede;

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

    /**
     * Gets the value of the filtreretOejebliksbillede property.
     * 
     * @return
     *     possible object is
     *     {@link FiltreretOejebliksbilledeType }
     *     
     */
    public FiltreretOejebliksbilledeType getFiltreretOejebliksbillede() {
        return filtreretOejebliksbillede;
    }

    /**
     * Sets the value of the filtreretOejebliksbillede property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltreretOejebliksbilledeType }
     *     
     */
    public void setFiltreretOejebliksbillede(FiltreretOejebliksbilledeType value) {
        this.filtreretOejebliksbillede = value;
    }

}
