
package com.westbank.ws.business.loanfile._2018._06;

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
 *         &lt;element name="loanFileId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="borrowerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="coborrowerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer borrowerId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer coborrowerId;

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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBorrowerId() {
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
    public void setBorrowerId(Integer value) {
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
    public Integer getCoborrowerId() {
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
    public void setCoborrowerId(Integer value) {
        this.coborrowerId = value;
    }

}
