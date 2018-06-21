package com.westbank.db.service;

import com.westbank.db.entity.LoanFile;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;

import java.util.List;

public interface LoanFileService {

    LoanFileResponse saveLoanRequest(LoanFileRequest request);

    void updateLoanFile(CallbackLoanApprovalRequest request);

    boolean checkCreditWorthiness(CreditWorthinessRequest request);

    List<LoanFile> getAllLoanFiles();

    LoanFile getLoanFileById(String loanFileId);

    List<LoanFile> getLoanFileByBorrower(long customerId);

    void save(LoanFile loanFile);

}
