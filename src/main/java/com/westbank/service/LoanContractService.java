package com.westbank.service;

import com.westbank.domain.Contract;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;

import java.util.List;
import java.util.Optional;

public interface LoanContractService {

    LoanContractResponse createLoanContract(LoanContractRequest request);

    LoanContractResponse createLoanContractResponse(Contract contract);

    List<Contract> getAllContracts();

    Optional<Contract> getContractById(Long contractId);

    void save(Contract contract);

    List<Contract> getContractByBorrower(Long customerId);
}
