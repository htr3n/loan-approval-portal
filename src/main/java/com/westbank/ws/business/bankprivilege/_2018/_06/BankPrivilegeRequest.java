
package com.westbank.ws.business.bankprivilege._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2001.xmlschema.Adapter3;


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
 *         &lt;element name="borrowerCustomerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="borrowerFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerLastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
    "borrowerCustomerId",
    "borrowerFirstName",
    "borrowerLastName",
    "borrowerDateOfBirth",
    "staffId",
    "staffRole"
})
@XmlRootElement(name = "BankPrivilegeRequest")
public class BankPrivilegeRequest {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long borrowerCustomerId;
    @XmlElement(required = true)
    protected String borrowerFirstName;
    @XmlElement(required = true)
    protected String borrowerLastName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar borrowerDateOfBirth;
    @XmlElement(required = true)
    protected String staffId;
    @XmlElement(required = true)
    protected String staffRole;

    /**
     * Gets the value of the borrowerCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getBorrowerCustomerId() {
        return borrowerCustomerId;
    }

    /**
     * Sets the value of the borrowerCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerCustomerId(Long value) {
        this.borrowerCustomerId = value;
    }

    /**
     * Gets the value of the borrowerFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerFirstName() {
        return borrowerFirstName;
    }

    /**
     * Sets the value of the borrowerFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerFirstName(String value) {
        this.borrowerFirstName = value;
    }

    /**
     * Gets the value of the borrowerLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerLastName() {
        return borrowerLastName;
    }

    /**
     * Sets the value of the borrowerLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerLastName(String value) {
        this.borrowerLastName = value;
    }

    /**
     * Gets the value of the borrowerDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBorrowerDateOfBirth() {
        return borrowerDateOfBirth;
    }

    /**
     * Sets the value of the borrowerDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBorrowerDateOfBirth(XMLGregorianCalendar value) {
        this.borrowerDateOfBirth = value;
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
