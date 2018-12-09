
package com.westbank.ws.client.callbackloancontract;

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
 *         &lt;element name="borrowerCustomerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="loanContractId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "loanContractId"
})
@XmlRootElement(name = "CallbackLoanContractRequest")
public class CallbackLoanContractRequest {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long borrowerCustomerId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "long")
    protected Long loanContractId;

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

}
