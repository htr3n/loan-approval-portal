package com.westbank.db.dao;

import com.westbank.db.entity.Contract;
import com.westbank.db.entity.Customer;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;

import java.util.List;

public interface LoanContractDao {

    Contract createAndStoreNewContract(LoanContractRequest request);

    void deleteContract(Contract contract);

    void deleteLoanContract(String contractId);

    List<Contract> getAllContracts();

    List<Contract> getContractByBorrower(long borrowerId);

    List<Contract> getContractByBorrower(Customer borrower);

    Contract getContractById(String contractId);

    void save(Contract loan);
}
