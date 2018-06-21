package com.westbank.db.service;

import com.westbank.db.entity.Customer;
import com.westbank.mvc.customer.model.ApplicationForm;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(Long borrowerCustomerId);

    List<Customer> getAllCustomers();

    Customer authenticateCustomer(String email, String pin);

    Customer updateCustomerProfile(Long sessionId, ApplicationForm form);
}
