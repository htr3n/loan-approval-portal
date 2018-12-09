package com.westbank.dao;

import com.westbank.domain.Contract;
import com.westbank.domain.Customer;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;

import java.util.List;
import java.util.Optional;

public interface LoanContractDao {

    Contract createAndStoreNewContract(LoanContractRequest request);

    void deleteContract(Contract contract);

    void deleteLoanContractById(Long contractId);

    List<Contract> findAll();

    List<Contract> findContractByBorrowerId(Long borrowerId);

    List<Contract> findContractByBorrower(Customer borrower);

    Optional<Contract> findContractById(Long contractId);

    void save(Contract loan);
}
