package com.westbank.service;

import com.westbank.domain.Customer;
import com.westbank.web.form.ApplicationForm;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(Long borrowerCustomerId);

    List<Customer> findAll();

    Customer authenticate(String email, String pin);

    Customer updateProfile(Long sessionId, ApplicationForm form);
}
