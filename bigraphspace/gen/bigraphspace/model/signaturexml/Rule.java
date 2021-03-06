//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.28 at 02:18:04 PM BST 
//


package bigraphspace.model.signaturexml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="redex" type="{http://www.mrl.nott.ac.uk/bigraphs/signature/1.0}DOM"/>
 *         &lt;element name="reactum" type="{http://www.mrl.nott.ac.uk/bigraphs/signature/1.0}DOM"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rule", propOrder = {
    "description",
    "redex",
    "reactum"
})
public class Rule {

    protected String description;
    @XmlElement(required = true)
    protected DOM redex;
    @XmlElement(required = true)
    protected DOM reactum;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the redex property.
     * 
     * @return
     *     possible object is
     *     {@link DOM }
     *     
     */
    public DOM getRedex() {
        return redex;
    }

    /**
     * Sets the value of the redex property.
     * 
     * @param value
     *     allowed object is
     *     {@link DOM }
     *     
     */
    public void setRedex(DOM value) {
        this.redex = value;
    }

    /**
     * Gets the value of the reactum property.
     * 
     * @return
     *     possible object is
     *     {@link DOM }
     *     
     */
    public DOM getReactum() {
        return reactum;
    }

    /**
     * Sets the value of the reactum property.
     * 
     * @param value
     *     allowed object is
     *     {@link DOM }
     *     
     */
    public void setReactum(DOM value) {
        this.reactum = value;
    }

}
