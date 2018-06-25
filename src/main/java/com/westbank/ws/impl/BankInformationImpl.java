package com.westbank.ws.impl;

import com.westbank.ws.business.bankinformation._2018._06.BankInformation;
import com.westbank.ws.business.bankinformation._2018._06.BankInformationRequest;
import com.westbank.ws.business.bankinformation._2018._06.BankInformationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
        serviceName = "BankInformation",
        portName = "BankInformationPort",
        targetNamespace = "urn:com:westbank:ws:business:BankInformation:2018:06",
        endpointInterface = "com.westbank.ws.business.bankinformation._2018._06.BankInformation")
public class BankInformationImpl implements BankInformation {

    protected static final Logger log = LoggerFactory.getLogger(BankInformationImpl.class);

    /**
     * Calculates the monthly payment according to the amortization formulas at
     * <p>
     * http://www.vertex42.com/ExcelArticles/amortization-calculation.html
     * <p>
     * monthlyPayment = loanAmount * r * (1 + r) ^ n / ( ( 1 + r )^n - 1) =
     * loanAmount * r / (1 - 1/ (1 + r)^n )
     * <p>
     * where: monthlyPayment = payment amount per month r = interest rate per period
     * n = loan terms (by years convert to the number of months)
     */
    public BankInformationResponse retrieve(BankInformationRequest request) {
        log.info("Executing operation retrieve:" + request);

        // loan term = loanTerm (years) * 12;
        Integer loanTerm = request.getLoanTerm() * 12;

        // monthlyInterestRate = annualInterestRate / 12
        Double monthlyInterestRate = request.getInterestRate() / 12.0;

        // total loan amount
        Double loanAmount = request.getLoanAmount();

        final BankInformationResponse response = new BankInformationResponse();

        Double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1.0 / Math.pow(monthlyInterestRate + 1, loanTerm));

        response.setMonthlyPayment(monthlyPayment);

        log.info(" Response: " + response);

        return response;

    }
}
