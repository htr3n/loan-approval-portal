
package com.westbank.ws.business.bankprivilege._2009._11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
    protected int numberOfIncidents;
    protected int numberOfBanks;
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
     */
    public int getNumberOfIncidents() {
        return numberOfIncidents;
    }

    /**
     * Sets the value of the numberOfIncidents property.
     * 
     */
    public void setNumberOfIncidents(int value) {
        this.numberOfIncidents = value;
    }

    /**
     * Gets the value of the numberOfBanks property.
     * 
     */
    public int getNumberOfBanks() {
        return numberOfBanks;
    }

    /**
     * Sets the value of the numberOfBanks property.
     * 
     */
    public void setNumberOfBanks(int value) {
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
