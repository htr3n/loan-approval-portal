package com.westbank.ws.impl;

import com.westbank.service.LoanFileService;
import com.westbank.ws.business.loanfile._2018._06.LoanFile;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "LoanFile",
        portName = "LoanFilePort",
        targetNamespace = "urn:com:westbank:ws:business:LoanFile:2018:06",
        endpointInterface = "com.westbank.ws.business.loanfile._2018._06.LoanFile")
public class LoanFileImpl implements LoanFile {

    protected static final Logger log = LoggerFactory.getLogger(LoanFileImpl.class);

    @Autowired
    private LoanFileService loanFileService;

    @Override
    public LoanFileResponse update(LoanFileRequest request) {
        log.info("Creating loan file request: " + request);
        LoanFileResponse response = loanFileService.saveLoanRequest(request);
        log.info(" Response: " + response);
        return response;
    }


}
