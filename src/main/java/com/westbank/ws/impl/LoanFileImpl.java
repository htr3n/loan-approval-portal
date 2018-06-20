package com.westbank.ws.impl;

import com.westbank.ws.business.loanfile._2009._11.LoanFile;
import com.westbank.ws.business.loanfile._2009._11.LoanFileRequest;
import com.westbank.ws.business.loanfile._2009._11.LoanFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import westbank.db.dao.DataAccess;
import westbank.ws.business.loanfile._2009._11.LoanFile;
import westbank.ws.business.loanfile._2009._11.LoanFileRequest;
import westbank.ws.business.loanfile._2009._11.LoanFileResponse;

@javax.jws.WebService(serviceName = "LoanFile", portName = "LoanFilePort", targetNamespace = "urn:westbank:ws:business:LoanFile:2009:11", endpointInterface = "westbank.ws.business.loanfile._2009._11.LoanFile")
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
