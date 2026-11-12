
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oio.sagdok._3_0.SoegSagDokObjektType;


/**
 * <p>Java class for SoegObjektType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoegObjektType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oio:sagdok:3.0.0}SoegSagDokObjektType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}SoegAttributListe" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}SoegTilstandListe" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}SoegRelationListe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoegObjektType", propOrder = {
    "soegAttributListe",
    "soegTilstandListe",
    "soegRelationListe"
})
public class SoegObjektType
    extends SoegSagDokObjektType
{

    @XmlElement(name = "SoegAttributListe")
    protected SoegAttributListeType soegAttributListe;
    @XmlElement(name = "SoegTilstandListe")
    protected SoegTilstandListeType soegTilstandListe;
    @XmlElement(name = "SoegRelationListe")
    protected SoegRelationListeType soegRelationListe;

    /**
     * Gets the value of the soegAttributListe property.
     * 
     * @return
     *     possible object is
     *     {@link SoegAttributListeType }
     *     
     */
    public SoegAttributListeType getSoegAttributListe() {
        return soegAttributListe;
    }

    /**
     * Sets the value of the soegAttributListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegAttributListeType }
     *     
     */
    public void setSoegAttributListe(SoegAttributListeType value) {
        this.soegAttributListe = value;
    }

    /**
     * Gets the value of the soegTilstandListe property.
     * 
     * @return
     *     possible object is
     *     {@link SoegTilstandListeType }
     *     
     */
    public SoegTilstandListeType getSoegTilstandListe() {
        return soegTilstandListe;
    }

    /**
     * Sets the value of the soegTilstandListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegTilstandListeType }
     *     
     */
    public void setSoegTilstandListe(SoegTilstandListeType value) {
        this.soegTilstandListe = value;
    }

    /**
     * Gets the value of the soegRelationListe property.
     * 
     * @return
     *     possible object is
     *     {@link SoegRelationListeType }
     *     
     */
    public SoegRelationListeType getSoegRelationListe() {
        return soegRelationListe;
    }

    /**
     * Sets the value of the soegRelationListe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoegRelationListeType }
     *     
     */
    public void setSoegRelationListe(SoegRelationListeType value) {
        this.soegRelationListe = value;
    }

}
