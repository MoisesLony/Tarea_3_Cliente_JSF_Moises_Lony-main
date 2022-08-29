
package com.mycompany.mavenproject1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for save complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="save">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="persona" type="{http://webservice.entities.webservicepersonas.nocompany.com/}personasDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "save", propOrder = {
    "persona"
})
public class Save {

    protected PersonasDTO persona;

    /**
     * Gets the value of the persona property.
     * 
     * @return
     *     possible object is
     *     {@link PersonasDTO }
     *     
     */
    public PersonasDTO getPersona() {
        return persona;
    }

    /**
     * Sets the value of the persona property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonasDTO }
     *     
     */
    public void setPersona(PersonasDTO value) {
        this.persona = value;
    }

}
