
package com.westbank.ws.business.bankprivilege._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter4;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="registered" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="numberOfIncidents" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numberOfBanks" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registered",
    "numberOfIncidents",
    "numberOfBanks",
    "description"
})
@XmlRootElement(name = "BankPrivilegeResponse")
public class BankPrivilegeResponse {

    protected boolean registered;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer numberOfIncidents;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer numberOfBanks;
    @XmlElement(required = true)
    protected String description;

    /**
     * Gets the value of the registered property.
     * 
     */
    public boolean isRegistered() {
        return registered;
    }

    /**
     * Sets the value of the registered property.
     * 
     */
    public void setRegistered(boolean value) {
        this.registered = value;
    }

    /**
     * Gets the value of the numberOfIncidents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getNumberOfIncidents() {
        return numberOfIncidents;
    }

    /**
     * Sets the value of the numberOfIncidents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfIncidents(Integer value) {
        this.numberOfIncidents = value;
    }

    /**
     * Gets the value of the numberOfBanks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getNumberOfBanks() {
        return numberOfBanks;
    }

    /**
     * Sets the value of the numberOfBanks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfBanks(Integer value) {
        this.numberOfBanks = value;
    }

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

}
