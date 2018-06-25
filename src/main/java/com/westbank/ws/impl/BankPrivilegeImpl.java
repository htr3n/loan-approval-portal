package com.westbank.ws.impl;

import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilegeRequest;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilegeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@javax.jws.WebService(
        serviceName = "BankPrivilege",
        portName = "BankPrivilegePort",
        targetNamespace = "urn:com:westbank:ws:business:BankPrivilege:2018:06",
        endpointInterface = "com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege")
public class BankPrivilegeImpl implements BankPrivilege {

    protected static final Logger log = LoggerFactory.getLogger(BankPrivilegeImpl.class);

    public BankPrivilegeResponse check(BankPrivilegeRequest request) {
        log.info("Executing operation check" + request);
        final BankPrivilegeResponse response = new BankPrivilegeResponse();
        String lastName = request.getBorrowerLastName();
        if ("Power".equalsIgnoreCase(lastName)) {
            response.setRegistered(true);
            response.setNumberOfIncidents(0);
            response.setNumberOfBanks(0);
        } else {
            response.setRegistered(true);
            response.setNumberOfIncidents(10 + new Random().nextInt(10));
            response.setNumberOfBanks(1 + new Random().nextInt(10));
        }
        response.setDescription("");
        log.info(" Response: " + response);
        return response;
    }
}
