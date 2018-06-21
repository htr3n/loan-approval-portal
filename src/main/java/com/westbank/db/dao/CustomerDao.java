package com.westbank.db.dao;

import com.westbank.db.entity.Customer;
import com.westbank.mvc.customer.model.ApplicationForm;

import java.util.List;

public interface CustomerDao {
    Customer updateCustomerProfile(long customerId, ApplicationForm form);

    Customer authenticateCustomer(String email, String pin);

    void deleteCustomer(Customer customer);

    void deleteCustomer(long customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerById(long customerId);

    void save(Customer customer);
}
