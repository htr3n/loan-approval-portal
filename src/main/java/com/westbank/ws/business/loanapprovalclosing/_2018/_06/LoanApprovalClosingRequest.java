
package com.westbank.ws.business.loanapprovalclosing._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
 *         &lt;element name="loanFileId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="loanContractId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "loanContractId",
    "staffId",
    "staffRole"
})
@XmlRootElement(name = "LoanApprovalClosingRequest")
public class LoanApprovalClosingRequest {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanFileId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanContractId;
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
