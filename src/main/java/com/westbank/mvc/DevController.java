package com.westbank.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import westbank.db.dao.DataAccess;

@Controller
public class DevController {

	static final String DEV_INDEX = "dev/list";

	@Autowired
	protected DataAccess dao;

	@RequestMapping("/dev.html")
	public String indexHandler(HttpSession session) {
		session.setAttribute("customers", dao.getAllCustomers());
		session.setAttribute("staff", dao.getAllStaffs());
		session.setAttribute("loans", dao.getAllLoanFiles());
		session.setAttribute("contracts", dao.getAllContracts());
		return DEV_INDEX;
	}
}
