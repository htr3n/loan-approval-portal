package com.westbank.ws.impl;

import com.westbank.ws.business.creditworthiness._2009._11.CreditWorthiness;
import com.westbank.ws.business.creditworthiness._2009._11.CreditWorthinessRequest;
import com.westbank.ws.business.creditworthiness._2009._11.CreditWorthinessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import westbank.db.dao.DataAccess;
import westbank.db.entity.LoanFile;
import westbank.ws.business.creditworthiness._2009._11.CreditWorthiness;
import westbank.ws.business.creditworthiness._2009._11.CreditWorthinessRequest;
import westbank.ws.business.creditworthiness._2009._11.CreditWorthinessResponse;

@javax.jws.WebService(serviceName = "CreditWorthiness", portName = "CreditWorthinessPort", targetNamespace = "urn:westbank:ws:business:CreditWorthiness:2009:11", endpointInterface = "westbank.ws.business.creditworthiness._2009._11.CreditWorthiness")
public class CreditWorthinessImpl implements CreditWorthiness {

	static final Logger log = LoggerFactory.getLogger(CreditWorthinessImpl.class);

	@Autowired
	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	public CreditWorthinessResponse check(CreditWorthinessRequest request) {
		log.info("Executing operation check:" + request);
		try {
			final CreditWorthinessResponse response = new CreditWorthinessResponse();
			LoanFile loanFile = dataAccessObject.getLoanFileById(request.getLoanFileId());
			if (loanFile != null && "Alice".equalsIgnoreCase(loanFile.getBorrower().getFirstName())) {
				response.setCreditWorthiness(true);
			} else {
				response.setCreditWorthiness(false);
			}
			log.info(" Response: " + response);
			return response;
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
