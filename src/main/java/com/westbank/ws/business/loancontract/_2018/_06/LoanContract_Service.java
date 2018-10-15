package com.westbank.ws.business.loancontract._2018._06;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-10-16T09:57:03.948+11:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "LoanContract",
                  targetNamespace = "urn:com:westbank:ws:business:LoanContract:2018:06")
public class LoanContract_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:com:westbank:ws:business:LoanContract:2018:06", "LoanContract");
    public final static QName LoanContractPort = new QName("urn:com:westbank:ws:business:LoanContract:2018:06", "LoanContractPort");
    static {
        WSDL_LOCATION = null;
    }

    public LoanContract_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LoanContract_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoanContract_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public LoanContract_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public LoanContract_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public LoanContract_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns LoanContract
     */
    @WebEndpoint(name = "LoanContractPort")
    public LoanContract getLoanContractPort() {
        return super.getPort(LoanContractPort, LoanContract.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoanContract
     */
    @WebEndpoint(name = "LoanContractPort")
    public LoanContract getLoanContractPort(WebServiceFeature... features) {
        return super.getPort(LoanContractPort, LoanContract.class, features);
    }

}
