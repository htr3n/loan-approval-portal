package com.westbank.web.form;

import org.springframework.stereotype.Component;

@Component
public class LoginForm {

	protected String email;
	protected String pin;
	protected String loginError;

	public LoginForm() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
}
