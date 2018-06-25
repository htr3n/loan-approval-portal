package com.westbank.ws.impl;

import com.westbank.ws.business.loansettlement._2018._06.LoanSettlement;
import com.westbank.ws.business.loansettlement._2018._06.LoanSettlementRequest;
import com.westbank.ws.business.loansettlement._2018._06.LoanSettlementResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "LoanSettlement",
        portName = "LoanSettlementPort",
        targetNamespace = "urn:com:westbank:ws:business:LoanSettlement:2018:06",
        endpointInterface = "com.westbank.ws.business.loansettlement._2018._06.LoanSettlement")
public class LoanSettlementImpl implements LoanSettlement {

    private static final Logger log = LoggerFactory.getLogger(LoanSettlementImpl.class);

    public LoanSettlementResponse start(LoanSettlementRequest request) {
        log.info("Executing operation start: " + request);
        final LoanSettlementResponse response = new LoanSettlementResponse();
        response.setStatus(true);
        log.info(" Response: " + response);
        return response;
    }

}
