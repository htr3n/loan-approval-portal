package com.westbank.web;

public interface Constants {

	double LOAN_THRESHOLD = 1000000.0;
	
	String SESSION_CUSTOMER_ID = "theSessionId";

	String SESSION_STAFF_ID = "theStaffSessionId";
	String SESSION_STAFF_ROLE = "theStaffSessionRole";

	/* Session identifier */
	String SESSION_PROCESS_STATUS = "processStatus";
	String SESSION_LOANS = "loans";
	String SESSION_CONTRACTS = "contracts";
	String SESSION_CUSTOMER = "customer";
	String SESSION_CUSTOMER_TITLE = "customerTitle";
	String SESSION_CUSTOMER_NAME = "customerName";
	String SESSION_CUSTOMER_EMAIL = "customerEmail";
	String SESSION_NAV = "nav";

	String SESSION_STAFF = "staff";
	String SESSION_ROLE = "role";

	/* Values for the SESSION_PROCESS_STATUS */
	String PROCESS_STATUS_OK = "OK";
	String PROCESS_STATUS_ERROR = "ERROR";

	/* Session key for the status key */
	String SESSION_PROCESS_STATUS_KEY = "processStatusKey";

	/* Message keys */
	String MSG_SIGNUP_IDENTITY_EXIST = "signup.identity.already.used";
	String MSG_REQUEST_IDENTITY_EXIST = "request.identity.already.used";
	String MSG_REQUEST_OK = "request.ok";
	String MSG_LOGIN_FAILED = "login.authentication.failed";
	String MSG_SIGNUP_OK = "signup.ok";

	String MSG_STAFF_LOGIN_FAILED = "staff.login.authentication.failed";

	String MSG_PROFILE_UPDATE_OK = "profile.update.ok";

	String MSG_DAO_ERR = "dao.error";

	Object MSG_INVOCATION_ERR = "invocation.error";
	
	/* Navigation values */
	String NAV_INDEX = "0";
	String NAV_SIGNUP = "1";
	String NAV_REQUEST = "2";
	String NAV_LOGIN = "3";
	String NAV_PORTAL = "4";
	String NAV_PROFILE = "5";
	String NAV_NEW_REQUEST = "6";

	String STAFF_ROLE_MANAGER = "Manager";
	String STAFF_ROLE_SUPERVISOR = "Supervisor";
	String STAFF_ROLE_CLERK = "Clerk";
	String STAFF_ROLE_BROKER = "Loan Broker";


}
