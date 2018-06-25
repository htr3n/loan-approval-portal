package com.westbank.config;

import com.westbank.dao.AgencyDao;
import com.westbank.dao.AgencyDaoImpl;
import com.westbank.dao.CustomerDao;
import com.westbank.dao.CustomerDaoImpl;
import com.westbank.dao.LoanContractDao;
import com.westbank.dao.LoanContractDaoImpl;
import com.westbank.dao.LoanFileDao;
import com.westbank.dao.LoanFileDaoImpl;
import com.westbank.dao.StaffDao;
import com.westbank.dao.StaffDaoImpl;
import com.westbank.service.CustomerService;
import com.westbank.service.CustomerServiceImpl;
import com.westbank.service.LoanContractService;
import com.westbank.service.LoanContractServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBeans {

    @Bean
    public AgencyDao getAgencyDao(){
        return new AgencyDaoImpl();
    }

    @Bean
    public CustomerDao getCustomerDao(){
        return new CustomerDaoImpl();
    }

    @Bean
    public LoanFileDao getLoanFileDao(){
        return new LoanFileDaoImpl();
    }

    @Bean
    public LoanContractDao getLoanContractDao(){
        return new LoanContractDaoImpl();
    }

    @Bean
    public StaffDao getStaffDao(){
        return new StaffDaoImpl();
    }

    /*
    @Bean
    public CustomerService getCustomerService(){
        return new CustomerServiceImpl(getCustomerDao());
    }

    @Bean
    public LoanContractService getLoanContractService(){
        return new LoanContractServiceImpl(getLoanContractDao());
    }
    */

}
