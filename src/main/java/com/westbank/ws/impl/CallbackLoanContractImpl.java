package com.westbank.ws.impl;

import com.westbank.ws.client.callbackloancontract.CallbackLoanContract;
import com.westbank.ws.client.callbackloancontract.CallbackLoanContractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "CallbackLoanContract",
        portName = "CallbackLoanContractPort",
        targetNamespace = "urn:com:westbank:ws:client:CallbackLoanContract",
        endpointInterface = "com.westbank.ws.client.callbackloancontract.CallbackLoanContract")
public class CallbackLoanContractImpl implements CallbackLoanContract {

    static final Logger log = LoggerFactory.getLogger(CallbackLoanContractImpl.class);

    public void send(CallbackLoanContractRequest request) {
        log.info("Executing operation send:" + request);
        // TODO
        // Integer borrowerId = request.getBorrowerCustomerId();
        // String contractId = request.getLoanContractId();
    }

}
