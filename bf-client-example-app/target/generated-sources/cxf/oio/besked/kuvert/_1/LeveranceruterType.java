
package oio.besked.kuvert._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LeveranceruterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LeveranceruterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}Leverancerute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LeveranceruterType", propOrder = {
    "leverancerute"
})
public class LeveranceruterType {

    @XmlElement(name = "Leverancerute")
    protected List<LeveranceruteType> leverancerute;

    /**
     * Gets the value of the leverancerute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leverancerute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLeverancerute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LeveranceruteType }
     * 
     * 
     */
    public List<LeveranceruteType> getLeverancerute() {
        if (leverancerute == null) {
            leverancerute = new ArrayList<LeveranceruteType>();
        }
        return this.leverancerute;
    }

}
