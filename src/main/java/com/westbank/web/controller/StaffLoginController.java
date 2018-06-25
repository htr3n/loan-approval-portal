package com.westbank.web.controller;

import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import com.westbank.service.StaffService;
import com.westbank.web.Constants;
import com.westbank.web.form.StaffLoginForm;
import com.westbank.web.validator.StaffLoginValidator;
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
@RequestMapping("/staff/login.html")
public class StaffLoginController {

    static Logger log = LoggerFactory.getLogger(StaffLoginController.class);

    static final String THIS_VIEW = "staff/stafflogin";

    static final String BROKER_VIEW = "redirect:/staff/broker.html";

    static final String SUPERVISOR_CLERK_VIEW = "redirect:/staff/clerk.html";

    static final String MANAGER_VIEW = "redirect:/staff/manager.html";

    static final String ACTION_CHANGED = "changed";

    @Autowired
    protected StaffLoginForm staffLoginForm;

    @Autowired
    protected StaffLoginValidator validator;

    @Autowired
    protected StaffService staffService;


    @ModelAttribute("staffLoginForm")
    public StaffLoginForm setupStaffLoginForm() {
        if (staffLoginForm != null) {
            return staffLoginForm;
        } else {
            return new StaffLoginForm();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String prepare(@ModelAttribute StaffLoginForm form,
                          HttpSession session) {
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
        session.removeAttribute(Constants.SESSION_STAFF_ID);
        if (form != null) {
            final String staffId = form.getId();
            final Staff staff = staffService.getStaffById(staffId);
            session.setAttribute("roles", staff.getRole());
            session.setAttribute("staffs", staffService.findAll());
        }
        return THIS_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmission(@ModelAttribute StaffLoginForm form, BindingResult result, HttpSession session) {

        if (ACTION_CHANGED.equalsIgnoreCase(form.getAction())) {
            final String staffId = form.getId();
            log.info("Change staff to: " + staffId);
            final Staff staff = staffService.getStaffById(staffId);
            if (staff != null) {
                session.setAttribute("roles", staff.getRole());
            } else {
                session.setAttribute("staffs", staffService.findAll());
                session.setAttribute("roles", staffService.findAllRoles());
            }
        } else {
            if (validator != null) {
                validator.validate(form, result);
                if (result.hasFieldErrors()) {
                    log.info("Form validation failed. Stay!");
                } else { /* now, authenticate */
                    final String inputRole = form.getStaffRole();
                    final Staff staff = staffService.authenticateStaff(form.getId(), form.getPassword());
                    boolean isLogged = false;
                    if (staff != null && inputRole != null
                            && !inputRole.isEmpty()) {
                        for (final Role role : staff.getRole()) {
                            if (inputRole.equalsIgnoreCase(role
                                    .getRoleName())) {
                                isLogged = true;
                                break;
                            }
                        }
                    }
                    if (!isLogged) {
                        log.info("Failed authentication. Stay!");
                        session.setAttribute(
                                Constants.SESSION_PROCESS_STATUS,
                                Constants.PROCESS_STATUS_ERROR);
                        session.setAttribute(
                                Constants.SESSION_PROCESS_STATUS_KEY,
                                Constants.MSG_STAFF_LOGIN_FAILED);
                    } else {
                        log.info("Successful authentication. Forwarded");
                        session.setAttribute(Constants.SESSION_STAFF_ID,
                                staff.getStaffId());
                        session.setAttribute(Constants.SESSION_STAFF_ROLE,
                                inputRole);
                        if (Role.CREDIT_BROKER.equalsIgnoreCase(inputRole)) {
                            return BROKER_VIEW;
                        } else if (Role.POST_PROCESSING_CLERK
                                .equalsIgnoreCase(inputRole)
                                || Role.SUPERVISOR
                                .equalsIgnoreCase(inputRole)) {
                            return SUPERVISOR_CLERK_VIEW;
                        } else if (Role.MANAGER.equalsIgnoreCase(inputRole)) {
                            return MANAGER_VIEW;
                        } else {
                            log.error("Role '" + inputRole
                                    + "' has not been supported yet.");
                        }
                    }
                }
            } else {
                log.error("Cannot get the autowired staff login validator");
            }
        }
        return THIS_VIEW;
    }
}
