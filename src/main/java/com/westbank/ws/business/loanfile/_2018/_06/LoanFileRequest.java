
package com.westbank.ws.business.loanfile._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2001.xmlschema.Adapter2;
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
 *         &lt;element name="borrowerCustomerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="borrowerTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerLastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerPersonalId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="borrowerStreet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerCity" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerZipcode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerState" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerCountry" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerPhone" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerMobilePhone" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerEmail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerOccupation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerLengthOfService" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="borrowerIncome" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="borrowerMaritalStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerNumberOfChildren" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="coBorrower" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="coBorrowerCustomerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="coBorrowerTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerLastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="coBorrowerEmail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerPersonalId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerOccupation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerLengthOfService" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="coBorrowerIncome" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="loanFileId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="loanReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="loanAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="loanTerm" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="interestRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="residenceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estateType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estateLocation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="settlementDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="totalPurchasePrice" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="personalCapitalContribution" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="staffId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="staffRole" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="accessSensitiveData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "borrowerTitle",
    "borrowerFirstName",
    "borrowerLastName",
    "borrowerPersonalId",
    "borrowerDateOfBirth",
    "borrowerStreet",
    "borrowerCity",
    "borrowerZipcode",
    "borrowerState",
    "borrowerCountry",
    "borrowerPhone",
    "borrowerMobilePhone",
    "borrowerEmail",
    "borrowerOccupation",
    "borrowerLengthOfService",
    "borrowerIncome",
    "borrowerMaritalStatus",
    "borrowerNumberOfChildren",
    "coBorrower",
    "coBorrowerCustomerId",
    "coBorrowerTitle",
    "coBorrowerFirstName",
    "coBorrowerLastName",
    "coBorrowerDateOfBirth",
    "coBorrowerEmail",
    "coBorrowerPersonalId",
    "coBorrowerOccupation",
    "coBorrowerLengthOfService",
    "coBorrowerIncome",
    "loanFileId",
    "loanReason",
    "loanAmount",
    "loanTerm",
    "interestRate",
    "residenceType",
    "estateType",
    "estateLocation",
    "settlementDate",
    "totalPurchasePrice",
    "personalCapitalContribution",
    "staffId",
    "staffRole",
    "accessSensitiveData"
})
@XmlRootElement(name = "LoanFileRequest")
public class LoanFileRequest {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long borrowerCustomerId;
    @XmlElement(required = true)
    protected String borrowerTitle;
    @XmlElement(required = true)
    protected String borrowerFirstName;
    @XmlElement(required = true)
    protected String borrowerLastName;
    @XmlElement(required = true)
    protected String borrowerPersonalId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar borrowerDateOfBirth;
    @XmlElement(required = true)
    protected String borrowerStreet;
    @XmlElement(required = true)
    protected String borrowerCity;
    @XmlElement(required = true)
    protected String borrowerZipcode;
    @XmlElement(required = true)
    protected String borrowerState;
    @XmlElement(required = true)
    protected String borrowerCountry;
    @XmlElement(required = true)
    protected String borrowerPhone;
    @XmlElement(required = true)
    protected String borrowerMobilePhone;
    @XmlElement(required = true)
    protected String borrowerEmail;
    @XmlElement(required = true)
    protected String borrowerOccupation;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer borrowerLengthOfService;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double borrowerIncome;
    @XmlElement(required = true)
    protected String borrowerMaritalStatus;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer borrowerNumberOfChildren;
    @XmlElement(defaultValue = "false")
    protected boolean coBorrower;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long coBorrowerCustomerId;
    @XmlElement(required = true)
    protected String coBorrowerTitle;
    @XmlElement(required = true)
    protected String coBorrowerFirstName;
    @XmlElement(required = true)
    protected String coBorrowerLastName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar coBorrowerDateOfBirth;
    @XmlElement(required = true)
    protected String coBorrowerEmail;
    @XmlElement(required = true)
    protected String coBorrowerPersonalId;
    @XmlElement(required = true)
    protected String coBorrowerOccupation;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer coBorrowerLengthOfService;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double coBorrowerIncome;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanFileId;
    @XmlElement(required = true)
    protected String loanReason;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double loanAmount;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer loanTerm;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double interestRate;
    @XmlElement(required = true)
    protected String residenceType;
    @XmlElement(required = true)
    protected String estateType;
    @XmlElement(required = true)
    protected String estateLocation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar settlementDate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double totalPurchasePrice;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double personalCapitalContribution;
    @XmlElement(required = true)
    protected String staffId;
    @XmlElement(required = true)
    protected String staffRole;
    @XmlElement(defaultValue = "false")
    protected boolean accessSensitiveData;

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
     * Gets the value of the borrowerTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerTitle() {
        return borrowerTitle;
    }

    /**
     * Sets the value of the borrowerTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerTitle(String value) {
        this.borrowerTitle = value;
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
     * Gets the value of the borrowerPersonalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerPersonalId() {
        return borrowerPersonalId;
    }

    /**
     * Sets the value of the borrowerPersonalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerPersonalId(String value) {
        this.borrowerPersonalId = value;
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
     * Gets the value of the borrowerStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerStreet() {
        return borrowerStreet;
    }

    /**
     * Sets the value of the borrowerStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerStreet(String value) {
        this.borrowerStreet = value;
    }

    /**
     * Gets the value of the borrowerCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerCity() {
        return borrowerCity;
    }

    /**
     * Sets the value of the borrowerCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerCity(String value) {
        this.borrowerCity = value;
    }

    /**
     * Gets the value of the borrowerZipcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerZipcode() {
        return borrowerZipcode;
    }

    /**
     * Sets the value of the borrowerZipcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerZipcode(String value) {
        this.borrowerZipcode = value;
    }

    /**
     * Gets the value of the borrowerState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerState() {
        return borrowerState;
    }

    /**
     * Sets the value of the borrowerState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerState(String value) {
        this.borrowerState = value;
    }

    /**
     * Gets the value of the borrowerCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerCountry() {
        return borrowerCountry;
    }

    /**
     * Sets the value of the borrowerCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerCountry(String value) {
        this.borrowerCountry = value;
    }

    /**
     * Gets the value of the borrowerPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerPhone() {
        return borrowerPhone;
    }

    /**
     * Sets the value of the borrowerPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerPhone(String value) {
        this.borrowerPhone = value;
    }

    /**
     * Gets the value of the borrowerMobilePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerMobilePhone() {
        return borrowerMobilePhone;
    }

    /**
     * Sets the value of the borrowerMobilePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerMobilePhone(String value) {
        this.borrowerMobilePhone = value;
    }

    /**
     * Gets the value of the borrowerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerEmail() {
        return borrowerEmail;
    }

    /**
     * Sets the value of the borrowerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerEmail(String value) {
        this.borrowerEmail = value;
    }

    /**
     * Gets the value of the borrowerOccupation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerOccupation() {
        return borrowerOccupation;
    }

    /**
     * Sets the value of the borrowerOccupation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerOccupation(String value) {
        this.borrowerOccupation = value;
    }

    /**
     * Gets the value of the borrowerLengthOfService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBorrowerLengthOfService() {
        return borrowerLengthOfService;
    }

    /**
     * Sets the value of the borrowerLengthOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerLengthOfService(Integer value) {
        this.borrowerLengthOfService = value;
    }

    /**
     * Gets the value of the borrowerIncome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getBorrowerIncome() {
        return borrowerIncome;
    }

    /**
     * Sets the value of the borrowerIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerIncome(Double value) {
        this.borrowerIncome = value;
    }

    /**
     * Gets the value of the borrowerMaritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerMaritalStatus() {
        return borrowerMaritalStatus;
    }

    /**
     * Sets the value of the borrowerMaritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerMaritalStatus(String value) {
        this.borrowerMaritalStatus = value;
    }

    /**
     * Gets the value of the borrowerNumberOfChildren property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBorrowerNumberOfChildren() {
        return borrowerNumberOfChildren;
    }

    /**
     * Sets the value of the borrowerNumberOfChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerNumberOfChildren(Integer value) {
        this.borrowerNumberOfChildren = value;
    }

    /**
     * Gets the value of the coBorrower property.
     * 
     */
    public boolean isCoBorrower() {
        return coBorrower;
    }

    /**
     * Sets the value of the coBorrower property.
     * 
     */
    public void setCoBorrower(boolean value) {
        this.coBorrower = value;
    }

    /**
     * Gets the value of the coBorrowerCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getCoBorrowerCustomerId() {
        return coBorrowerCustomerId;
    }

    /**
     * Sets the value of the coBorrowerCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerCustomerId(Long value) {
        this.coBorrowerCustomerId = value;
    }

    /**
     * Gets the value of the coBorrowerTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrowerTitle() {
        return coBorrowerTitle;
    }

    /**
     * Sets the value of the coBorrowerTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerTitle(String value) {
        this.coBorrowerTitle = value;
    }

    /**
     * Gets the value of the coBorrowerFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrowerFirstName() {
        return coBorrowerFirstName;
    }

    /**
     * Sets the value of the coBorrowerFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerFirstName(String value) {
        this.coBorrowerFirstName = value;
    }

    /**
     * Gets the value of the coBorrowerLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrowerLastName() {
        return coBorrowerLastName;
    }

    /**
     * Sets the value of the coBorrowerLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerLastName(String value) {
        this.coBorrowerLastName = value;
    }

    /**
     * Gets the value of the coBorrowerDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCoBorrowerDateOfBirth() {
        return coBorrowerDateOfBirth;
    }

    /**
     * Sets the value of the coBorrowerDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCoBorrowerDateOfBirth(XMLGregorianCalendar value) {
        this.coBorrowerDateOfBirth = value;
    }

    /**
     * Gets the value of the coBorrowerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrowerEmail() {
        return coBorrowerEmail;
    }

    /**
     * Sets the value of the coBorrowerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerEmail(String value) {
        this.coBorrowerEmail = value;
    }

    /**
     * Gets the value of the coBorrowerPersonalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrowerPersonalId() {
        return coBorrowerPersonalId;
    }

    /**
     * Sets the value of the coBorrowerPersonalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerPersonalId(String value) {
        this.coBorrowerPersonalId = value;
    }

    /**
     * Gets the value of the coBorrowerOccupation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBorrowerOccupation() {
        return coBorrowerOccupation;
    }

    /**
     * Sets the value of the coBorrowerOccupation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerOccupation(String value) {
        this.coBorrowerOccupation = value;
    }

    /**
     * Gets the value of the coBorrowerLengthOfService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCoBorrowerLengthOfService() {
        return coBorrowerLengthOfService;
    }

    /**
     * Sets the value of the coBorrowerLengthOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerLengthOfService(Integer value) {
        this.coBorrowerLengthOfService = value;
    }

    /**
     * Gets the value of the coBorrowerIncome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getCoBorrowerIncome() {
        return coBorrowerIncome;
    }

    /**
     * Sets the value of the coBorrowerIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBorrowerIncome(Double value) {
        this.coBorrowerIncome = value;
    }

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
     * Gets the value of the loanReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanReason() {
        return loanReason;
    }

    /**
     * Sets the value of the loanReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanReason(String value) {
        this.loanReason = value;
    }

    /**
     * Gets the value of the loanAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets the value of the loanAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanAmount(Double value) {
        this.loanAmount = value;
    }

    /**
     * Gets the value of the loanTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getLoanTerm() {
        return loanTerm;
    }

    /**
     * Sets the value of the loanTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanTerm(Integer value) {
        this.loanTerm = value;
    }

    /**
     * Gets the value of the interestRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the value of the interestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestRate(Double value) {
        this.interestRate = value;
    }

    /**
     * Gets the value of the residenceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidenceType() {
        return residenceType;
    }

    /**
     * Sets the value of the residenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidenceType(String value) {
        this.residenceType = value;
    }

    /**
     * Gets the value of the estateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstateType() {
        return estateType;
    }

    /**
     * Sets the value of the estateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstateType(String value) {
        this.estateType = value;
    }

    /**
     * Gets the value of the estateLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstateLocation() {
        return estateLocation;
    }

    /**
     * Sets the value of the estateLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstateLocation(String value) {
        this.estateLocation = value;
    }

    /**
     * Gets the value of the settlementDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettlementDate() {
        return settlementDate;
    }

    /**
     * Sets the value of the settlementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettlementDate(XMLGregorianCalendar value) {
        this.settlementDate = value;
    }

    /**
     * Gets the value of the totalPurchasePrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    /**
     * Sets the value of the totalPurchasePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPurchasePrice(Double value) {
        this.totalPurchasePrice = value;
    }

    /**
     * Gets the value of the personalCapitalContribution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getPersonalCapitalContribution() {
        return personalCapitalContribution;
    }

    /**
     * Sets the value of the personalCapitalContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalCapitalContribution(Double value) {
        this.personalCapitalContribution = value;
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

    /**
     * Gets the value of the accessSensitiveData property.
     * 
     */
    public boolean isAccessSensitiveData() {
        return accessSensitiveData;
    }

    /**
     * Sets the value of the accessSensitiveData property.
     * 
     */
    public void setAccessSensitiveData(boolean value) {
        this.accessSensitiveData = value;
    }

}
