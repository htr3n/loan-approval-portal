package com.westbank.ws.business.bankprivilege._2018._06;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-10-16T09:57:05.064+11:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "urn:com:westbank:ws:business:BankPrivilege:2018:06", name = "BankPrivilege")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface BankPrivilege {

    @WebMethod
    @WebResult(name = "BankPrivilegeResponse", targetNamespace = "urn:com:westbank:ws:business:BankPrivilege:2018:06", partName = "response")
    public BankPrivilegeResponse check(
        @WebParam(partName = "request", name = "BankPrivilegeRequest", targetNamespace = "urn:com:westbank:ws:business:BankPrivilege:2018:06")
        BankPrivilegeRequest request
    );
}
