package com.westbank.db.service;

import com.westbank.db.dao.CustomerDao;
import com.westbank.db.entity.Customer;
import com.westbank.mvc.customer.model.ApplicationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    protected static Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Customer getCustomerById(Long borrowerCustomerId) {
        return customerDao.getCustomerById(borrowerCustomerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer authenticateCustomer(String email, String pin) {
        return customerDao.authenticateCustomer(email, pin);
    }

    @Override
    @Transactional
    public Customer updateCustomerProfile(Long sessionId, ApplicationForm form) {
        return customerDao.updateCustomerProfile(sessionId, form);
    }
}
