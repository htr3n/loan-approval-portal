package com.westbank.web.validator;

import com.westbank.web.form.ApplicationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoanRequestValidator implements Validator {

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.equals(ApplicationForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		final ApplicationForm form = (ApplicationForm) target;

		// Validating loan request
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanReason", "error.required",
				new String[] { "Loan reason" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "residenceType", "error.required",
				new String[] { "Residence type" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estateType", "error.required",
				new String[] { "Estate type" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estateAddress", "error.required",
				new String[] { "Estate address" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalPurchasePrice", "error.required",
				new String[] { "Total purchase price" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalCapitalContribution", "error.required",
				new String[] { "Personal contribution" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanAmount", "error.required",
				new String[] { "Loan amount" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanTerm", "error.required", new String[] { "Loan term" });

		// Validating customer information
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerTitle", "error.required", new String[] { "Title " });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerFirstName", "error.required",
				new String[] { "First name" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerLastName", "error.required",
				new String[] { "Last name" });

		// validating contract address
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerStreet", "error.required",
				new String[] { "Street" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerCity", "error.required", new String[] { "City" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerZipcode", "error.required",
				new String[] { "Zipcode" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerPhone", "error.required", new String[] { "Phone" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerEmail", "error.required", new String[] { "Email" });

		// validating income
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerOccupation", "error.required",
				new String[] { "Occupation" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerIncome", "error.required",
				new String[] { "Income" });

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "borrowerLengthOfService", "error.required",
				new String[] { "Length of service" });

		// validating co-borrower
		if (form.isHasCoborrower()) {

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerTitle", "error.required",
					new String[] { "Title " });
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerFirstName", "error.required",
					new String[] { "First name" });
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerLastName", "error.required",
					new String[] { "Last name" });

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerOccupation", "error.required",
					new String[] { "Occupation" });
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerIncome", "error.required",
					new String[] { "Income" });

		}
	}

}
