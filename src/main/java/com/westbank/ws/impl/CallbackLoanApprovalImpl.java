package com.westbank.ws.impl;

import com.westbank.service.LoanFileService;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@javax.jws.WebService(
        serviceName = "CallbackLoanApproval",
        portName = "CallbackLoanApprovalPort",
        targetNamespace = "urn:com:westbank:ws:client:CallbackLoanApproval",
        endpointInterface = "com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval")
public class CallbackLoanApprovalImpl implements CallbackLoanApproval {

    static final Logger log = LoggerFactory.getLogger(CallbackLoanApprovalImpl.class);

    private LoanFileService loanFileService;

    @Autowired
    public void setLoanFileService(LoanFileService loanFileService) {
        this.loanFileService = loanFileService;
    }

    public void notify(CallbackLoanApprovalRequest request) {
        log.info("Executing operation notify: " + request);
        loanFileService.updateLoanFile(request);
    }

}
