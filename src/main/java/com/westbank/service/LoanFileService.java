package com.westbank.service;

import com.westbank.domain.LoanFile;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;

import java.util.List;

public interface LoanFileService {

    LoanFileResponse saveLoanRequest(LoanFileRequest request);

    void updateLoanFile(CallbackLoanApprovalRequest request);

    boolean checkCreditWorthiness(CreditWorthinessRequest request);

    List<LoanFile> getAllLoanFiles();

    LoanFile getLoanFileById(Long loanFileId);

    List<LoanFile> getLoanFileByBorrower(Long customerId);

    void save(LoanFile loanFile);

}
