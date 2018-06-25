package com.westbank.ws.impl;

import com.westbank.service.LoanContractService;
import com.westbank.ws.business.loancontract._2018._06.LoanContract;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "LoanContract",
        portName = "LoanContractPort",
        targetNamespace = "urn:com:westbank:ws:business:LoanContract:2018:06",
        endpointInterface = "com.westbank.ws.business.loancontract._2018._06.LoanContract")
public class LoanContractImpl implements LoanContract {

    static final Logger log = LoggerFactory.getLogger(LoanContractImpl.class);

    private LoanContractService loanContractService;

    @Autowired
    public void setLoanContractService(LoanContractService loanContractService) {
        this.loanContractService = loanContractService;
    }



    @Override
    public LoanContractResponse create(LoanContractRequest request) {
        log.info("Executing operation build: " + request);
        LoanContractResponse response = loanContractService.createLoanContract(request);
        log.info(" Response: " + response);
        return response;
    }

}
