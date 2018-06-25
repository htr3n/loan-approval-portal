package com.westbank.web.form;


import org.springframework.stereotype.Component;

@Component
public class StaffLoginForm {

	protected String id;

	protected String password;

	protected String staffRole;

	protected String action;

	public StaffLoginForm() {
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
