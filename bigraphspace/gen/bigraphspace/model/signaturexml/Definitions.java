//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.28 at 09:20:51 PM BST 
//


package bigraphspace.model.signaturexml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Definitions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Definitions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controls" type="{http://www.mrl.nott.ac.uk/bigraphs/signature/1.0}Controls" minOccurs="0"/>
 *         &lt;element name="sorts" type="{http://www.mrl.nott.ac.uk/bigraphs/signature/1.0}Sorts" minOccurs="0"/>
 *         &lt;element name="renderers" type="{http://www.mrl.nott.ac.uk/bigraphs/signature/1.0}Renderers" minOccurs="0"/>
 *         &lt;element name="rules" type="{http://www.mrl.nott.ac.uk/bigraphs/signature/1.0}Rules" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Definitions", propOrder = {
    "controls",
    "sorts",
    "renderers",
    "rules"
})
public class Definitions {

    protected Controls controls;
    protected Sorts sorts;
    protected Renderers renderers;
    protected Rules rules;

    /**
     * Gets the value of the controls property.
     * 
     * @return
     *     possible object is
     *     {@link Controls }
     *     
     */
    public Controls getControls() {
        return controls;
    }

    /**
     * Sets the value of the controls property.
     * 
     * @param value
     *     allowed object is
     *     {@link Controls }
     *     
     */
    public void setControls(Controls value) {
        this.controls = value;
    }

    /**
     * Gets the value of the sorts property.
     * 
     * @return
     *     possible object is
     *     {@link Sorts }
     *     
     */
    public Sorts getSorts() {
        return sorts;
    }

    /**
     * Sets the value of the sorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sorts }
     *     
     */
    public void setSorts(Sorts value) {
        this.sorts = value;
    }

    /**
     * Gets the value of the renderers property.
     * 
     * @return
     *     possible object is
     *     {@link Renderers }
     *     
     */
    public Renderers getRenderers() {
        return renderers;
    }

    /**
     * Sets the value of the renderers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Renderers }
     *     
     */
    public void setRenderers(Renderers value) {
        this.renderers = value;
    }

    /**
     * Gets the value of the rules property.
     * 
     * @return
     *     possible object is
     *     {@link Rules }
     *     
     */
    public Rules getRules() {
        return rules;
    }

    /**
     * Sets the value of the rules property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rules }
     *     
     */
    public void setRules(Rules value) {
        this.rules = value;
    }

}
