
package com.westbank.ws.business.loanfile._2018._06;

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
 *         &lt;element name="loanFileId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="coborrowerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "borrowerId",
    "coborrowerId"
})
@XmlRootElement(name = "LoanFileResponse")
public class LoanFileResponse {

    @XmlElement(required = true)
    protected String loanFileId;
    protected long borrowerId;
    protected long coborrowerId;

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
     * Gets the value of the borrowerId property.
     * 
     */
    public long getBorrowerId() {
        return borrowerId;
    }

    /**
     * Sets the value of the borrowerId property.
     * 
     */
    public void setBorrowerId(long value) {
        this.borrowerId = value;
    }

    /**
     * Gets the value of the coborrowerId property.
     * 
     */
    public long getCoborrowerId() {
        return coborrowerId;
    }

    /**
     * Sets the value of the coborrowerId property.
     * 
     */
    public void setCoborrowerId(long value) {
        this.coborrowerId = value;
    }

}
