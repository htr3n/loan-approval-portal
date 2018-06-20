package com.westbank.mvc.staff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.westbank.mvc.staff.model.StaffLoginForm;

public class StaffLoginValidator implements Validator {

	static Logger log = LoggerFactory.getLogger(StaffLoginValidator.class);

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(StaffLoginForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.info("StaffLogin form is validated ");
		// basic validation
		ValidationUtils.rejectIfEmpty(errors, "id", "error.required",
				new String[] { "Username" });
		ValidationUtils.rejectIfEmpty(errors, "password", "error.required",
				new String[] { "Password" });
		ValidationUtils.rejectIfEmpty(errors, "staffRole", "error.required",
				new String[] { "Staff role" });

	}

}
