package com.westbank.ws.impl;

import com.westbank.service.LoanFileService;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessRequest;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "CreditWorthiness",
        portName = "CreditWorthinessPort",
        targetNamespace = "urn:com:westbank:ws:business:CreditWorthiness:2018:06",
        endpointInterface = "com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness")
public class CreditWorthinessImpl implements CreditWorthiness {

    static final Logger log = LoggerFactory.getLogger(CreditWorthinessImpl.class);

    private LoanFileService loanFileService;

    @Autowired
    public void setLoanFileService(LoanFileService loanFileService) {
        this.loanFileService = loanFileService;
    }

    public CreditWorthinessResponse check(CreditWorthinessRequest request) {
        log.info("Executing operation check:" + request);
        final CreditWorthinessResponse response = new CreditWorthinessResponse();
        response.setCreditWorthiness(loanFileService.checkCreditWorthiness(request));
        log.info(" Response: " + response);
        return response;
    }
}
