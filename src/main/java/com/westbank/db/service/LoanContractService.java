package com.westbank.db.service;

import com.westbank.db.entity.Contract;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;

import java.util.List;

public interface LoanContractService {

    LoanContractResponse createLoanContract(LoanContractRequest request);

    LoanContractResponse createLoanContractResponse(Contract contract);

    List<Contract> getAllContracts();

    Contract getContractById(String contractId);

    void save(Contract contract);

    List<Contract> getContractByBorrower(long customerId);
}
