package com.westbank.ws.impl;

import com.westbank.dao.LoanFileDao;
import com.westbank.domain.EstateType;
import com.westbank.domain.LoanFile;
import com.westbank.ws.business.loanrisk._2018._06.LoanRisk;
import com.westbank.ws.business.loanrisk._2018._06.LoanRiskRequest;
import com.westbank.ws.business.loanrisk._2018._06.LoanRiskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "LoanRisk",
        portName = "LoanRiskPort",
        targetNamespace = "urn:com:westbank:ws:business:LoanRisk:2018:06",
        endpointInterface = "com.westbank.ws.business.loanrisk._2018._06.LoanRisk")
public class LoanRiskImpl implements LoanRisk {

    protected static final Logger log = LoggerFactory.getLogger(LoanRiskImpl.class);

    private LoanFileDao loanFileDao;

    @Autowired
    public void setLoanFileDao(LoanFileDao loanFileDao) {
        this.loanFileDao = loanFileDao;
    }

    public LoanRiskResponse evaluate(LoanRiskRequest request) {
        log.info("Executing operation evaluate: " + request);
        final LoanRiskResponse response = new LoanRiskResponse();
        Long loanFileId = request.getLoanFileId();
        LoanFile loanFile = loanFileDao.getLoanFileById(loanFileId);
        if (loanFile != null) {
            if (EstateType.HOUSE == loanFile.getEstateType()) {
                loanFile.setRisk(com.westbank.domain.LoanRisk.HIGH);
                response.setRisk(com.westbank.domain.LoanRisk.HIGH.name());
                response.setHighRisk(true);
            } else {
                loanFile.setRisk(com.westbank.domain.LoanRisk.LOW);
                response.setRisk(com.westbank.domain.LoanRisk.LOW.name());
                response.setHighRisk(false);
            }
            loanFileDao.save(loanFile);
        }
        log.info(" Response: " + response);
        return response;
    }

}
