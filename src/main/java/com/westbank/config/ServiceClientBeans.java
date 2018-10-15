package com.westbank.config;

import com.westbank.proxy.LoanApprovalProcessProxy;
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
import com.westbank.ws.process.loanapproval._2018._06.LoanApproval;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
public class ServiceClientBeans {

    static final String ENDPOINT_SUFFIX = "?wsdl";
    static final String ENDPOINT_BASE = "service.enpoint.base";

    @Resource
    private Environment env;

    @Autowired
    private Bus cxf;


    @Bean
    LoanApprovalProcessProxy loanApprovalProcessProxy() {
        LoanApprovalProcessProxy proxy = new LoanApprovalProcessProxy();
        return proxy;
    }

    @Bean
    LoanApproval loanApprovalClient() {
        String endpoint = env.getProperty("process.start.endpoint");
        return new ServiceFactory<LoanApproval>().create(LoanApproval.class, endpoint);
    }

    @Bean
    BankInformation bankInformationClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + BankInformation.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<BankInformation>().create(BankInformation.class, endpoint);
    }

    @Bean
    BankPrivilege bankPrivilegeClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + BankPrivilege.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<BankPrivilege>().create(BankPrivilege.class, endpoint);
    }

    @Bean
    CreditWorthiness creditWorthinessClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + CreditWorthiness.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<CreditWorthiness>().create(CreditWorthiness.class, endpoint);
    }

    @Bean
    LoanApprovalClosing loanApprovalClosingClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + LoanApprovalClosing.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<LoanApprovalClosing>().create(LoanApprovalClosing.class, endpoint);
    }

    @Bean
    LoanContract loanContractClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + LoanContract.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<LoanContract>().create(LoanContract.class, endpoint);
    }

    @Bean
    LoanFile loanFileClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + LoanFile.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<LoanFile>().create(LoanFile.class, endpoint);
    }

    @Bean
    LoanRisk loanRiskClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + LoanRisk.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<LoanRisk>().create(LoanRisk.class, endpoint);
    }

    @Bean
    LoanSettlement loanSettlementClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + LoanSettlement.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<LoanSettlement>().create(LoanSettlement.class, endpoint);
    }

    @Bean
    TaskDispatch taskDispatchClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + TaskDispatch.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<TaskDispatch>().create(TaskDispatch.class, endpoint);
    }

    @Bean
    CallbackLoanApproval callbackLoanApprovalClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + CallbackLoanApproval.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<CallbackLoanApproval>().create(CallbackLoanApproval.class, endpoint);
    }

    @Bean
    CallbackLoanContract callbackLoanContractClient() {
        String endpoint = env.getProperty(ENDPOINT_BASE) + CallbackLoanContract.class.getSimpleName() + ENDPOINT_SUFFIX;
        return new ServiceFactory<CallbackLoanContract>().create(CallbackLoanContract.class, endpoint);
    }


    class ServiceFactory<T> {
        public T create(Class clazz, String endpoint) {
            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
            factoryBean.setServiceClass(clazz);
            factoryBean.setAddress(endpoint);
            return (T)factoryBean.create();
        }
    }
}
