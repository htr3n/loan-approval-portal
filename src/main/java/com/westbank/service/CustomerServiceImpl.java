package com.westbank.service;

import com.westbank.dao.CustomerDao;
import com.westbank.domain.Customer;
import com.westbank.web.form.ApplicationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    protected static Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerById(Long borrowerCustomerId) {
        return customerDao.getCustomerById(borrowerCustomerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    @Transactional
    public Customer authenticate(String email, String pin) {
        return customerDao.authenticateCustomer(email, pin);
    }

    @Override
    @Transactional
    public Customer updateProfile(Long sessionId, ApplicationForm form) {
        return customerDao.updateCustomerProfile(sessionId, form);
    }
}
