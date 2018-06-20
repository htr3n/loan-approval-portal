package com.westbank.ws.impl;

import com.westbank.db.dao.DataAccess;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosing;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosingRequest;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@javax.jws.WebService(
		serviceName = "LoanApprovalClosing",
		portName = "LoanApprovalClosingPort",
		targetNamespace = "urn:com:westbank:ws:business:LoanApprovalClosing:2018:06",
		endpointInterface = "com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosing")
public class LoanApprovalClosingImpl implements LoanApprovalClosing {

	static final Logger log = LoggerFactory.getLogger(LoanApprovalClosingImpl.class);

	@Autowired
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
