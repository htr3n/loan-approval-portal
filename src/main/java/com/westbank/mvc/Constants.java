package com.westbank.mvc;

public interface Constants {

	public final double LOAN_THRESHOLD = 1000000.0;
	
	public final String SESSION_CUSTOMER_ID = "theSesssionId";

	public final String SESSION_STAFF_ID = "theStaffSesssionId";
	public final String SESSION_STAFF_ROLE = "theStaffSesssionRole";

	/* Session identifier */
	public final String SESSION_PROCESS_STATUS = "processStatus";
	public final String SESSION_LOANS = "loans";
	public final String SESSION_CONTRACTS = "contracts";
	public final String SESSION_CUSTOMER = "customer";
	public final String SESSION_CUSTOMER_TITLE = "customerTitle";
	public final String SESSION_CUSTOMER_NAME = "customerName";
	public final String SESSION_CUSTOMER_EMAIL = "customerEmail";
	public final String SESSION_NAV = "nav";

	public final String SESSION_STAFF = "staff";
	public final String SESSION_ROLE = "role";

	/* Values for the SESSION_PROCESS_STATUS */
	public final String PROCESS_STATUS_OK = "OK";
	public final String PROCESS_STATUS_ERROR = "ERROR";

	/* Session key for the status key */
	public final String SESSION_PROCESS_STATUS_KEY = "processStatusKey";

	/* Message keys */
	static final String MSG_SIGNUP_IDENTITY_EXIST = "signup.identity.already.used";
	static final String MSG_REQUEST_IDENTITY_EXIST = "request.identity.already.used";
	static final String MSG_REQUEST_OK = "request.ok";
	static final String MSG_LOGIN_FAILED = "login.authentication.failed";
	static final String MSG_SIGNUP_OK = "signup.ok";

	static final String MSG_STAFF_LOGIN_FAILED = "staff.login.authentication.failed";

	public final String MSG_PROFILE_UPDATE_OK = "profile.update.ok";

	public final String MSG_DAO_ERR = "dao.error";

	public final Object MSG_INVOCATION_ERR = "invocation.error";
	
	/* Navigation values */
	public final String NAV_INDEX = "0";
	public final String NAV_SIGNUP = "1";
	public final String NAV_REQUEST = "2";
	public final String NAV_LOGIN = "3";
	public final String NAV_PORTAL = "4";
	public final String NAV_PROFILE = "5";
	public final String NAV_NEW_REQUEST = "6";

	public final String STAFF_ROLE_MANAGER = "Manager";
	public final String STAFF_ROLE_SUPERVISOR = "Supervisor";
	public final String STAFF_ROLE_CLERK = "Clerk";
	public final String STAFF_ROLE_BROKER = "Loan Broker";


}
