
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.LokalUdvidelseType;


/**
 * <p>Java class for SoegAttributListeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegAttributListeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}SoegEgenskab" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:sagdok:3.0.0}LokalUdvidelse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegAttributListeType", propOrder = {
    "soegEgenskab",
    "lokalUdvidelse"
})
public class SoegAttributListeType {

    @XmlElement(name = "SoegEgenskab")
    protected List<SoegEgenskabType> soegEgenskab;
    @XmlElement(name = "LokalUdvidelse", namespace = "urn:oio:sagdok:3.0.0")
    protected LokalUdvidelseType lokalUdvidelse;

    /**
     * Gets the value of the soegEgenskab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soegEgenskab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoegEgenskab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoegEgenskabType }
     * 
     * 
     */
    public List<SoegEgenskabType> getSoegEgenskab() {
        if (soegEgenskab == null) {
            soegEgenskab = new ArrayList<SoegEgenskabType>();
        }
        return this.soegEgenskab;
    }

    /**
     * Gets the value of the lokalUdvidelse property.
     * 
     * @return
     *     possible object is
     *     {@link LokalUdvidelseType }
     *     
     */
    public LokalUdvidelseType getLokalUdvidelse() {
        return lokalUdvidelse;
    }

    /**
     * Sets the value of the lokalUdvidelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LokalUdvidelseType }
     *     
     */
    public void setLokalUdvidelse(LokalUdvidelseType value) {
        this.lokalUdvidelse = value;
    }

}
