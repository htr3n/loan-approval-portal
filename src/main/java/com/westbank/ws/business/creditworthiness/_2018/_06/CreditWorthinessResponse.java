
package com.westbank.ws.business.creditworthiness._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="creditWorthiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "creditWorthiness"
})
@XmlRootElement(name = "CreditWorthinessResponse")
public class CreditWorthinessResponse {

    protected boolean creditWorthiness;

    /**
     * Gets the value of the creditWorthiness property.
     * 
     */
    public boolean isCreditWorthiness() {
        return creditWorthiness;
    }

    /**
     * Sets the value of the creditWorthiness property.
     * 
     */
    public void setCreditWorthiness(boolean value) {
        this.creditWorthiness = value;
    }

}
