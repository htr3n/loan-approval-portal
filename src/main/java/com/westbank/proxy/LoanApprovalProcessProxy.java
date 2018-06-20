package com.westbank.proxy;

import java.util.Base64;
import java.util.GregorianCalendar;
import java.util.UUID;

import com.westbank.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import westbank.db.dao.DataAccess;
import westbank.db.entity.Address;
import westbank.db.entity.Contract;
import westbank.db.entity.Customer;
import westbank.db.entity.LoanFile;
import westbank.db.entity.Staff;
import westbank.mvc.customer.model.ApplicationForm;
import westbank.util.DateUtil;
import westbank.ws.process.loanapproval._2009._11.AddressType;
import westbank.ws.process.loanapproval._2009._11.CustomerDecision;
import westbank.ws.process.loanapproval._2009._11.LoanApproval;
import westbank.ws.process.loanapproval._2009._11.LoanApprovalRequest;
import westbank.ws.process.loanapproval._2009._11.ManagerDecision;
import westbank.ws.process.loanapproval._2009._11.ManagerSignature;
import westbank.ws.process.loanapproval._2009._11.StaffIdentity;
import westbank.ws.process.loanapproval._2009._11.TokenType;

@Component
public class LoanApprovalProcessProxy {

	static final String WSDL = "?wsdl";
	static final Logger log = LoggerFactory.getLogger(LoanApprovalProcessProxy.class);

	@Autowired
	protected DataAccess dataAccessObject;

	protected LoanApproval loanApproval;

	public LoanApprovalProcessProxy() {
	}

	/**
	 * Invokes the service exposed by the loan approval process in order to start
	 * the process
	 * 
	 * @param form
	 *            -- the input loan {@link ApplicationForm} object
	 * @return <code>true</code> if successful, otherwise, <code>false</code>
	 */
	public boolean startProcess(ApplicationForm form) {
		boolean isOK = false;
		try {
			log.info("Start loan approval process on behalf of " + form.getBorrowerTitle() + " "
					+ form.getBorrowerFirstName() + " " + form.getBorrowerLastName());

			LoanApprovalRequest request = createLoanRequest(form);

			if (request != null && loanApproval != null) {
				request.setLoanFileId(UUID.randomUUID().toString());
				log.debug("Start process: " + request);
				loanApproval.start(request);
				isOK = true;
			} else {
				log.info("Cannot create a new loan request. Abort!");
			}
		} catch (final Exception e) {
			log.error("Error while starting the process: " + e.getMessage());
			e.printStackTrace();
		}
		return isOK;
	}

	/**
	 * Invokes the loan approval process at the point of tasks named "Access Portal"
	 * on behalf of either the BROKER, SUPERVISOR, or CLERK
	 * 
	 * @param staffId
	 *            -- the ID of the {@link Staff} who performs the task
	 * @param role
	 *            -- the active role of the {@link Staff} who performs the task
	 * @param loanFileId
	 *            -- the ID of the {@link LoanFile} under consideration
	 * @return <code>true</code> if successful, otherwise, <code>false</code>
	 */
	public boolean processedByStaff(String staffId, String role, String loanFileId) {
		boolean isOK = false;
		try {
			final StaffIdentity request = new StaffIdentity();

			byte[] tokenString = Base64.getEncoder().encode((staffId + "/" + role).getBytes());

			request.setStaffId(staffId);
			request.setStaffRole(role);
			request.setLoanFileId(loanFileId);
			request.setSecureToken(tokenString);

			if (request != null && loanApproval != null) {
				log.debug("Staff involve: " + request);
				loanApproval.processedByStaff(request);
				isOK = true;
			}
		} catch (final Exception e) {
			log.error("Staff " + staffId + "(role=" + role + "): " + e.getMessage());
		}
		return isOK;
	}

	/**
	 * Invokes the loan approval process at the point of tasks named "Judge
	 * High-Risk Loan" on behalf of the MANAGER
	 * 
	 * @param staffId
	 *            -- the ID of the {@link Staff} who performs the task
	 * @param role
	 *            -- the active role of the {@link Staff} who performs the task
	 * @param loanFileId
	 *            -- the ID of the {@link LoanFile} under consideration
	 * @return <code>true</code> if successful, otherwise, <code>false</code>
	 */
	public boolean informManagerDecision(String staffId, String role, String loanFileId, boolean isGranted) {
		boolean isOK = false;
		try {
			final ManagerDecision request = new ManagerDecision();
			byte[] tokenString = Base64.getEncoder().encode((staffId + "/" + role).getBytes());
			request.setStaffId(staffId);
			request.setStaffRole(role);
			request.setLoanFileId(loanFileId);
			request.setGranted(isGranted);
			request.setSecureToken(tokenString);

			if (request != null && loanApproval != null) {
				log.debug("Send the manager's decision: " + request);
				loanApproval.decidedByManager(request);
				isOK = true;
			}
		} catch (final Exception e) {
			log.error("Staff " + staffId + "(role=" + role + "): " + e.getMessage());
		}
		return isOK;
	}

	/**
	 * Invokes the service exposed by the loan approval process in order to sign the
	 * loan contract
	 * 
	 * @param customerId
	 *            -- the {@link Customer}'s ID
	 * @param customerName
	 *            -- the {@link Customer}'s full name
	 * @param loanFileId
	 *            -- the {@link LoanFile}'s ID
	 * @param contractId
	 *            -- the {@link Contract}'s ID
	 * @param accepted
	 *            -- whether the customer accepts the contract or not
	 * @return <code>true</code> if successful, otherwise, <code>false</code>
	 */
	public boolean informCustomerDecision(long customerId, String customerName, String loanFileId, String contractId,
			boolean accepted) {
		boolean isOK = false;
		try {
			log.info("Customer signed contract #'" + contractId + "'");

			final CustomerDecision request = createCustomerSignature(customerId, customerName, loanFileId, contractId);
			if (request != null && loanApproval != null) {
				request.setAccepted(accepted);
				log.debug("Send the customer's decision: " + request);
				loanApproval.informedByCustomer(request);
				isOK = true;
			}
		} catch (final Exception e) {
			log.error("The customer cannot sign the process: " + e.getMessage());
		}
		return isOK;
	}

	/**
	 * Invokes the service exposed by the loan approval process in order to sign the
	 * loan contract on behalf of the Manager
	 * 
	 * @param staffId
	 *            -- the {@link Customer}'s ID
	 * @param staffName
	 *            -- the {@link Staff}'s name
	 * @param loanFileId
	 *            -- the {@link LoanFile}'s ID
	 * @param contractId
	 *            -- the {@link Contract}'s ID
	 * @return <code>true</code> if successful, otherwise, <code>false</code>
	 */
	public boolean signedContractByManager(String staffId, String staffName, String loanFileId, String contractId) {
		boolean isOK = false;
		try {
			log.info("Manager signed contract #'" + contractId + "'");

			final ManagerSignature request = createManagerSignature(staffId, staffName, loanFileId, contractId);
			if (request != null && loanApproval != null) {
				log.debug("Send the manager's signature: " + request);
				loanApproval.signedByManager(request);
				isOK = true;
			}
		} catch (final Exception e) {
			log.error("The manager cannot sign the process: " + e.getMessage());
		}
		return isOK;
	}

	/**
	 * Create a {@link LoanApprovalRequest} from an {@link ApplicationForm}. If the
	 * customer entered an existing ID, then the task will be dispatched to {@link }
	 * 
	 * @param customerId
	 *            -- the customer ID
	 * @param form
	 *            -- the new {@link ApplicationForm}
	 * @return a {@link LoanApprovalRequest}
	 */
	protected LoanApprovalRequest createLoanRequest(ApplicationForm form) {
		LoanApprovalRequest request = null;
		if (form != null) {
			try {
				long borrowerCustomerId = Long.valueOf(form.getBorrowerCustomerId());
				if (dataAccessObject != null) {
					Customer borrower = dataAccessObject.getCustomerById(borrowerCustomerId);
					if (borrower != null) {
						log.info("Customer exists!");
						request = createLoanRequestByExistingCustomer(borrower);
					} else {
						log.info("Cannot get the existing customer.");
					}
				} else {
					log.error("Cannot get the autowired data access bean");
				}
			} catch (NumberFormatException e) {
				log.info("Cannot extract customer ID! Create a new request");
				request = createLoanRequestByForm(form);
			}
		}
		if (request != null) {
			request.setCoBorrower(form.isHasCoborrower());
			// co-borrower
			if (form.isHasCoborrower()) {
				try {
					long coborrowerCustomerId = Long.valueOf(form.getCoborrowerCustomerId());
					request.setCoBorrowerCustomerId(coborrowerCustomerId);
				} catch (NumberFormatException e) {
					request.setCoBorrowerTitle(form.getCoborrowerTitle());
					request.setCoBorrowerFirstName(form.getCoborrowerFirstName());
					request.setCoBorrowerLastName(form.getCoborrowerLastName());
					request.setCoBorrowerDateOfBirth(DateUtil.convert(form.getCoborrowerDateOfBirth()));
					request.setCoBorrowerOccupation(form.getCoborrowerOccupation());
					request.setCoBorrowerLengthOfService(form.getCoborrowerLengthOfService());
					request.setCoBorrowerIncome(form.getCoborrowerIncome());
					request.setCoBorrowerEmail(form.getCoborrowerEmail());
				}
			}
			// loan information
			request.setLoanAmount(form.getLoanAmount());
			request.setLoanReason(form.getLoanReason());
			request.setLoanTerm(form.getLoanTerm());
			request.setInterestRate(form.getInterestRate());
			request.setResidenceType(form.getResidenceType().name());
			request.setEstateType(form.getEstateType().name());
			request.setEstateLocation(form.getEstateAddress());
			request.setTotalPurchasePrice(form.getTotalPurchasePrice());
			request.setPersonalCapitalContribution(form.getPersonalCapitalContribution());
			request.setSettlementDate(DateUtil.convert(form.getStartDate()));
			request.setAccessSensitiveData(form.isAccessSensitiveData());
		}
		return request;
	}

	/**
	 * Creates and fills customer's information for a {@link LoanApprovalRequest}
	 * from an {@link ApplicationForm}
	 * 
	 * @param form
	 *            -- the new {@link ApplicationForm}
	 * @return a {@link LoanApprovalRequest}
	 */
	protected LoanApprovalRequest createLoanRequestByForm(ApplicationForm form) {
		final LoanApprovalRequest request = new LoanApprovalRequest();

		request.setBorrowerTitle(form.getBorrowerTitle());
		request.setBorrowerFirstName(form.getBorrowerFirstName());
		request.setBorrowerLastName(form.getBorrowerLastName());

		request.setBorrowerDateOfBirth(DateUtil.convert(form.getBorrowerDateOfBirth()));

		request.setBorrowerPhone(form.getBorrowerPhone());
		request.setBorrowerMobilePhone(form.getBorrowerMobilePhone());

		request.setBorrowerEmail(form.getBorrowerEmail());

		// address
		final AddressType borrowerAddress = new AddressType();
		borrowerAddress.setStreet(form.getBorrowerStreet());
		borrowerAddress.setZipcode(form.getBorrowerZipcode());
		borrowerAddress.setCity(form.getBorrowerCity());
		borrowerAddress.setState(form.getBorrowerState());
		borrowerAddress.setCountry(form.getBorrowerCountry());
		request.setBorrowerAddress(borrowerAddress);

		request.setBorrowerOccupation(form.getBorrowerOccupation());
		request.setBorrowerLengthOfService(form.getBorrowerLengthOfService());
		request.setBorrowerIncome(form.getBorrowerIncome());

		request.setBorrowerMaritalStatus(form.getBorrowerMaritalStatus().name());
		request.setBorrowerNumberOfChildren(form.getBorrowerNumberOfChildren());
		request.setAccessSensitiveData(form.isAccessSensitiveData());
		return request;
	}

	/**
	 * Creates and fills customer's information for a {@link LoanApprovalRequest}
	 * from an existing {@link Customer}
	 * 
	 * @param customer
	 *            -- the new {@link Customer}
	 * @return a {@link LoanApprovalRequest}
	 */
	protected LoanApprovalRequest createLoanRequestByExistingCustomer(Customer customer) {
		final LoanApprovalRequest request = new LoanApprovalRequest();
		if (customer != null) {
			request.setBorrowerCustomerId(customer.getCustomerId());
			request.setBorrowerTitle(customer.getTitle());
			request.setBorrowerFirstName(customer.getFirstName());
			request.setBorrowerLastName(customer.getLastName());
			request.setBorrowerDateOfBirth(DateUtil.convert(customer.getDateOfBirth()));
			request.setBorrowerPhone(customer.getPhone());
			request.setBorrowerMobilePhone(customer.getMobilePhone());

			request.setBorrowerEmail(customer.getEmail());

			// address
			Address address = customer.getAddress();
			if (address != null) {
				final AddressType borrowerAddress = new AddressType();
				borrowerAddress.setStreet(address.getStreet());
				borrowerAddress.setZipcode(address.getZipcode());
				borrowerAddress.setCity(address.getCity());
				borrowerAddress.setState(address.getState());
				borrowerAddress.setCountry(address.getCountry());
				request.setBorrowerAddress(borrowerAddress);
			}
			request.setBorrowerOccupation(customer.getOccupation());
			request.setBorrowerLengthOfService(customer.getLengthOfService());
			request.setBorrowerIncome(customer.getIncome());

			if (customer.getMaritalStatus() != null)
				request.setBorrowerMaritalStatus(customer.getMaritalStatus().name());
			request.setBorrowerNumberOfChildren(customer.getNumberOfChildren());

		}
		return request;
	}

	/**
	 * Creates a customer's signature
	 * 
	 * @param customerId
	 *            -- the customer's ID
	 * @param customerName
	 *            -- the customer's full name
	 * @param contractId
	 *            -- the contract ID
	 * @return a {@link CustomerSignature}
	 */
	protected CustomerDecision createCustomerSignature(long customerId, String customerName, String loanFileId,
			String contractId) {
		final CustomerDecision signature = new CustomerDecision();
		signature.setCustomerId(customerId);
		signature.setContractId(contractId);
		signature.setLoanFileId(loanFileId);
		signature.setToken(createToken(customerName));
		return signature;
	}

	/**
	 * Creates a manager's signature
	 * 
	 * @param staffId
	 *            -- the manager's ID
	 * @param staffName
	 *            -- the manager's full name
	 * @param loanFileId
	 *            -- the loanFile ID
	 * @param contractId
	 *            -- the contract ID
	 * @return a {@link ManagerSignature}
	 */
	protected ManagerSignature createManagerSignature(String staffId, String staffName, String loanFileId,
			String contractId) {
		final ManagerSignature signature = new ManagerSignature();
		signature.setStaffId(staffId);
		signature.setContractId(contractId);
		signature.setLoanFileId(loanFileId);
		signature.setToken(createToken(staffName));
		return signature;
	}

	/**
	 * Creates a secure token
	 * 
	 * @param principal
	 *            -- the principal's name
	 * @return a {@link TokenType}
	 */
	protected TokenType createToken(String principal) {
		final TokenType token = new TokenType();
		token.setSerialNumber(UUID.randomUUID().toString());
		token.setX509SubjectName(principal);
		final byte[] signatureTokenX509Certificate = UUID.randomUUID().toString().getBytes();
		token.setX509Certificate(signatureTokenX509Certificate);
		token.setX509IssuerSerial(UUID.randomUUID().toString());
		token.setValidityFrom(DateUtil.convert(new GregorianCalendar()));
		token.setValidityUntil(DateUtil.convert(new GregorianCalendar()));
		return token;
	}

	public void setLoanApproval(LoanApproval loanApproval) {
		this.loanApproval = loanApproval;
	}

}
