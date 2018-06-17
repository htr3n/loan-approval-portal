package westbank.mvc.staff.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import westbank.db.dao.DataAccess;
import westbank.db.entity.Contract;
import westbank.db.entity.LoanFile;
import westbank.db.entity.LoanFileStatus;
import westbank.db.entity.Role;
import westbank.db.entity.Staff;
import westbank.mvc.Constants;
import westbank.mvc.customer.controller.SessionValidator;
import westbank.mvc.customer.model.TaskForm;
import westbank.proxy.LoanApprovalProcessProxy;

public class StaffUtil {

	static Logger log = LoggerFactory.getLogger(StaffUtil.class);

	static final String STAFFLOGIN_VIEW = "redirect:/staff/login.html";
	static final String ACTION_ACCEPT = "accept";
	static final String ACTION_GRANT = "grant";
	static final String ACTION_REJECT = "reject";
	static final String ACTION_SIGN = "sign";
	static final String ACTION_LOGOUT = "logout";
	static final String ACTION_RELOAD = "reload";

	/**
	 * Prepares data for the front-end of a particular staff's portal
	 * 
	 * @param session
	 *            -- the {@link HttpSession}
	 * @param dataAccessObject
	 *            -- the {@link DataAccess}
	 * @param thisView
	 *            -- the current (default) view of the corresponding staff's
	 *            portal
	 * @return the login view if session information is invalid, otherwise, the
	 *         portal view of the staff
	 */
	public static String prepare(HttpSession session,
			final DataAccess dataAccessObject, final String thisView) {
		session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
		session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
		final String currentStaffId = (String) SessionValidator
				.validateSession(session, Constants.SESSION_STAFF_ID);
		final String currentStaffRole = (String) SessionValidator
				.validateSession(session, Constants.SESSION_STAFF_ROLE);
		if (currentStaffId != null && currentStaffRole != null) {
			log.info("Staff ID and role are valid. Return the front-end view");
			final Staff staff = dataAccessObject.getStaffById(currentStaffId);
			final List<LoanFile> loanFiles = dataAccessObject.getAllLoanFiles();
			final List<Contract> contracts = dataAccessObject.getAllContracts();
			session.setAttribute(Constants.SESSION_LOANS, loanFiles);
			session.setAttribute(Constants.SESSION_STAFF, staff);
			session.setAttribute(Constants.SESSION_CONTRACTS, contracts);
			session.setAttribute(Constants.SESSION_ROLE, currentStaffRole);
			return thisView;
		} else {
			log.info("SessionID is invalid. Staff must log in first");
			return STAFFLOGIN_VIEW;
		}
	}

	/**
	 * Processes the POST request sending from the front-end staff portal:
	 * converts data, invokes the Loan Approval process via the proxy, probably
	 * updates the corresponding loan file in the databases
	 * 
	 * @param form
	 *            -- the input {@link TaskForm}
	 * @param result
	 *            -- the {@link BindingResult}
	 * @param session
	 *            -- the {@link HttpSession}
	 * @param processProxy
	 *            -- the {@link LoanApprovalProcessProxy}
	 * @param dataAccessObject
	 *            -- the {@link DataAccess}
	 * @param thisView
	 *            -- the current (default) view of the corresponding staff's
	 * @return the staff login view if session information is invalid,
	 *         otherwise, the portal view of the staff
	 */
	public static String process(final TaskForm form,
			final BindingResult result, HttpSession session,
			final LoanApprovalProcessProxy processProxy,
			final DataAccess dataAccessObject, final String thisView) {

		Date actionTime = new Date();

		session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
		session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);

		final String currentStaffId = (String) SessionValidator
				.validateSession(session, Constants.SESSION_STAFF_ID);
		final String currentStaffRole = (String) SessionValidator
				.validateSession(session, Constants.SESSION_STAFF_ROLE);
		if (currentStaffId == null || currentStaffId.isEmpty()
				|| currentStaffRole == null || currentStaffRole.isEmpty()) {
			log
					.info("Either staff ID and role is invalid. Staff must log in first");
			return STAFFLOGIN_VIEW;
		}
		final String action = form.getAction();
		log.info("Processing action='" + action + "' with staffId='"
				+ currentStaffId + "', role='" + currentStaffRole + "'");
		if (ACTION_LOGOUT.equals(action)) {
			session.removeAttribute(Constants.SESSION_STAFF_ID);
			session.removeAttribute(Constants.SESSION_STAFF_ROLE);
			return STAFFLOGIN_VIEW;

		} else if (ACTION_RELOAD.equals(action)) {

			reload(currentStaffId, currentStaffRole, dataAccessObject, session);

		} else {

			String loanFileId = form.getLoanFileId();
			LoanFile loanFile = null;
			Staff currentStaff = null;
			String staffName = null;

			if (dataAccessObject != null) {
				loanFile = dataAccessObject.getLoanFileById(loanFileId);
				currentStaff = dataAccessObject.getStaffById(currentStaffId);
				if (currentStaff != null) {
					staffName = currentStaff.getFirstName() + " "
							+ currentStaff.getLastName();
				}
			}
			// the current role is MANAGER
			if (Role.MANAGER.equals(currentStaffRole)) {
				if (processProxy != null) {
					if (ACTION_SIGN.equals(action)) {
						log.info("Send manager's signature to the process");
						String contractId = form.getContractId();
						boolean isOK = processProxy.signedContractByManager(
								currentStaffId, staffName, loanFileId, 
								contractId);
						if (!isOK) {
							session.setAttribute(
									Constants.SESSION_PROCESS_STATUS,
									Constants.PROCESS_STATUS_ERROR);
							session.setAttribute(
									Constants.SESSION_PROCESS_STATUS_KEY,
									Constants.MSG_INVOCATION_ERR);
						} else {
							if (dataAccessObject != null) {
								log
										.info("The contract is signed. Update the contract's status.");
								Contract contract = dataAccessObject
										.getContractById(contractId);
								if (contract != null) {
									contract.setSignedByManager(actionTime);
									dataAccessObject.save(contract);
									dataAccessObject.getHibernateTemplate()
											.flush();
									contract = null;
								} else {
									log
											.error("Cannot update the status of the contract '"
													+ contractId + "'");
								}
							}
						}

					} else {
						boolean isGranted = false;
						log.info("Send manager's decision on high-risk loan");
						log.info("High-risk loan is granted?" + isGranted);
						boolean isOK = processProxy.informManagerDecision(
								currentStaffId, currentStaffRole, loanFileId,
								isGranted);
						if (!isOK) {
							session.setAttribute(
									Constants.SESSION_PROCESS_STATUS,
									Constants.PROCESS_STATUS_ERROR);
							session.setAttribute(
									Constants.SESSION_PROCESS_STATUS_KEY,
									Constants.MSG_INVOCATION_ERR);
						} else {
							// the invocation is successful, update the loan
							// file status
							if (ACTION_GRANT.equals(action)) {
								isGranted = true;
								loanFile.setStatus(LoanFileStatus.APPROVED);
							} else if (ACTION_REJECT.equals(action)) {
								isGranted = false;
								loanFile.setStatus(LoanFileStatus.REJECTED);
							}
							if (dataAccessObject != null) {
								loanFile.setUpdatedDate(actionTime);
								loanFile.setUpdatedBy(currentStaff);
								loanFile.setUpdatedByRole(currentStaffRole);
								dataAccessObject.save(loanFile);
								dataAccessObject.getHibernateTemplate().flush();
								loanFile = null;
							}
						}
					}
				} else {
					log.error("The proxy is invalid: " + processProxy);
				}

			} else {
				// the current role is either BROKER or SUPERVISOR/CLERK
				if (ACTION_ACCEPT.equals(action)) {
					if (processProxy != null) {
						try {
							log.info("Invoke the process via the proxy");
							boolean isOK = processProxy.processedByStaff(
									currentStaffId, currentStaffRole,
									loanFileId);
							if (!isOK) {
								session.setAttribute(
										Constants.SESSION_PROCESS_STATUS,
										Constants.PROCESS_STATUS_ERROR);
								session.setAttribute(
										Constants.SESSION_PROCESS_STATUS_KEY,
										Constants.MSG_INVOCATION_ERR);
							} else {
								try {
									// the invocation is successful, update the
									// loan file status
									if (loanFile != null) {
										if (Role.CREDIT_BROKER
												.equals(currentStaffRole)) {
											loanFile
													.setStatus(LoanFileStatus.UNDER_CONSIDERATION);
										} else if (Role.POST_PROCESSING_CLERK
												.equals(currentStaffRole)
												|| Role.SUPERVISOR
														.equals(currentStaffRole)) {
											loanFile
													.setStatus(LoanFileStatus.WORTHINESS_ANALYSIS);
										}
										loanFile.setUpdatedDate(actionTime);
										loanFile.setUpdatedBy(currentStaff);
										loanFile
												.setUpdatedByRole(currentStaffRole);
										dataAccessObject.save(loanFile);
										dataAccessObject.getHibernateTemplate()
												.flush();
										loanFile = null;
									}
								} catch (Exception e) {
									log.error("Cannot update LoanFile status: "
											+ e.getMessage());
								}
							}
						} catch (Exception e) {
							log.error("Cannot access credit portal: "
									+ e.getMessage());
						}
					} else {
						log.error("The proxy is invalid: " + processProxy);
					}
				}
			}
		}
		reload(currentStaffId, currentStaffRole, dataAccessObject, session);
		return thisView;
	}

	protected static void reload(String staffId, String currentStaffRole,
			final DataAccess dataAccessObject, HttpSession session) {

		final Staff staff = dataAccessObject.getStaffById(staffId);

		final List<LoanFile> loans = dataAccessObject.getAllLoanFiles();

		final List<Contract> contracts = dataAccessObject.getAllContracts();

		session.setAttribute(Constants.SESSION_LOANS, loans);
		session.setAttribute(Constants.SESSION_STAFF, staff);
		session.setAttribute(Constants.SESSION_CONTRACTS, contracts);

	}
}
