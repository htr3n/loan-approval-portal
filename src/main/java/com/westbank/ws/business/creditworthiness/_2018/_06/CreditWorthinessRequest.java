
package com.westbank.ws.business.creditworthiness._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter3;
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
 *         &lt;element name="loanFileId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="numberOfIncidents" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numberOfBanks" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="staffId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="staffRole" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "loanFileId",
    "numberOfIncidents",
    "numberOfBanks",
    "staffId",
    "staffRole"
})
@XmlRootElement(name = "CreditWorthinessRequest")
public class CreditWorthinessRequest {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanFileId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer numberOfIncidents;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer numberOfBanks;
    @XmlElement(required = true)
    protected String staffId;
    @XmlElement(required = true)
    protected String staffRole;

    /**
     * Gets the value of the loanFileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getLoanFileId() {
        return loanFileId;
    }

    /**
     * Sets the value of the loanFileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanFileId(Long value) {
        this.loanFileId = value;
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
     * Gets the value of the staffId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * Sets the value of the staffId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffId(String value) {
        this.staffId = value;
    }

    /**
     * Gets the value of the staffRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffRole() {
        return staffRole;
    }

    /**
     * Sets the value of the staffRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffRole(String value) {
        this.staffRole = value;
    }

}
