package com.westbank.ws.impl;

import java.util.Random;

import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilegeRequest;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilegeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import com.westbank.db.dao.DataAccess;

@javax.jws.WebService(
		serviceName = "BankPrivilege",
		portName = "BankPrivilegePort",
		targetNamespace = "urn:com:westbank:ws:business:BankPrivilege:2018:06",
		endpointInterface = "com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege")
public class BankPrivilegeImpl implements BankPrivilege {

	static final Logger log = LoggerFactory.getLogger(BankPrivilegeImpl.class);

	@Autowired
	protected DataAccess dataAccessObject;

	public BankPrivilegeResponse check(BankPrivilegeRequest request) {
		log.info("Executing operation check" + request);
		try {
			final BankPrivilegeResponse response = new BankPrivilegeResponse();
			String lastName = request.getBorrowerLastName();
			if ("Power".equalsIgnoreCase(lastName)) {
				response.setRegistered(true);
				response.setNumberOfIncidents(0);
				response.setNumberOfBanks(0);
			} else {
				response.setRegistered(true);
				response.setNumberOfIncidents(10 + new Random().nextInt(10));
				response.setNumberOfBanks(1 + new Random().nextInt(10));
			}
			response.setDescription("");
			log.info(" Response: " + response);
			return response;
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

}
