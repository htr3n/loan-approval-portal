package com.westbank.ws.business.creditworthiness._2018._06;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-06-25T11:48:11.635+10:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "urn:com:westbank:ws:business:CreditWorthiness:2018:06", name = "CreditWorthiness")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CreditWorthiness {

    @WebMethod
    @WebResult(name = "CreditWorthinessResponse", targetNamespace = "urn:com:westbank:ws:business:CreditWorthiness:2018:06", partName = "response")
    public CreditWorthinessResponse check(
        @WebParam(partName = "request", name = "CreditWorthinessRequest", targetNamespace = "urn:com:westbank:ws:business:CreditWorthiness:2018:06")
        CreditWorthinessRequest request
    );
}
