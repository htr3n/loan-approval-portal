
package com.westbank.ws.business.loanfile._2018._06;

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

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanFileId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long borrowerId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long coborrowerId;

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
     * Gets the value of the borrowerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getBorrowerId() {
        return borrowerId;
    }

    /**
     * Sets the value of the borrowerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerId(Long value) {
        this.borrowerId = value;
    }

    /**
     * Gets the value of the coborrowerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getCoborrowerId() {
        return coborrowerId;
    }

    /**
     * Sets the value of the coborrowerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoborrowerId(Long value) {
        this.coborrowerId = value;
    }

}
