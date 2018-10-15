package com.westbank.ws.business.bankinformation._2018._06;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-10-16T09:57:05.483+11:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "BankInformation",
                  targetNamespace = "urn:com:westbank:ws:business:BankInformation:2018:06")
public class BankInformation_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:com:westbank:ws:business:BankInformation:2018:06", "BankInformation");
    public final static QName BankInformationPort = new QName("urn:com:westbank:ws:business:BankInformation:2018:06", "BankInformationPort");
    static {
        WSDL_LOCATION = null;
    }

    public BankInformation_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BankInformation_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankInformation_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BankInformation_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BankInformation_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BankInformation_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BankInformation
     */
    @WebEndpoint(name = "BankInformationPort")
    public BankInformation getBankInformationPort() {
        return super.getPort(BankInformationPort, BankInformation.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankInformation
     */
    @WebEndpoint(name = "BankInformationPort")
    public BankInformation getBankInformationPort(WebServiceFeature... features) {
        return super.getPort(BankInformationPort, BankInformation.class, features);
    }

}
