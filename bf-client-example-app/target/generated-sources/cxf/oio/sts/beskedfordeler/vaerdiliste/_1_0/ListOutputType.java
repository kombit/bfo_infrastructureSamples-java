
package oio.sts.beskedfordeler.vaerdiliste._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOutputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oio:sagdok:3.0.0}ListOutputType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oio:sts:beskedfordeler:vaerdiliste:1.0.0}LaesResultat" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOutputType", propOrder = {
    "laesResultat"
})
public class ListOutputType
    extends oio.sagdok._3_0.ListOutputType
{

    @XmlElement(name = "LaesResultat")
    protected List<LaesResultatType> laesResultat;

    /**
     * Gets the value of the laesResultat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the laesResultat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaesResultat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LaesResultatType }
     * 
     * 
     */
    public List<LaesResultatType> getLaesResultat() {
        if (laesResultat == null) {
            laesResultat = new ArrayList<LaesResultatType>();
        }
        return this.laesResultat;
    }

}
