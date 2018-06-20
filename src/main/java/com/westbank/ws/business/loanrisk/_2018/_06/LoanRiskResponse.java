
package com.westbank.ws.business.loanrisk._2018._06;

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
 *         &lt;element name="highRisk" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="risk" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "highRisk",
    "risk"
})
@XmlRootElement(name = "LoanRiskResponse")
public class LoanRiskResponse {

    protected boolean highRisk;
    @XmlElement(required = true)
    protected String risk;

    /**
     * Gets the value of the highRisk property.
     * 
     */
    public boolean isHighRisk() {
        return highRisk;
    }

    /**
     * Sets the value of the highRisk property.
     * 
     */
    public void setHighRisk(boolean value) {
        this.highRisk = value;
    }

    /**
     * Gets the value of the risk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRisk() {
        return risk;
    }

    /**
     * Sets the value of the risk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRisk(String value) {
        this.risk = value;
    }

}
