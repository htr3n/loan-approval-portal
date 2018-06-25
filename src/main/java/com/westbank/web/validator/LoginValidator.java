package com.westbank.web.validator;

import com.westbank.web.form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

	static Logger log = LoggerFactory.getLogger(LoginValidator.class);

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(LoginForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.info("Login form is validated ");

		// final LoginForm form = (LoginForm) target;
		// basic validation
		ValidationUtils.rejectIfEmpty(errors, "email", "error.required", new String[] { "Email" });
		ValidationUtils.rejectIfEmpty(errors, "pin", "error.required", new String[] { "PIN" });
	}

}
