package com.westbank.web.controller;

import com.westbank.domain.Customer;
import com.westbank.service.CustomerService;
import com.westbank.web.Constants;
import com.westbank.web.form.LoginForm;
import com.westbank.web.validator.LoginValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login.html")
public class CustomerLoginController {

    private static final String THIS_VIEW = "customer/login";
    private static final String PORTAL_VIEW = "redirect:/portal.html";

    static Logger log = LoggerFactory.getLogger(CustomerLoginController.class);

    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected LoginForm loginForm;
    @Autowired
    protected LoginValidator validator;

    @ModelAttribute("loginForm")
    public LoginForm setupLoginForm() {
        log.info("Initialize login form data");
        if (loginForm == null) {
            loginForm = new LoginForm();
        }
        return loginForm;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String prepare(HttpSession session) {
        session.setAttribute(Constants.SESSION_NAV, Constants.NAV_LOGIN);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
        return THIS_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmission(@ModelAttribute LoginForm form, BindingResult result, HttpSession session) {

        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);

        if (validator != null) {
            validator.validate(form, result);
        } else {
            log.info("Cannot get the autowired customer login validator bean");
            return THIS_VIEW;
        }
        if (result.hasFieldErrors()) {
            log.info("Form validation failed. Stay!");
            return THIS_VIEW;
        } else {
            // authentication
            final Customer customer = customerService.authenticate(form.getEmail(), form.getPin());
            if (customer == null) {
                log.info("Authentication failed. Stay!");
                session.setAttribute(Constants.SESSION_PROCESS_STATUS, Constants.PROCESS_STATUS_ERROR);
                session.setAttribute(Constants.SESSION_PROCESS_STATUS_KEY, Constants.MSG_LOGIN_FAILED);
                return THIS_VIEW;
            } else { // login ok
                log.info("Successful authentication. Forwarded to " + PORTAL_VIEW);
                session.setAttribute(Constants.SESSION_CUSTOMER_ID, customer.getCustomerId());
                session.setAttribute(Constants.SESSION_NAV, Constants.NAV_PORTAL);
                return PORTAL_VIEW;
            }
        }
    }
}
