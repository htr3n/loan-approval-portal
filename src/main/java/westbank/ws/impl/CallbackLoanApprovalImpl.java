package westbank.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import westbank.db.dao.DataAccess;
import westbank.db.entity.LoanFile;
import westbank.db.entity.LoanFileStatus;
import westbank.ws.client.callbackloanapproval.CallbackLoanApproval;
import westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;

@javax.jws.WebService(serviceName = "CallbackLoanApproval", portName = "CallbackLoanApprovalPort", targetNamespace = "urn:westbank:ws:client:CallbackLoanApproval", endpointInterface = "westbank.ws.client.callbackloanapproval.CallbackLoanApproval")
public class CallbackLoanApprovalImpl implements CallbackLoanApproval {

	static final Logger log = LoggerFactory.getLogger(CallbackLoanApprovalImpl.class);

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
				if (dataAccessObject != null && request != null) {
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
