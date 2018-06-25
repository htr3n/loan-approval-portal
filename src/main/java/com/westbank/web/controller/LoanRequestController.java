package com.westbank.web.controller;

import com.westbank.web.Constants;
import com.westbank.web.form.ApplicationForm;
import com.westbank.proxy.LoanApprovalProcessProxy;
import com.westbank.web.validator.LoanRequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This controller returns the front-end loan request view for the customer
 * (i.e., handles the HTTP GET request), and processes the HTTP POST request
 * which is a new loan approval request from the customer.
 */
@Controller
@RequestMapping("/request.html")
public class LoanRequestController {

    static Logger log = LoggerFactory.getLogger(LoanRequestController.class);

    static final String LOGIN_VIEW = "redirect:/login.html";
    static final String THIS_VIEW = "customer/request";
    static final String REQUEST_INFO = "customer/info";

    @Autowired(required = false)
    protected ApplicationForm applicationForm;

    @Autowired
    protected LoanRequestValidator validator;

    @Autowired
    protected LoanApprovalProcessProxy processProxy;

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }

    @ModelAttribute("applicationForm")
    public ApplicationForm setupApplicationForm() {
        log.info("Initialize application form");
        if (applicationForm != null) {
            return applicationForm;
        } else {
            return new ApplicationForm();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String prepare(HttpSession session) {
        session.setAttribute(Constants.SESSION_NAV, Constants.NAV_REQUEST);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
        session.removeAttribute(Constants.SESSION_CUSTOMER_TITLE);
        session.removeAttribute(Constants.SESSION_CUSTOMER_NAME);
        session.removeAttribute(Constants.SESSION_CUSTOMER_EMAIL);
        return THIS_VIEW;
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(
                false));
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmission(ApplicationForm form, BindingResult result,
                                    HttpSession session) {

        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
        session.removeAttribute(Constants.SESSION_CUSTOMER_TITLE);
        session.removeAttribute(Constants.SESSION_CUSTOMER_NAME);
        session.removeAttribute(Constants.SESSION_CUSTOMER_EMAIL);

        log.info("Process the loan request");
        if (validator != null) {
            validator.validate(form, result);
            if (result.hasFieldErrors()) {
                log.info("Form validation failed. Stay!");
                return THIS_VIEW;
            } else {
                session.setAttribute(Constants.SESSION_NAV,
                        Constants.NAV_REQUEST);
                session.setAttribute(Constants.SESSION_CUSTOMER_TITLE, form
                        .getBorrowerTitle());
                session.setAttribute(Constants.SESSION_CUSTOMER_NAME, form
                        .getBorrowerFirstName()
                        + " " + form.getBorrowerLastName());
                session.setAttribute(Constants.SESSION_CUSTOMER_EMAIL, form
                        .getBorrowerEmail());
                if (processProxy != null) {
                    log.info("Send loan request to the process via the proxy");
                    boolean isOK = processProxy.startProcess(form);
                    if (isOK) {
                        return REQUEST_INFO;
                    } else {
                        session.setAttribute(Constants.SESSION_PROCESS_STATUS,
                                Constants.PROCESS_STATUS_ERROR);
                        session.setAttribute(
                                Constants.SESSION_PROCESS_STATUS_KEY,
                                Constants.MSG_INVOCATION_ERR);
                    }
                }
            }
        } else {
            log.info("Cannot get the autowired validator bean");
            return THIS_VIEW;
        }
        return THIS_VIEW;
    }
}
