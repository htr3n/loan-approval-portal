package com.westbank.web.controller;

import com.westbank.domain.Contract;
import com.westbank.domain.Customer;
import com.westbank.domain.LoanFile;
import com.westbank.domain.LoanFileStatus;
import com.westbank.proxy.LoanApprovalProcessProxy;
import com.westbank.service.CustomerService;
import com.westbank.service.LoanContractService;
import com.westbank.service.LoanFileService;
import com.westbank.web.Constants;
import com.westbank.web.form.TaskForm;
import com.westbank.web.validator.SessionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/portal.html")
public class PortalController {

    static final String CUSTOMER_LOGIN_VIEW = "redirect:/login.html";
    static final String CUSTOMER_PORTAL_VIEW = "customer/portal";

    static final String ACTION_SIGN = "sign";
    static final String ACTION_CANCEL = "cancel";
    static final String ACTION_RELOAD = "reload";
    static final String ACTION_GRANT = "grant";
    static final String ACTION_DENY = "deny";

    static Logger log = LoggerFactory.getLogger(PortalController.class);

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected LoanFileService loanFileService;

    @Autowired
    protected LoanApprovalProcessProxy processProxy;

    @Autowired
    private LoanContractService loanContractService;

    @ModelAttribute("loanList")
    public TaskForm setupTaskForm() {
        final TaskForm list = new TaskForm();
        return list;
    }

    @RequestMapping(method = RequestMethod.GET)
    protected String prepare(HttpSession session) {
        final Object sessionId = SessionValidator.validateSession(session, Constants.SESSION_CUSTOMER_ID);
        if (sessionId != null) {
            try {
                loadData(sessionId, session);
                session.setAttribute(Constants.SESSION_NAV, Constants.NAV_PORTAL);
                session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
                session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
                log.info("SessionID is valid. Return the portal view");
            } catch (NumberFormatException e) {
                log.info("Cannot convert customer ID. Abort");
                return CUSTOMER_LOGIN_VIEW;
            }
            return CUSTOMER_PORTAL_VIEW;
        } else {
            log.info("SessionID is invalid. Customer must log in first");
            return CUSTOMER_LOGIN_VIEW;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String processLoanList(@ModelAttribute TaskForm form, HttpSession session) {

        Date actionTime = new Date();

        session.setAttribute(Constants.SESSION_NAV, Constants.NAV_PORTAL);

        final Object customerId = SessionValidator.validateSession(session, Constants.SESSION_CUSTOMER_ID);

        final String action = form.getAction();

        log.info("Processing portal action='" + action + "' with customerId='" + customerId + "'");

        if (customerId != null) {

            if (ACTION_RELOAD.equalsIgnoreCase(action)) {

                loadData((Integer) customerId, session);

            } else {

                boolean isGiveAccess = false;
                boolean isAccessible = false;
                if (ACTION_GRANT.equalsIgnoreCase(action)) {
                    isGiveAccess = true;
                    isAccessible = true;
                } else if (ACTION_DENY.equalsIgnoreCase(action)) {
                    isGiveAccess = true;
                    isAccessible = false;
                }

                if (isGiveAccess) {
                    final Long loanFileId = form.getLoanFileId();
                    LoanFile loanFile = loanFileService.getLoanFileById(loanFileId);
                    if (loanFile != null) {
                        loanFile.setAccessSensitiveData(isAccessible);
                        loanFileService.save(loanFile);
                        log.info("Has customer given access to the bank? " + isAccessible);
                    }
                } else {
                    boolean isAccepted = ACTION_SIGN.equalsIgnoreCase(action);

                    Customer customer = customerService.findCustomerById((Long)customerId);
                    final Long loanFileId = form.getLoanFileId();
                    final Long contractId = form.getContractId();
                    Optional<Contract> contract = loanContractService.getContractById(contractId);
                    if (customer != null && processProxy != null) {
                        log.info("Send customer's decision to the process");
                        boolean isOK = processProxy.informCustomerDecision(customer.getCustomerId(),
                                customer.getFirstName() + " " + customer.getLastName(), loanFileId, contractId,
                                isAccepted);
                        if (!isOK) {
                            session.setAttribute(Constants.SESSION_PROCESS_STATUS, Constants.PROCESS_STATUS_ERROR);
                            session.setAttribute(Constants.SESSION_PROCESS_STATUS_KEY, Constants.MSG_INVOCATION_ERR);
                        } else {
                            // update contract status if the customer accepted, ...
                            if (isAccepted) {
                                if (contract.isPresent()) {
                                    log.info("Update the contract's status");
                                    contract.get().setSignedByCustomer(actionTime);
                                    LoanFile loanFile = contract.get().getLoanFile();
                                    if (loanFile != null) {
                                        loanFile.setStatus(LoanFileStatus.ACCEPTED);
                                    }
                                    loanContractService.save(contract.get());
                                    loanFileService.save(loanFile);
                                }
                            } else {
                                // ... otherwise, set the loan file status to CANCELED
                                LoanFile loanFile = loanFileService.getLoanFileById(loanFileId);
                                if (loanFile != null) {
                                    loanFile.setStatus(LoanFileStatus.CANCELED);
                                    loanFileService.save(loanFile);
                                }
                            }
                        }
                    } else {
                        log.error("Cannot get customer info to sign the contract");
                    }
                }
                loadData(customerId, session);
            }
        } else {
            log.info("Session ID is invalid. Customer must log-in first");
            return CUSTOMER_LOGIN_VIEW;
        }
        return CUSTOMER_PORTAL_VIEW;
    }

    protected void loadData(Object sessionId, HttpSession session) {
        try {
            Long customerId = (Long)sessionId;
            final List<Contract> contracts = loanContractService.getContractByBorrower(customerId);
            final List<LoanFile> loans = loanFileService.getLoanFileByBorrower(customerId);
            final Customer customer = customerService.findCustomerById(customerId);
            session.setAttribute(Constants.SESSION_LOANS, loans);
            session.setAttribute(Constants.SESSION_CONTRACTS, contracts);
            session.setAttribute(Constants.SESSION_CUSTOMER, customer);
        } catch (NumberFormatException e) {
            log.info("Cannot convert customer ID. Abort!");
        }
    }
}
