package com.westbank.mvc.staff.controller;

import com.westbank.mvc.customer.model.TaskForm;
import com.westbank.proxy.LoanApprovalProcessProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * This controller handles the front-end of a Credit Broker. After logged in, a
 * staff with the Credit Broker role will be redirected to this controller. The
 * controller then prepares a list of loan files and sends back to the front
 * -end. When the Credit Broker pushes the button, the controller will activate
 * the Loan Approval process at the task "Access Portal". This way, we can
 * simply simulate the interaction between the Credit Broker and the process
 */
@Controller
@RequestMapping("/staff/broker.html")
public class CreditBrokerController {

    static final String THIS_VIEW = "staff/broker";

    @Autowired
    protected LoanApprovalProcessProxy processProxy;

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
        return new StaffUtil().process(form, result, session, processProxy, THIS_VIEW);
    }

}
