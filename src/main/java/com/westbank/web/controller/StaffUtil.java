package com.westbank.web.controller;

import com.westbank.domain.Contract;
import com.westbank.domain.LoanFile;
import com.westbank.domain.LoanFileStatus;
import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import com.westbank.proxy.LoanApprovalProcessProxy;
import com.westbank.service.LoanContractService;
import com.westbank.service.LoanFileService;
import com.westbank.service.StaffService;
import com.westbank.web.Constants;
import com.westbank.web.form.TaskForm;
import com.westbank.web.validator.SessionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class StaffUtil {

    private static Logger log = LoggerFactory.getLogger(StaffUtil.class);

    private static final String STAFFLOGIN_VIEW = "redirect:/staff/login.html";
    private static final String ACTION_ACCEPT = "accept";
    private static final String ACTION_GRANT = "grant";
    private static final String ACTION_REJECT = "reject";
    private static final String ACTION_SIGN = "sign";
    private static final String ACTION_LOGOUT = "logout";
    private static final String ACTION_RELOAD = "reload";

    @Autowired
    protected StaffService staffService;
    @Autowired
    protected LoanFileService loanFileService;
    @Autowired
    protected LoanContractService loanContractService;


    public String prepare(HttpSession session, final String thisView) {
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);

        final String currentStaffId = (String) SessionValidator
                .validateSession(session, Constants.SESSION_STAFF_ID);

        final String currentStaffRole = (String) SessionValidator
                .validateSession(session, Constants.SESSION_STAFF_ROLE);

        if (currentStaffId != null && currentStaffRole != null) {

            log.info("Staff ID and role are valid. Return the front-end view");
            final Staff staff = staffService.getStaffById(currentStaffId);
            final List<LoanFile> loanFiles = loanFileService.getAllLoanFiles();
            final List<Contract> contracts = loanContractService.getAllContracts();
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
     * @return the staff login view if session information is invalid,
     * otherwise, the portal view of the staff
     */
    public String process(final TaskForm form,
                          final BindingResult result, HttpSession session,
                          final LoanApprovalProcessProxy processProxy, final String thisView) {

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

            reload(currentStaffId, currentStaffRole, session);

        } else {

            Long loanFileId = form.getLoanFileId();
            LoanFile loanFile = null;
            Staff currentStaff = null;
            String staffName = null;

            loanFile = loanFileService.getLoanFileById(loanFileId);
            currentStaff = staffService.getStaffById(currentStaffId);
            if (currentStaff != null) {
                staffName = currentStaff.getFirstName() + " "
                        + currentStaff.getLastName();
            }
            // the current role is MANAGER
            if (Role.MANAGER.equals(currentStaffRole)) {
                if (processProxy != null) {
                    if (ACTION_SIGN.equals(action)) {
                        log.info("Send manager's signature to the process");
                        Long contractId = form.getContractId();
                        boolean isOK = processProxy.signedContractByManager(
                                currentStaffId, staffName, loanFileId, contractId);
                        if (!isOK) {
                            session.setAttribute(
                                    Constants.SESSION_PROCESS_STATUS,
                                    Constants.PROCESS_STATUS_ERROR);
                            session.setAttribute(
                                    Constants.SESSION_PROCESS_STATUS_KEY,
                                    Constants.MSG_INVOCATION_ERR);
                        } else {
                            log.info("The contract is signed. Update the contract's status.");
                            Optional<Contract> contract = loanContractService.getContractById(contractId);
                            if (contract.isPresent()) {
                                contract.get().setSignedByManager(actionTime);
                                loanContractService.save(contract.get());
                            } else {
                                log.error("Cannot update the status of the contract '" + contractId + "'");
                            }
                        }

                    } else {
                        boolean isGranted = false;
                        log.info("Send manager's decision on high-risk loan");
                        log.info("High-risk loan is granted?" + isGranted);
                        boolean isOK = processProxy.informManagerDecision(currentStaffId, currentStaffRole, loanFileId, isGranted);
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
                            loanFile.setUpdatedDate(actionTime);
                            loanFile.setUpdatedBy(currentStaff);
                            loanFile.setUpdatedByRole(currentStaffRole);
                            loanFileService.save(loanFile);
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
                                        loanFileService.save(loanFile);
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
        reload(currentStaffId, currentStaffRole, session);
        return thisView;
    }

    private void reload(String staffId, String currentStaffRole, HttpSession session) {

        final Staff staff = staffService.getStaffById(staffId);

        final List<LoanFile> loans = loanFileService.getAllLoanFiles();

        final List<Contract> contracts = loanContractService.getAllContracts();

        session.setAttribute(Constants.SESSION_LOANS, loans);
        session.setAttribute(Constants.SESSION_STAFF, staff);
        session.setAttribute(Constants.SESSION_CONTRACTS, contracts);

    }
}
