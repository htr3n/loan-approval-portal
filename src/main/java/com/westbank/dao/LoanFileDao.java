package com.westbank.dao;

import com.westbank.domain.LoanFile;

import java.util.List;

public interface LoanFileDao {

    void deleteLoanFile(LoanFile loanFile);

    void deleteLoanFileById(String loanFileId);

    List<LoanFile> findAll();

    List<LoanFile> getLoanFileByBorrower(Integer borrowerId);

    LoanFile getLoanFileById(String loanFileId);

    void save(LoanFile loanFile);

    List<LoanFile> getGrantedLoanFileByCustomer(Integer customerId);

    List<LoanFile> getLoanFileByRole(String role);
}
