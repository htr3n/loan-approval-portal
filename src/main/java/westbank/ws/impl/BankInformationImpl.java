package westbank.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import westbank.db.dao.DataAccess;
import westbank.ws.business.bankinformation._2009._11.BankInformation;
import westbank.ws.business.bankinformation._2009._11.BankInformationRequest;
import westbank.ws.business.bankinformation._2009._11.BankInformationResponse;

@javax.jws.WebService(serviceName = "BankInformation", portName = "BankInformationPort", targetNamespace = "urn:westbank:ws:business:BankInformation:2009:11", endpointInterface = "westbank.ws.business.bankinformation._2009._11.BankInformation")
public class BankInformationImpl implements BankInformation {

	static final Logger log = LoggerFactory.getLogger(BankInformationImpl.class);

	protected DataAccess dataAccessObject;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

	/**
	 * 
	 * Calculates the monthly payment according to the amortization formulas at
	 * 
	 * http://www.vertex42.com/ExcelArticles/amortization-calculation.html
	 * 
	 * monthlyPayment = loanAmount * r * (1 + r) ^ n / ( ( 1 + r )^n - 1) =
	 * loanAmount * r / (1 - 1/ (1 + r)^n )
	 * 
	 * where: monthlyPayment = payment amount per month r = interest rate per period
	 * n = loan terms (by years convert to the number of months)
	 * 
	 * 
	 */
	public BankInformationResponse retrieve(BankInformationRequest request) {
		log.info("Executing operation retrieve:" + request);
		try {

			// loan term = loanTerm (years) * 12;
			int loanTerm = request.getLoanTerm() * 12;

			// monthlyInterestRate = annualInterestRate / 12
			double monthlyInterestRate = request.getInterestRate() / 12.0;

			// total loan amount
			double loanAmount = request.getLoanAmount();

			final BankInformationResponse response = new BankInformationResponse();

			double monthlyPayment = 0;

			monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1.0 / Math.pow(monthlyInterestRate + 1, loanTerm));

			response.setMonthlyPayment(monthlyPayment);

			log.info(" Response: " + response);

			return response;

		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
