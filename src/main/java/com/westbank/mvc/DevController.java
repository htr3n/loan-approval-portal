package com.westbank.mvc;

import com.westbank.db.service.LoanContractService;
import com.westbank.db.service.CustomerService;
import com.westbank.db.service.LoanFileService;
import com.westbank.db.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DevController {

	static final String DEV_INDEX = "dev/list";

	@Autowired
	protected CustomerService customerService;

	@Autowired
	protected StaffService staffService;

	@Autowired
	protected LoanContractService contractService;

	@Autowired
	protected LoanFileService loanFileService;

	@RequestMapping("/dev.html")
	public String indexHandler(HttpSession session) {
		session.setAttribute("customers", customerService.getAllCustomers());
		session.setAttribute("staff", staffService.getAllStaffs());
		session.setAttribute("loans", loanFileService.getAllLoanFiles());
		session.setAttribute("contracts", contractService.getAllContracts());
		return DEV_INDEX;
	}
}
