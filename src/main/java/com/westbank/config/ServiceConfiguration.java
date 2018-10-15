package com.westbank.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.BusExtensionPostProcessor;
import org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:endpoint.properties"})
@Import({ServiceBeans.class, ServiceClientBeans.class})
public class ServiceConfiguration {

    @Bean(name = Bus.DEFAULT_BUS_ID, destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    /*
    @Bean(name = "org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor")
    BusWiringBeanFactoryPostProcessor busWiringBeanFactoryPostProcessor() {
        return new BusWiringBeanFactoryPostProcessor();
    }

    @Bean(name = "org.apache.cxf.bus.spring.BusExtensionPostProcessor")
    BusExtensionPostProcessor busExtensionPostProcessor() {
        return new BusExtensionPostProcessor();
    }
    */

}
