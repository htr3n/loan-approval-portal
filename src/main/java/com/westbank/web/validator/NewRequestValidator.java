package com.westbank.web.validator;

import com.westbank.web.form.ApplicationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NewRequestValidator implements Validator {

    @Override
    public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
        return clazz.equals(ApplicationForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        final ApplicationForm form = (ApplicationForm) target;

        // Validating loan request
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanReason", "error.required",
                new String[]{"Loan reason"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "residenceType", "error.required",
                new String[]{"Residence type"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estateType", "error.required",
                new String[]{"Estate type"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estateAddress", "error.required",
                new String[]{"Estate address"});

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalPurchasePrice", "error.required",
                new String[]{"Total purchase price"});

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalCapitalContribution", "error.required",
                new String[]{"Personal contribution"});

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanAmount", "error.required",
                new String[]{"Loan amount"});

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanTerm", "error.required", new String[]{"Loan term"});

        // validating co-borrower
        if (form.isHasCoborrower()) {

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerTitle", "error.required",
                    new String[]{"Title "});
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerFirstName", "error.required",
                    new String[]{"First name"});
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerLastName", "error.required",
                    new String[]{"Last name"});

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerOccupation", "error.required",
                    new String[]{"Occupation"});
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coborrowerIncome", "error.required",
                    new String[]{"Income"});

        }
    }
}
