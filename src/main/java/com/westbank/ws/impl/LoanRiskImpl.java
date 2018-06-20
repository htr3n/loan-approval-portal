package com.westbank.ws.impl;

import com.westbank.ws.business.loanrisk._2009._11.LoanRisk;
import com.westbank.ws.business.loanrisk._2009._11.LoanRiskRequest;
import com.westbank.ws.business.loanrisk._2009._11.LoanRiskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import westbank.db.dao.DataAccess;
import westbank.db.entity.EstateType;
import westbank.db.entity.LoanFile;
import westbank.ws.business.loanrisk._2009._11.LoanRisk;
import westbank.ws.business.loanrisk._2009._11.LoanRiskRequest;
import westbank.ws.business.loanrisk._2009._11.LoanRiskResponse;

@javax.jws.WebService(serviceName = "LoanRisk", portName = "LoanRiskPort", targetNamespace = "urn:westbank:ws:business:LoanRisk:2009:11", endpointInterface = "westbank.ws.business.loanrisk._2009._11.LoanRisk")
public class LoanRiskImpl implements LoanRisk {

	static final Logger log = LoggerFactory.getLogger(LoanRiskImpl.class);

	@Autowired
	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	public LoanRiskResponse evaluate(LoanRiskRequest request) {
		log.info("Executing operation evaluate: " + request);
		try {
			final LoanRiskResponse response = new LoanRiskResponse();
			String loanFileId = request.getLoanFileId();
			if (dataAccessObject != null) {
				LoanFile loanFile = dataAccessObject.getLoanFileById(loanFileId);
				if (loanFile != null) {
					if (EstateType.HOUSE == loanFile.getEstateType()) {
						loanFile.setRisk(westbank.db.entity.LoanRisk.HIGH);
						response.setRisk(westbank.db.entity.LoanRisk.HIGH.name());
						response.setHighRisk(true);
					} else {
						loanFile.setRisk(westbank.db.entity.LoanRisk.LOW);
						response.setRisk(westbank.db.entity.LoanRisk.LOW.name());
						response.setHighRisk(false);
					}
					dataAccessObject.save(loanFile);
					dataAccessObject.getHibernateTemplate().flush();
					loanFile = null;
				}
			} else {
				log.error("Cannot retrieve the autowired DAO object");
			}
			log.info(" Response: " + response);
			return response;
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
