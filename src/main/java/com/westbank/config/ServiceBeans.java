package com.westbank.config;

import com.westbank.ws.business.bankinformation._2018._06.BankInformation;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosing;
import com.westbank.ws.business.loancontract._2018._06.LoanContract;
import com.westbank.ws.business.loanfile._2018._06.LoanFile;
import com.westbank.ws.business.loanrisk._2018._06.LoanRisk;
import com.westbank.ws.business.loansettlement._2018._06.LoanSettlement;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatch;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval;
import com.westbank.ws.client.callbackloancontract.CallbackLoanContract;
import com.westbank.ws.impl.BankInformationImpl;
import com.westbank.ws.impl.BankPrivilegeImpl;
import com.westbank.ws.impl.CallbackLoanApprovalImpl;
import com.westbank.ws.impl.CallbackLoanContractImpl;
import com.westbank.ws.impl.CreditWorthinessImpl;
import com.westbank.ws.impl.LoanApprovalClosingImpl;
import com.westbank.ws.impl.LoanApprovalImpl;
import com.westbank.ws.impl.LoanContractImpl;
import com.westbank.ws.impl.LoanFileImpl;
import com.westbank.ws.impl.LoanRiskImpl;
import com.westbank.ws.impl.LoanSettlementImpl;
import com.westbank.ws.impl.TaskDispatchImpl;
import com.westbank.ws.process.loanapproval._2018._06.LoanApproval;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class ServiceBeans {

    @Autowired
    Bus bus;

    @Bean
    Endpoint bankInformation() {
        BankInformation implementor = new BankInformationImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + BankInformation.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint bankPrivilege() {
        BankPrivilege implementor = new BankPrivilegeImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + BankPrivilege.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint callbackLoanApproval() {
        CallbackLoanApproval implementor = new CallbackLoanApprovalImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + CallbackLoanApproval.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint callbackLoanContract() {
        CallbackLoanContract implementor = new CallbackLoanContractImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + CallbackLoanContract.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint creditWorthiness() {
        CreditWorthiness implementor = new CreditWorthinessImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + CreditWorthiness.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint loanApprovalClosing() {
        LoanApprovalClosing implementor = new LoanApprovalClosingImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + LoanApprovalClosing.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint loanContract() {
        LoanContract implementor = new LoanContractImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + LoanContract.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint loanFile() {
        LoanFile implementor = new LoanFileImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + LoanFile.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint loanRisk() {
        LoanRisk implementor = new LoanRiskImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + LoanRisk.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint loanSettlement() {
        LoanSettlement implementor = new LoanSettlementImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + LoanSettlement.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint taskDispatch() {
        TaskDispatch implementor = new TaskDispatchImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + TaskDispatch.class.getSimpleName());
        return endpoint;
    }

    @Bean
    Endpoint loanApproval() {
        LoanApproval implementor = new LoanApprovalImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/" + LoanApproval.class.getSimpleName());
        return endpoint;
    }
}
