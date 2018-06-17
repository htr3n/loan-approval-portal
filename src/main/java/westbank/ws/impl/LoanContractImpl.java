package westbank.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import westbank.db.dao.DataAccess;
import westbank.ws.business.loancontract._2009._11.LoanContract;
import westbank.ws.business.loancontract._2009._11.LoanContractRequest;
import westbank.ws.business.loancontract._2009._11.LoanContractResponse;

@javax.jws.WebService(serviceName = "LoanContract", portName = "LoanContractPort", targetNamespace = "urn:westbank:ws:business:LoanContract:2009:11", endpointInterface = "westbank.ws.business.loancontract._2009._11.LoanContract")
public class LoanContractImpl implements LoanContract {

	static final Logger log = LoggerFactory.getLogger(LoanContractImpl.class);
	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	@Override
	public LoanContractResponse create(LoanContractRequest request) {
		log.info("Executing operation build: " + request);
		try {
			LoanContractResponse response = null;
			if (dataAccessObject != null) {
				response = dataAccessObject.createLoanContract(request);
			}
			log.info(" Response: " + response);
			return response;
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
