package com.westbank.dao;

import com.westbank.domain.Customer;
import com.westbank.web.form.ApplicationForm;

import java.util.List;

public interface CustomerDao {

    Customer updateCustomerProfile(Integer customerId, ApplicationForm form);

    Customer authenticateCustomer(String email, String pin);

    void deleteCustomer(Customer customer);

    void deleteCustomer(Integer customerId);

    List<Customer> findAll();

    Customer getCustomerById(Integer customerId);

    void save(Customer customer);
}
