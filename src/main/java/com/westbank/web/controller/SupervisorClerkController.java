package com.westbank.web.controller;

import com.westbank.web.form.TaskForm;
import com.westbank.proxy.LoanApprovalProcessProxy;
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
@RequestMapping("/staff/clerk.html")
public class SupervisorClerkController {

    private static Logger log = LoggerFactory.getLogger(SupervisorClerkController.class);

    private static final String THIS_VIEW = "staff/clerk";

    private LoanApprovalProcessProxy processProxy;

    @Autowired
    public void setProcessProxy(LoanApprovalProcessProxy processProxy) {
        this.processProxy = processProxy;
    }

    @ModelAttribute("loanList")
    public TaskForm setupTaskForm() {
        final TaskForm list = new TaskForm();
        return list;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String prepare(HttpSession session) {
        return new StaffUtil().prepare(session, THIS_VIEW);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String process(TaskForm form, BindingResult result, HttpSession session) {
        return new StaffUtil().process(form, result, session, processProxy, THIS_VIEW);
    }

}
