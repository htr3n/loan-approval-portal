
package com.westbank.ws.process.loanapproval._2018._06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TokenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="X509SubjectName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="X509Certificate" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="X509IssuerSerial" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="validityFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="validityUntil" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenType", propOrder = {
    "serialNumber",
    "x509SubjectName",
    "x509Certificate",
    "x509IssuerSerial",
    "validityFrom",
    "validityUntil"
})
public class TokenType {

    @XmlElement(required = true)
    protected String serialNumber;
    @XmlElement(name = "X509SubjectName", required = true)
    protected String x509SubjectName;
    @XmlElement(name = "X509Certificate", required = true)
    protected byte[] x509Certificate;
    @XmlElement(name = "X509IssuerSerial", required = true)
    protected String x509IssuerSerial;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityFrom;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityUntil;

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the x509SubjectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX509SubjectName() {
        return x509SubjectName;
    }

    /**
     * Sets the value of the x509SubjectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX509SubjectName(String value) {
        this.x509SubjectName = value;
    }

    /**
     * Gets the value of the x509Certificate property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getX509Certificate() {
        return x509Certificate;
    }

    /**
     * Sets the value of the x509Certificate property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setX509Certificate(byte[] value) {
        this.x509Certificate = value;
    }

    /**
     * Gets the value of the x509IssuerSerial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX509IssuerSerial() {
        return x509IssuerSerial;
    }

    /**
     * Sets the value of the x509IssuerSerial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX509IssuerSerial(String value) {
        this.x509IssuerSerial = value;
    }

    /**
     * Gets the value of the validityFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityFrom() {
        return validityFrom;
    }

    /**
     * Sets the value of the validityFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityFrom(XMLGregorianCalendar value) {
        this.validityFrom = value;
    }

    /**
     * Gets the value of the validityUntil property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityUntil() {
        return validityUntil;
    }

    /**
     * Sets the value of the validityUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityUntil(XMLGregorianCalendar value) {
        this.validityUntil = value;
    }

}
