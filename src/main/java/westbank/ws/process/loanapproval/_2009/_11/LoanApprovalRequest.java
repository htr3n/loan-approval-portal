
package westbank.ws.process.loanapproval._2009._11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="borrowerAddress" type="{urn:westbank:ws:process:LoanApproval:2009:11}AddressType"/&gt;
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
 *         &lt;element name="loanFileId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "borrowerAddress",
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
    "accessSensitiveData"
})
@XmlRootElement(name = "LoanApprovalRequest")
public class LoanApprovalRequest {

    protected long borrowerCustomerId;
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
    protected AddressType borrowerAddress;
    @XmlElement(required = true)
    protected String borrowerPhone;
    @XmlElement(required = true)
    protected String borrowerMobilePhone;
    @XmlElement(required = true)
    protected String borrowerEmail;
    @XmlElement(required = true)
    protected String borrowerOccupation;
    protected int borrowerLengthOfService;
    protected double borrowerIncome;
    @XmlElement(required = true)
    protected String borrowerMaritalStatus;
    @XmlElement(defaultValue = "0")
    protected int borrowerNumberOfChildren;
    @XmlElement(defaultValue = "false")
    protected boolean coBorrower;
    protected long coBorrowerCustomerId;
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
    protected int coBorrowerLengthOfService;
    protected double coBorrowerIncome;
    @XmlElement(required = true)
    protected String loanFileId;
    @XmlElement(required = true)
    protected String loanReason;
    protected double loanAmount;
    protected int loanTerm;
    protected double interestRate;
    @XmlElement(required = true)
    protected String residenceType;
    @XmlElement(required = true)
    protected String estateType;
    @XmlElement(required = true)
    protected String estateLocation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar settlementDate;
    protected double totalPurchasePrice;
    protected double personalCapitalContribution;
    @XmlElement(defaultValue = "false")
    protected boolean accessSensitiveData;

    /**
     * Gets the value of the borrowerCustomerId property.
     * 
     */
    public long getBorrowerCustomerId() {
        return borrowerCustomerId;
    }

    /**
     * Sets the value of the borrowerCustomerId property.
     * 
     */
    public void setBorrowerCustomerId(long value) {
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
     * Gets the value of the borrowerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getBorrowerAddress() {
        return borrowerAddress;
    }

    /**
     * Sets the value of the borrowerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setBorrowerAddress(AddressType value) {
        this.borrowerAddress = value;
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
     */
    public int getBorrowerLengthOfService() {
        return borrowerLengthOfService;
    }

    /**
     * Sets the value of the borrowerLengthOfService property.
     * 
     */
    public void setBorrowerLengthOfService(int value) {
        this.borrowerLengthOfService = value;
    }

    /**
     * Gets the value of the borrowerIncome property.
     * 
     */
    public double getBorrowerIncome() {
        return borrowerIncome;
    }

    /**
     * Sets the value of the borrowerIncome property.
     * 
     */
    public void setBorrowerIncome(double value) {
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
     */
    public int getBorrowerNumberOfChildren() {
        return borrowerNumberOfChildren;
    }

    /**
     * Sets the value of the borrowerNumberOfChildren property.
     * 
     */
    public void setBorrowerNumberOfChildren(int value) {
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
     */
    public long getCoBorrowerCustomerId() {
        return coBorrowerCustomerId;
    }

    /**
     * Sets the value of the coBorrowerCustomerId property.
     * 
     */
    public void setCoBorrowerCustomerId(long value) {
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
     */
    public int getCoBorrowerLengthOfService() {
        return coBorrowerLengthOfService;
    }

    /**
     * Sets the value of the coBorrowerLengthOfService property.
     * 
     */
    public void setCoBorrowerLengthOfService(int value) {
        this.coBorrowerLengthOfService = value;
    }

    /**
     * Gets the value of the coBorrowerIncome property.
     * 
     */
    public double getCoBorrowerIncome() {
        return coBorrowerIncome;
    }

    /**
     * Sets the value of the coBorrowerIncome property.
     * 
     */
    public void setCoBorrowerIncome(double value) {
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
    public String getLoanFileId() {
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
    public void setLoanFileId(String value) {
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
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets the value of the loanAmount property.
     * 
     */
    public void setLoanAmount(double value) {
        this.loanAmount = value;
    }

    /**
     * Gets the value of the loanTerm property.
     * 
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * Sets the value of the loanTerm property.
     * 
     */
    public void setLoanTerm(int value) {
        this.loanTerm = value;
    }

    /**
     * Gets the value of the interestRate property.
     * 
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the value of the interestRate property.
     * 
     */
    public void setInterestRate(double value) {
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
     */
    public double getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    /**
     * Sets the value of the totalPurchasePrice property.
     * 
     */
    public void setTotalPurchasePrice(double value) {
        this.totalPurchasePrice = value;
    }

    /**
     * Gets the value of the personalCapitalContribution property.
     * 
     */
    public double getPersonalCapitalContribution() {
        return personalCapitalContribution;
    }

    /**
     * Sets the value of the personalCapitalContribution property.
     * 
     */
    public void setPersonalCapitalContribution(double value) {
        this.personalCapitalContribution = value;
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
