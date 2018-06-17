package westbank.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import westbank.db.dao.DataAccess;
import westbank.ws.business.loanapprovalclosing._2009._11.LoanApprovalClosing;
import westbank.ws.business.loanapprovalclosing._2009._11.LoanApprovalClosingRequest;
import westbank.ws.business.loanapprovalclosing._2009._11.LoanApprovalClosingResponse;

@javax.jws.WebService(serviceName = "LoanApprovalClosing", portName = "LoanApprovalClosingPort", targetNamespace = "urn:westbank:ws:business:LoanApprovalClosing:2009:11", endpointInterface = "westbank.ws.business.loanapprovalclosing._2009._11.LoanApprovalClosing")
public class LoanApprovalClosingImpl implements LoanApprovalClosing {

	static final Logger log = LoggerFactory.getLogger(LoanApprovalClosingImpl.class);

	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	public LoanApprovalClosingResponse close(LoanApprovalClosingRequest request) {
		log.info("Executing operation close:" + request);
		try {
			final LoanApprovalClosingResponse response = new LoanApprovalClosingResponse();
			response.setStatus(true);
			log.info(" Response: " + response);
			return response;
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
