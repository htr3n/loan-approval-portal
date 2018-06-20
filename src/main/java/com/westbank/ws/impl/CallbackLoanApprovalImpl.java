package com.westbank.ws.impl;

import com.westbank.db.dao.DataAccess;
import com.westbank.db.entity.LoanFile;
import com.westbank.db.entity.LoanFileStatus;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@javax.jws.WebService(
		serviceName = "CallbackLoanApproval",
		portName = "CallbackLoanApprovalPort",
		targetNamespace = "urn:com:westbank:ws:client:CallbackLoanApproval",
		endpointInterface = "com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval")
public class CallbackLoanApprovalImpl implements CallbackLoanApproval {

	static final Logger log = LoggerFactory.getLogger(CallbackLoanApprovalImpl.class);

	@Autowired
	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	public void notify(CallbackLoanApprovalRequest request) {
		log.info("Executing operation notify: " + request);
		try {
			final String loanFileId = request.getLoanFileId();
			final String description = request.getDescription();
			LoanFileStatus status = null;
			try {
				status = Enum.valueOf(LoanFileStatus.class, request.getStatus());
			} catch (Exception e) {
			}
			if (status != null) {
				if (dataAccessObject != null) {
					LoanFile loanFile = dataAccessObject.getLoanFileById(loanFileId);
					if (loanFile != null) {
						log.info("Update the description of loan file");
						loanFile.setStatus(status);
						loanFile.setDescription(description);
						dataAccessObject.save(loanFile);
						dataAccessObject.getHibernateTemplate().flush();
					}
				}
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
