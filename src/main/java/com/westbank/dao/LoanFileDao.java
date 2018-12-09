package com.westbank.dao;

import com.westbank.domain.LoanFile;

import java.util.List;

public interface LoanFileDao {

    void deleteLoanFile(LoanFile loanFile);

    void deleteLoanFileById(Long loanFileId);

    List<LoanFile> findAll();

    List<LoanFile> getLoanFileByBorrower(Long borrowerId);

    LoanFile getLoanFileById(Long loanFileId);

    void save(LoanFile loanFile);

    List<LoanFile> getGrantedLoanFileByCustomer(Long customerId);

    List<LoanFile> getLoanFileByRole(String role);
}
