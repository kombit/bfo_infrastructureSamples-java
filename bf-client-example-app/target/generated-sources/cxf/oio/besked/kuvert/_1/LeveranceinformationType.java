
package oio.besked.kuvert._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.TidspunktType;
import oio.sagdok._3_0.UnikIdType;
import oio.sagdok.organisation._2_0.AktoerType;


/**
 * <p>Java class for LeveranceinformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LeveranceinformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Dannelsestidspunkt" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}TransaktionsId" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Kildesystem" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}KildesystemIPAdresse" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}KildesystemAkkreditiver" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Sikkerhedsklassificering" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Leveranceruter" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}LeveranceinformationLokalUdvidelse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LeveranceinformationType", propOrder = {
    "dannelsestidspunkt",
    "transaktionsId",
    "kildesystem",
    "kildesystemIPAdresse",
    "kildesystemAkkreditiver",
    "sikkerhedsklassificering",
    "leveranceruter",
    "leveranceinformationLokalUdvidelse"
})
public class LeveranceinformationType {

    @XmlElement(name = "Dannelsestidspunkt")
    protected TidspunktType dannelsestidspunkt;
    @XmlElement(name = "TransaktionsId")
    protected UnikIdType transaktionsId;
    @XmlElement(name = "Kildesystem")
    protected AktoerType kildesystem;
    @XmlElement(name = "KildesystemIPAdresse")
    protected String kildesystemIPAdresse;
    @XmlElement(name = "KildesystemAkkreditiver")
    protected String kildesystemAkkreditiver;
    @XmlElement(name = "Sikkerhedsklassificering")
    protected UnikIdType sikkerhedsklassificering;
    @XmlElement(name = "Leveranceruter")
    protected LeveranceruterType leveranceruter;
    @XmlElement(name = "LeveranceinformationLokalUdvidelse")
    protected LeveranceinformationLokalUdvidelseType leveranceinformationLokalUdvidelse;

    /**
     * Gets the value of the dannelsestidspunkt property.
     * 
     * @return
     *     possible object is
     *     {@link TidspunktType }
     *     
     */
    public TidspunktType getDannelsestidspunkt() {
        return dannelsestidspunkt;
    }

    /**
     * Sets the value of the dannelsestidspunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TidspunktType }
     *     
     */
    public void setDannelsestidspunkt(TidspunktType value) {
        this.dannelsestidspunkt = value;
    }

    /**
     * Gets the value of the transaktionsId property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getTransaktionsId() {
        return transaktionsId;
    }

    /**
     * Sets the value of the transaktionsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setTransaktionsId(UnikIdType value) {
        this.transaktionsId = value;
    }

    /**
     * Gets the value of the kildesystem property.
     * 
     * @return
     *     possible object is
     *     {@link AktoerType }
     *     
     */
    public AktoerType getKildesystem() {
        return kildesystem;
    }

    /**
     * Sets the value of the kildesystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link AktoerType }
     *     
     */
    public void setKildesystem(AktoerType value) {
        this.kildesystem = value;
    }

    /**
     * Gets the value of the kildesystemIPAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKildesystemIPAdresse() {
        return kildesystemIPAdresse;
    }

    /**
     * Sets the value of the kildesystemIPAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKildesystemIPAdresse(String value) {
        this.kildesystemIPAdresse = value;
    }

    /**
     * Gets the value of the kildesystemAkkreditiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKildesystemAkkreditiver() {
        return kildesystemAkkreditiver;
    }

    /**
     * Sets the value of the kildesystemAkkreditiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKildesystemAkkreditiver(String value) {
        this.kildesystemAkkreditiver = value;
    }

    /**
     * Gets the value of the sikkerhedsklassificering property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getSikkerhedsklassificering() {
        return sikkerhedsklassificering;
    }

    /**
     * Sets the value of the sikkerhedsklassificering property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setSikkerhedsklassificering(UnikIdType value) {
        this.sikkerhedsklassificering = value;
    }

    /**
     * Gets the value of the leveranceruter property.
     * 
     * @return
     *     possible object is
     *     {@link LeveranceruterType }
     *     
     */
    public LeveranceruterType getLeveranceruter() {
        return leveranceruter;
    }

    /**
     * Sets the value of the leveranceruter property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeveranceruterType }
     *     
     */
    public void setLeveranceruter(LeveranceruterType value) {
        this.leveranceruter = value;
    }

    /**
     * Gets the value of the leveranceinformationLokalUdvidelse property.
     * 
     * @return
     *     possible object is
     *     {@link LeveranceinformationLokalUdvidelseType }
     *     
     */
    public LeveranceinformationLokalUdvidelseType getLeveranceinformationLokalUdvidelse() {
        return leveranceinformationLokalUdvidelse;
    }

    /**
     * Sets the value of the leveranceinformationLokalUdvidelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeveranceinformationLokalUdvidelseType }
     *     
     */
    public void setLeveranceinformationLokalUdvidelse(LeveranceinformationLokalUdvidelseType value) {
        this.leveranceinformationLokalUdvidelse = value;
    }

}
