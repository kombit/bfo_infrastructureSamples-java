
package oio.besked.kuvert._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.TidspunktType;
import oio.sagdok._3_0.UnikIdType;
import oio.sagdok.organisation._2_0.AktoerType;


/**
 * <p>Java class for LeveranceruteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LeveranceruteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Fordelingssystem" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}ModtagelsesTidspunkt" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}LeveranceTidspunkt" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}ModtagetFraSystem" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}ErLeveretIHenholdTil" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}LeveranceruteLokalUdvidelse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LeveranceruteType", propOrder = {
    "fordelingssystem",
    "modtagelsesTidspunkt",
    "leveranceTidspunkt",
    "modtagetFraSystem",
    "erLeveretIHenholdTil",
    "leveranceruteLokalUdvidelse"
})
public class LeveranceruteType {

    @XmlElement(name = "Fordelingssystem")
    protected UnikIdType fordelingssystem;
    @XmlElement(name = "ModtagelsesTidspunkt")
    protected TidspunktType modtagelsesTidspunkt;
    @XmlElement(name = "LeveranceTidspunkt")
    protected TidspunktType leveranceTidspunkt;
    @XmlElement(name = "ModtagetFraSystem")
    protected AktoerType modtagetFraSystem;
    @XmlElement(name = "ErLeveretIHenholdTil")
    protected UnikIdType erLeveretIHenholdTil;
    @XmlElement(name = "LeveranceruteLokalUdvidelse")
    protected LeveranceruteLokalUdvidelseType leveranceruteLokalUdvidelse;

    /**
     * Gets the value of the fordelingssystem property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getFordelingssystem() {
        return fordelingssystem;
    }

    /**
     * Sets the value of the fordelingssystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setFordelingssystem(UnikIdType value) {
        this.fordelingssystem = value;
    }

    /**
     * Gets the value of the modtagelsesTidspunkt property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getModtagelsesTidspunkt() {
        return modtagelsesTidspunkt;
    }

    /**
     * Sets the value of the modtagelsesTidspunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setModtagelsesTidspunkt(TidspunktType value) {
        this.modtagelsesTidspunkt = value;
    }

    /**
     * Gets the value of the leveranceTidspunkt property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getLeveranceTidspunkt() {
        return leveranceTidspunkt;
    }

    /**
     * Sets the value of the leveranceTidspunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setLeveranceTidspunkt(TidspunktType value) {
        this.leveranceTidspunkt = value;
    }

    /**
     * Gets the value of the modtagetFraSystem property.
     * 
     * @return
     *     possible object is
     *     {@link AktoerType }
     *     
     */
    public AktoerType getModtagetFraSystem() {
        return modtagetFraSystem;
    }

    /**
     * Sets the value of the modtagetFraSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link AktoerType }
     *     
     */
    public void setModtagetFraSystem(AktoerType value) {
        this.modtagetFraSystem = value;
    }

    /**
     * Gets the value of the erLeveretIHenholdTil property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getErLeveretIHenholdTil() {
        return erLeveretIHenholdTil;
    }

    /**
     * Sets the value of the erLeveretIHenholdTil property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setErLeveretIHenholdTil(UnikIdType value) {
        this.erLeveretIHenholdTil = value;
    }

    /**
     * Gets the value of the leveranceruteLokalUdvidelse property.
     * 
     * @return
     *     possible object is
     *     {@link LeveranceruteLokalUdvidelseType }
     *     
     */
    public LeveranceruteLokalUdvidelseType getLeveranceruteLokalUdvidelse() {
        return leveranceruteLokalUdvidelse;
    }

    /**
     * Sets the value of the leveranceruteLokalUdvidelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeveranceruteLokalUdvidelseType }
     *     
     */
    public void setLeveranceruteLokalUdvidelse(LeveranceruteLokalUdvidelseType value) {
        this.leveranceruteLokalUdvidelse = value;
    }

}
