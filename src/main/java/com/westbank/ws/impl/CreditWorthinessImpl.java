package com.westbank.ws.impl;

import com.westbank.db.dao.DataAccess;
import com.westbank.db.entity.LoanFile;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessRequest;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@javax.jws.WebService(
		serviceName = "CreditWorthiness",
		portName = "CreditWorthinessPort",
		targetNamespace = "urn:com:westbank:ws:business:CreditWorthiness:2018:06",
		endpointInterface = "com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness")
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
