package westbank.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import westbank.db.dao.DataAccess;
import westbank.ws.client.callbackloancontract.CallbackLoanContract;
import westbank.ws.client.callbackloancontract.CallbackLoanContractRequest;

@javax.jws.WebService(serviceName = "CallbackLoanContract", portName = "CallbackLoanContractPort", targetNamespace = "urn:westbank:ws:client:CallbackLoanContract", endpointInterface = "westbank.ws.client.callbackloancontract.CallbackLoanContract")
public class CallbackLoanContractImpl implements CallbackLoanContract {

	static final Logger log = LoggerFactory.getLogger(CallbackLoanContractImpl.class);

	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	public void send(CallbackLoanContractRequest request) {
		log.info("Executing operation send:" + request);
		try {
			//
			// long borrowerId = request.getBorrowerCustomerId();
			// String contractId = request.getLoanContractId();
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
