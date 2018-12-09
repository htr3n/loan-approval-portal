
package com.westbank.ws.business.loancontract._2018._06;

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
 *         &lt;element name="loanContractId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="borrowerCustomerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="borrowerTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerLastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="borrowerAddress" type="{urn:com:westbank:ws:business:LoanContract:2018:06}Address"/&gt;
 *         &lt;element name="coBorrower" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="coBorrowerCustomerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="coBorrowerTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerLastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coBorrowerDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="loanReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="loanAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="loanTerm" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="interestRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="monthlyPayment" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="settlementDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="residenceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estateType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estateLocation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="agencyAddress" type="{urn:com:westbank:ws:business:LoanContract:2018:06}Address"/&gt;
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
    "loanContractId",
    "borrowerCustomerId",
    "borrowerTitle",
    "borrowerFirstName",
    "borrowerLastName",
    "borrowerDateOfBirth",
    "borrowerAddress",
    "coBorrower",
    "coBorrowerCustomerId",
    "coBorrowerTitle",
    "coBorrowerFirstName",
    "coBorrowerLastName",
    "coBorrowerDateOfBirth",
    "loanReason",
    "loanAmount",
    "loanTerm",
    "interestRate",
    "monthlyPayment",
    "settlementDate",
    "residenceType",
    "estateType",
    "estateLocation",
    "bankName",
    "agencyCode",
    "agencyAddress"
})
@XmlRootElement(name = "LoanContractResponse")
public class LoanContractResponse {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanContractId;
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
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar borrowerDateOfBirth;
    @XmlElement(required = true)
    protected Address borrowerAddress;
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
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double monthlyPayment;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar settlementDate;
    @XmlElement(required = true)
    protected String residenceType;
    @XmlElement(required = true)
    protected String estateType;
    @XmlElement(required = true)
    protected String estateLocation;
    @XmlElement(required = true)
    protected String bankName;
    @XmlElement(required = true)
    protected String agencyCode;
    @XmlElement(required = true)
    protected Address agencyAddress;

    /**
     * Gets the value of the loanContractId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getLoanContractId() {
        return loanContractId;
    }

    /**
     * Sets the value of the loanContractId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanContractId(Long value) {
        this.loanContractId = value;
    }

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
     * Gets the value of the borrowerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getBorrowerAddress() {
        return borrowerAddress;
    }

    /**
     * Sets the value of the borrowerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setBorrowerAddress(Address value) {
        this.borrowerAddress = value;
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
     * Gets the value of the monthlyPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Sets the value of the monthlyPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthlyPayment(Double value) {
        this.monthlyPayment = value;
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
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the agencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyCode() {
        return agencyCode;
    }

    /**
     * Sets the value of the agencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyCode(String value) {
        this.agencyCode = value;
    }

    /**
     * Gets the value of the agencyAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAgencyAddress() {
        return agencyAddress;
    }

    /**
     * Sets the value of the agencyAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAgencyAddress(Address value) {
        this.agencyAddress = value;
    }

}
