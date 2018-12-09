
package com.westbank.ws.business.taskdispatch._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter2;


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
 *         &lt;element name="loanAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
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
    "loanAmount",
    "staffId",
    "staffRole"
})
@XmlRootElement(name = "TaskDispatchRequest")
public class TaskDispatchRequest {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "double")
    protected Double loanAmount;
    @XmlElement(required = true)
    protected String staffId;
    @XmlElement(required = true)
    protected String staffRole;

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
