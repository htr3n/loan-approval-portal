
package com.westbank.ws.process.loanapproval._2018._06;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.westbank.ws.process.loanapproval._2018._06 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.westbank.ws.process.loanapproval._2018._06
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoanApprovalRequest }
     * 
     */
    public LoanApprovalRequest createLoanApprovalRequest() {
        return new LoanApprovalRequest();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link CustomerDecision }
     * 
     */
    public CustomerDecision createCustomerDecision() {
        return new CustomerDecision();
    }

    /**
     * Create an instance of {@link TokenType }
     * 
     */
    public TokenType createTokenType() {
        return new TokenType();
    }

    /**
     * Create an instance of {@link ManagerSignature }
     * 
     */
    public ManagerSignature createManagerSignature() {
        return new ManagerSignature();
    }

    /**
     * Create an instance of {@link StaffIdentity }
     * 
     */
    public StaffIdentity createStaffIdentity() {
        return new StaffIdentity();
    }

    /**
     * Create an instance of {@link ManagerDecision }
     * 
     */
    public ManagerDecision createManagerDecision() {
        return new ManagerDecision();
    }

}
