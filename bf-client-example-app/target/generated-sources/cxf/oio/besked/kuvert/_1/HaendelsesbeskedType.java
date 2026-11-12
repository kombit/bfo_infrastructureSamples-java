
package oio.besked.kuvert._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.UnikIdType;


/**
 * <p>Java class for HaendelsesbeskedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HaendelsesbeskedType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}BeskedId"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}BeskedVersion"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Beskedkuvert"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Beskeddata" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HaendelsesbeskedType", propOrder = {
    "beskedId",
    "beskedVersion",
    "beskedkuvert",
    "beskeddata"
})
public class HaendelsesbeskedType {

    @XmlElement(name = "BeskedId", required = true)
    protected UnikIdType beskedId;
    @XmlElement(name = "BeskedVersion", required = true)
    protected String beskedVersion;
    @XmlElement(name = "Beskedkuvert", required = true)
    protected BeskedkuvertType beskedkuvert;
    @XmlElement(name = "Beskeddata")
    protected List<BeskeddataType> beskeddata;

    /**
     * Gets the value of the beskedId property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getBeskedId() {
        return beskedId;
    }

    /**
     * Sets the value of the beskedId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setBeskedId(UnikIdType value) {
        this.beskedId = value;
    }

    /**
     * Gets the value of the beskedVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeskedVersion() {
        return beskedVersion;
    }

    /**
     * Sets the value of the beskedVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeskedVersion(String value) {
        this.beskedVersion = value;
    }

    /**
     * Gets the value of the beskedkuvert property.
     * 
     * @return
     *     possible object is
     *     {@link BeskedkuvertType }
     *     
     */
    public BeskedkuvertType getBeskedkuvert() {
        return beskedkuvert;
    }

    /**
     * Sets the value of the beskedkuvert property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeskedkuvertType }
     *     
     */
    public void setBeskedkuvert(BeskedkuvertType value) {
        this.beskedkuvert = value;
    }

    /**
     * Gets the value of the beskeddata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beskeddata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeskeddata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeskeddataType }
     * 
     * 
     */
    public List<BeskeddataType> getBeskeddata() {
        if (beskeddata == null) {
            beskeddata = new ArrayList<BeskeddataType>();
        }
        return this.beskeddata;
    }

}
