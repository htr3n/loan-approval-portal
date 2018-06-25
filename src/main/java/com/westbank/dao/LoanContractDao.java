package com.westbank.dao;

import com.westbank.domain.Contract;
import com.westbank.domain.Customer;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;

import java.util.List;
import java.util.Optional;

public interface LoanContractDao {

    Contract createAndStoreNewContract(LoanContractRequest request);

    void deleteContract(Contract contract);

    void deleteLoanContractById(String contractId);

    List<Contract> findAll();

    List<Contract> findContractByBorrowerId(Integer borrowerId);

    List<Contract> findContractByBorrower(Customer borrower);

    Optional<Contract> findContractById(String contractId);

    void save(Contract loan);
}
