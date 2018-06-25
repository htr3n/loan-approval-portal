package com.westbank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan({"com.westbank.ws", "com.westbank.proxy"})
@ImportResource("classpath:META-INF/cxf/cxf.xml")
@Import(ServiceBeans.class)
public class WebServiceConfig {

}
