
package oio.besked.kuvert._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.UnikIdType;


/**
 * <p>Java class for RelateretObjektType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelateretObjektType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}ObjektId"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}ObjektType"/&gt;
 *         &lt;element ref="{urn:oio:besked:kuvert:1.0}ObjektRolle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelateretObjektType", propOrder = {
    "objektId",
    "objektType",
    "objektRolle"
})
public class RelateretObjektType {

    @XmlElement(name = "ObjektId", required = true)
    protected UnikIdType objektId;
    @XmlElement(name = "ObjektType", required = true)
    protected UnikIdType objektType;
    @XmlElement(name = "ObjektRolle")
    protected UnikIdType objektRolle;

    /**
     * Gets the value of the objektId property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getObjektId() {
        return objektId;
    }

    /**
     * Sets the value of the objektId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setObjektId(UnikIdType value) {
        this.objektId = value;
    }

    /**
     * Gets the value of the objektType property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getObjektType() {
        return objektType;
    }

    /**
     * Sets the value of the objektType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setObjektType(UnikIdType value) {
        this.objektType = value;
    }

    /**
     * Gets the value of the objektRolle property.
     * 
     * @return
     *     possible object is
     *     {@link UnikIdType }
     *     
     */
    public UnikIdType getObjektRolle() {
        return objektRolle;
    }

    /**
     * Sets the value of the objektRolle property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnikIdType }
     *     
     */
    public void setObjektRolle(UnikIdType value) {
        this.objektRolle = value;
    }

}
