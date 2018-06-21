package com.westbank.db.dao;

import com.westbank.db.entity.Address;
import com.westbank.db.entity.Customer;
import com.westbank.mvc.customer.model.ApplicationForm;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public Customer updateCustomerProfile(long customerId, ApplicationForm form) {
        Customer customer = null;
        try {
            customer = getCustomerById(customerId);
            if (form != null && customer != null) {
                customer.setPersonalId(form.getBorrowerPersonalId());
                customer.setTitle(form.getBorrowerTitle());
                customer.setFirstName(form.getBorrowerFirstName());
                customer.setLastName(form.getBorrowerLastName());
                customer.setDateOfBirth(form.getBorrowerDateOfBirth());

                customer.setMaritalStatus(form.getBorrowerMaritalStatus());
                customer
                        .setNumberOfChildren(form.getBorrowerNumberOfChildren());

                customer.setPhone(form.getBorrowerPhone());
                customer.setMobilePhone(form.getBorrowerMobilePhone());

                Address a = new Address();
                a.setStreet(form.getBorrowerStreet());
                a.setCity(form.getBorrowerCity());
                a.setState(form.getBorrowerState());
                a.setZipcode(form.getBorrowerZipcode());
                a.setCountry(form.getBorrowerCountry());
                customer.setAddress(a);

                customer.setEmail(form.getBorrowerEmail());
                customer.setIncome(form.getBorrowerIncome());
                customer.setOccupation(form.getBorrowerOccupation());
                customer.setLengthOfService(form.getBorrowerLengthOfService());

                String newPin = form.getNewPin();
                String newPinAgain = form.getNewPinAgain();
                if (newPin != null && !newPin.isEmpty()
                        && newPin.equals(newPinAgain)) {
                    customer.setPin(newPin);
                }
                save(customer);
                hibernateTemplate.flush();
            }
        } catch (Exception e) {
        }
        return customer;
    }

    /**
     * Authenticates a {@link Customer} based on his email and pin
     *
     * @param email -- the customer's email
     * @param pin   -- the customer's personal identification number (PIN)
     * @return the corresponding {@link Customer} object if successful,
     * otherwise <code>null</code>
     */
    @Override
    public Customer authenticateCustomer(String email, String pin) {
        final List<Customer> users = (List<Customer>) hibernateTemplate
                .findByNamedParam(
                        "select c from Customer as c where c.email=:email and c.pin=:pin",
                        new String[]{"email", "pin"},
                        new Object[]{email, pin});
        if (users.size() == 1) {
            return (Customer) users.get(0);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        if (customer != null) {
            hibernateTemplate.delete(customer);
        }
    }

    @Override
    public void deleteCustomer(long customerId) {
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        deleteCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return hibernateTemplate.loadAll(Customer.class);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        Customer customer = null;
        customer = hibernateTemplate.get(Customer.class,
                customerId);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        if (customer != null) {
            hibernateTemplate.saveOrUpdate(customer);
        }
    }
}