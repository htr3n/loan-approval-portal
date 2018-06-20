package com.westbank.mvc.staff.controller;

import com.westbank.db.dao.DataAccess;
import com.westbank.mvc.customer.model.TaskForm;
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

/**
 * This controller handles the front-end of a Supervisor/Clerk. After logged in,
 * a staff with the Supervisor/Clerk role will be redirected to this controller.
 * The controller then prepares a list of loan files and sends back to the front
 * -end. When the Supervisor/Clerk pushes the button, the controller will
 * activate the Loan Approval process at the second task "Access Portal". This
 * way, we can simply simulate the interaction between the Supervisor/Clerk and
 * the process
 * 
 */
@Controller
@RequestMapping("/staff/clerk.html")
public class SupervisorClerkController {

	static Logger log = LoggerFactory.getLogger(SupervisorClerkController.class);

	static final String THIS_VIEW = "staff/clerk";

	@Autowired
	protected DataAccess dataAccessObject;
	@Autowired
	protected LoanApprovalProcessProxy processProxy;

	@ModelAttribute("loanList")
	public TaskForm setupTaskForm() {
		final TaskForm list = new TaskForm();
		return list;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String prepare(HttpSession session) {
		return StaffUtil.prepare(session, dataAccessObject, THIS_VIEW);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String process(TaskForm form, BindingResult result,
			HttpSession session) {
		return StaffUtil.process(form, result, session, processProxy,
				dataAccessObject, THIS_VIEW);
	}

}