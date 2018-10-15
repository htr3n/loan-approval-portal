package com.westbank.web.controller;

import com.westbank.web.form.TaskForm;
import com.westbank.proxy.LoanApprovalProcessProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff/broker.html")
public class CreditBrokerController {

    private static final String THIS_VIEW = "staff/broker";

    private LoanApprovalProcessProxy loanApprovalProcessProxy;

    @Autowired
    public void setLoanApprovalProcessProxy(LoanApprovalProcessProxy loanApprovalProcessProxy) {
        this.loanApprovalProcessProxy = loanApprovalProcessProxy;
    }

    @ModelAttribute("loanList")
    public TaskForm setupTaskForm() {
        return new TaskForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String prepare(HttpSession session) {
        return new StaffUtil().prepare(session, THIS_VIEW);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String process(TaskForm form, BindingResult result, HttpSession session) {
        return new StaffUtil().process(form, result, session, loanApprovalProcessProxy, THIS_VIEW);
    }

}
