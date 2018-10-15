package com.westbank.config;

import com.westbank.domain.EstateType;
import com.westbank.domain.MaritalStatus;
import com.westbank.domain.ResidenceType;
import com.westbank.web.form.ApplicationForm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Configuration
public class ExampleApplicationForm {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Bean(name = "applicationForm")
    ApplicationForm applicationForm(){
        ApplicationForm form = new ApplicationForm();
        form.setLoanAmount(100000);
        form.setLoanReason("Home Mortgage");
        form.setLoanTerm(8);
        form.setTotalPurchasePrice(120000);
        form.setPersonalCapitalContribution(20000);
        form.setInterestRate(0.04);
        form.setResidenceType(ResidenceType.MAIN_HOUSE);
        form.setEstateType(EstateType.HOUSE);
        form.setEstateAddress("123 Green Ave, Mount Waverley, VIC 3149");
        try {
            form.setStartDate(DATE_FORMAT.parse("2011-01-01"));
        } catch (ParseException ignored) {
        }

        form.setBorrowerTitle("Miss");
        form.setBorrowerFirstName("Alice");
        form.setBorrowerLastName("Power");
        form.setBorrowerCity("Melbourne");
        form.setBorrowerState("Victoria");
        form.setBorrowerCountry("Australia");
        form.setBorrowerEmail("power@abc.com");
        form.setBorrowerMaritalStatus(MaritalStatus.MARRIED);
        form.setBorrowerIncome(80000);
        form.setBorrowerLengthOfService(6);
        form.setBorrowerPhone("0431234567");
        form.setBorrowerMobilePhone("0431234567");
        form.setBorrowerStreet("3 Queen Rd");
        form.setBorrowerZipcode("3031");
        form.setBorrowerOccupation("Accountant");
        try {
            form.setBorrowerDateOfBirth(DATE_FORMAT.parse("1988-01-01"));
        } catch (ParseException ignored) {
        }

        form.setHasCoborrower(true);
        form.setCoborrowerTitle("Mr");
        form.setCoborrowerFirstName("Lewis");
        form.setCoborrowerLastName("Schneider");
        form.setCoborrowerIncome(100000);
        form.setCoborrowerLengthOfService(8);
        try {
            form.setCoborrowerOccupation("Project Manager");
            form.setCoborrowerDateOfBirth(DATE_FORMAT.parse("1982-01-01"));
        } catch (ParseException ignored) {
        }
        form.setCoborrowerEmail("schneider@free.org");
        return form;
    }

}
