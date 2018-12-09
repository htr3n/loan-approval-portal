package com.westbank.dao;

import com.westbank.domain.Customer;
import com.westbank.web.form.ApplicationForm;

import java.util.List;

public interface CustomerDao {

    Customer updateCustomerProfile(Long customerId, ApplicationForm form);

    Customer authenticateCustomer(String email, String pin);

    void deleteCustomer(Customer customer);

    void deleteCustomer(Long customerId);

    List<Customer> findAll();

    Customer getCustomerById(Long customerId);

    void save(Customer customer);
}
