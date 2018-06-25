package com.westbank.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	static final String CUSTOMER_INDEX = "customer/index";
	static final String CUSTOMER_LOGIN = "redirect:/login.html";
	static final String CUSTOMER_PORTAL = "redirect:/portal.html";
	static final String CUSTOMER_NEWREQUEST = "redirect:/newrequest.html";
	static final String CUSTOMER_PROFILE = "redirect:/profile.html";
	static final String CUSTOMER_REQUEST = "redirect:/request.html";

	@RequestMapping("/index.html")
	public String indexHandler(HttpSession session) {
		Object sessionId = session.getAttribute(Constants.SESSION_CUSTOMER_ID);
		Object nav = session.getAttribute(Constants.SESSION_NAV);
		if (sessionId == null) {
			session.setAttribute(Constants.SESSION_NAV, Constants.NAV_INDEX);
		} else {
			if (Constants.NAV_PORTAL.equals(nav)) {
				return CUSTOMER_PORTAL;
			} else if (Constants.NAV_NEW_REQUEST.equals(nav)) {
				return CUSTOMER_NEWREQUEST;
			} else if (Constants.NAV_PROFILE.equals(nav)) {
				return CUSTOMER_PROFILE;
			}
		}
		return CUSTOMER_INDEX;
	}

	@RequestMapping("/logout.html")
	public String logoutHandler(HttpSession session) {
		session.setAttribute(Constants.SESSION_NAV, Constants.NAV_LOGIN);
		session.removeAttribute(Constants.SESSION_CUSTOMER_ID);
		session.removeAttribute(Constants.SESSION_CUSTOMER_TITLE);
		session.removeAttribute(Constants.SESSION_CUSTOMER_NAME);
		session.removeAttribute(Constants.SESSION_CUSTOMER_EMAIL);
		return CUSTOMER_LOGIN;
	}

}
