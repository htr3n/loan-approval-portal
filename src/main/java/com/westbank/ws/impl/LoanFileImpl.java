package com.westbank.ws.impl;

import com.westbank.db.dao.DataAccess;
import com.westbank.ws.business.loanfile._2018._06.LoanFile;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@javax.jws.WebService(
		serviceName = "LoanFile",
		portName = "LoanFilePort",
		targetNamespace = "urn:com:westbank:ws:business:LoanFile:2018:06",
		endpointInterface = "com.westbank.ws.business.loanfile._2018._06.LoanFile")
public class LoanFileImpl implements LoanFile {

	static final Logger log = LoggerFactory.getLogger(LoanFileImpl.class);

	@Autowired
	protected DataAccess dataAccessObject;

	@Override
	public LoanFileResponse update(LoanFileRequest request) {
		LoanFileResponse response = null;

		log.info("Creating loan file request: " + request);
		if (dataAccessObject != null) {
			try {
				response = dataAccessObject.saveLoanRequest(request);
			} catch (final Exception ex) {
				ex.printStackTrace();
			}
		}
		log.info(" Response: " + response);
		return response;
	}

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

}
