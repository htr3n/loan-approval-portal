package com.westbank.db.dao;

import com.westbank.db.entity.LoanFile;

import java.util.List;

public interface LoanFileDao {

    void deleteLoanFile(LoanFile loanFile);

    void deleteLoanFile(String loanFileId);

    List<LoanFile> getAllLoanFiles();

    List<LoanFile> getLoanFileByBorrower(long borrowerId);

    LoanFile getLoanFileById(String loanFileId);

    void save(LoanFile loanFile);

    List<LoanFile> getGrantedLoanFileByCustomer(long customerId);

    List<LoanFile> getLoanFileByRole(String role);
}
