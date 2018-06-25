package com.westbank.web;

import com.westbank.service.LoanContractService;
import com.westbank.service.CustomerService;
import com.westbank.service.LoanFileService;
import com.westbank.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DevController {

	static final String DEV_INDEX = "dev/index";

	@Autowired
	protected CustomerService customerService;

	@Autowired
	protected StaffService staffService;

	@Autowired
	protected LoanContractService contractService;

	@Autowired
	protected LoanFileService loanFileService;

	@GetMapping("/dev.html")
	public String indexHandler(HttpSession session) {
		session.setAttribute("customers", customerService.findAll());
		session.setAttribute("staff", staffService.findAll());
		session.setAttribute("roles", staffService.findAllRoles());
		session.setAttribute("loans", loanFileService.getAllLoanFiles());
		session.setAttribute("contracts", contractService.getAllContracts());
		return DEV_INDEX;
	}
}
