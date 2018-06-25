# Loan Approval Portal

This project provides a Web interface portal for end-users to work with the loan approval process of the fictitious WestBank. Besides, for testing purpose it also includes the Web services that provide necessary business functions used by the loan approval process.

## Technologies

* SOAP/Web Services (WSDL/XML/SOAP/HTTP) implemented using [JAX-WS](https://en.wikipedia.org/wiki/Java_API_for_XML_Web_Services) / [Apache CXF](http://cxf.apache.org) on top of [Spring Framework](https://spring.io)
* [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) 
* [JPA](https://en.wikipedia.org/wiki/Java_Persistence_API) / [Hibernate](http://hibernate.org) on top of an RDBMS with [HikariCP](https://github.com/brettwooldridge/HikariCP) for JDBC connection pooling.
* [H2](http://www.h2database.com/html/main.html), [Apache Derby](https://db.apache.org/derby), [HyperSQL](http://hsqldb.org), [MySQL](https://www.mysql.com), [PostgreSQL](https://www.postgresql.org) have been included and tested but any RDBMS can be also used with extra configuration effort
* [Logback](https://logback.qos.ch) and [Simple Logging Facade for Java (SLF4J)](https://www.slf4j.org) for efficient logging
* [Apache Maven](https://maven.apache.org) for dependency management, building, packaging, and deployment

## Quick Start

##### Executing using command line

The portal can be deployed as an application (`*.war`) in a Web application server such as Apache Tomcat, Eclipse Jetty, JBoss Wildfly AS, etc. Nevertheless, we can directly run it at the command line. 

Go to the project folder and proceed with the following command.

```sh
mvn jetty:run
```

Then open a Web browser to http://localhost:9999/portal for the portal main page.

Some other pages for development/testing

   * Verifying the underlying database (see `src/main/java/com.westbank.web.DevController`) : http://localhost:9999/portal/dev.html 

   * Checking the list of running Web services: http://localhost:9999/portal/services

   * To login as a staff (manager, supervisor, clerk, or broker), go to page: http://localhost:9999/portal/staff/login.html

   * Note: ID and password for staff are temporarily listed in page http://localhost:9999/portal/dev.html

##### Packaging a deployable Web application (.war)

```sh
mvn -DskipTests clean package
```

## Technical Details

The main development configuration is a Maven `pom.xml`.

### Web Layer

As switching to XML-less configurations with Servlet 3.0+, the main web application configuration is `com.westbank.config.PortalWebApplicationInitializer` instead of  `WEB-INF/web.xml`. 

* `PortalWebApplicationInitializer` first loads the root context and registers two configurations `PersistenceConfiguration` (for data access) and `ServiceConfiguration` (for publishing Web/SOAP services)
* Then it registers a child context with `AnnotationConfigWebApplicationContext` for the Spring `DispatcherServlet`
	* ``AnnotationConfigWebApplicationContext`` registers the MVC configuration in `WebMvcConfiguration`
	* `DispatcherServlet` will serve all `*.html` and `/portal/*`
* `PortalWebApplicationInitializer` will also load another servlet  [`CXFServlet`](https://cxf.apache.org/javadoc/latest/org/apache/cxf/transport/servlet/CXFServlet.html) to serve the Web/SOAP services at `/services/*`

### MVC Configuration

The configuration for Spring MVC is in `com.westbank.config.WebMvcConfiguration`:

* It implements [`WebMvcConfigurer`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurer.html) and is annotated with [`@EnableWebMvc`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/EnableWebMvc.html) (equivalent to `<mvc:annotation-driven />` in Spring XML)

* It enables default servlet handling

* It adds ResourceHandlers to serve `/resources/`

* It configures view resolvers to serve JSP/JSTL at `/WEB-INF/view/` and for `.jsp`

* It configures [`MessageSource`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html) to serve multiple languages at `i18n/messages-XXX.properties`

###### Some Relevant Resources

* Other resources like CSSs, images, and JavasSripts are in the folders `src/main/webapp/[css | images | js ]`.

* `src/main/resources/i18n/messages.properties` for the information displayed to the customers such as success and error notifications.
* `src/main/resources/logback.xml` for Logback

### Data Access Layer

* Data manipulation and persistence are done using JPA / [Hibernate](http://hibernate.org) configured via `PersistenceConfiguration`.

	* Annotated with `@Configuration` `@EnableJpaRepositories`, `@EnableTransactionManagement`, `@ComponentScan`
	* Defines `javax.sql.DataSource` with the underlyling implementation `HikariDataSource` of [HikariCP](https://github.com/brettwooldridge/HikariCP)
	* Defines `entityManagerFactory` with [`LocalContainerEntityManagerFactoryBean`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/orm/jpa/LocalContainerEntityManagerFactoryBean.html)
	* Defines JPA TransactionManager / Java Transaction API (JTA) with [`JpaTransactionManager`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/orm/jpa/JpaTransactionManager.html)
	* Defines a [`DataSourceInitializer`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/datasource/init/DataSourceInitializer.html) to set up some data using the script `load-user-and-role.sql`

* Domain entities are annotated with JPA conventions in `com.westbank.domain`
* Data repositories are in `com.westbank.repository` for manipulating the underlying data/objects using `EntityManager`
* Data services (including some business logic) are in `com.westbank.service` working on top of the repositories
* The currently used RDBMS is in-memory H2 for minimal memory footprint. Nevertheless, any other RDBMS can be used as well. In order to use other RDBMSs instead, just please note the following points:
	* Create a database name `WESTBANKDB`
	* Create a user `westbank` with password `secret` and assign that user to the database or use your preferred values and update  `hibernate.properties` accordingly
	* Add necessary Maven dependencies for the new RDBMS in `pom.xml`.
	* Issue the command `mvn jetty:run` to check if the Web application works. 
	* In case of problems, tune the verbosity in `logback.xml` for debugging.

### Web Services

This project also includes some Web services using JAX-WS / Apache CXF to provide the business functions needed by the loan approval process. These Web service interfaces (`*.wsdl`) are in the folder `src/main/webapp/WEB-INF/wsdl`. We distinguish 3 main service types

   - __Business services__ -- functions provided by the underlying IT infrastructure.
      ```
      |
      +-- Authentication.wsdl
      +-- BankInformation.wsdl
      +-- BankPrivilege.wsdl
      +-- CreditWorthiness.wsdl
      +-- LoanApprovalClosing.wsdl
      +-- LoanFile.wsdl
      +-- LoanContract.wsdl
      +-- LoanContractSigning.wsdl
      +-- LoanRisk.wsdl
      +-- LoanSettlement.wsdl
      +-- TaskDispatch.wsdl
      ```
   - __Call back services__ -- called back by the loan approval process when it wants to notifies the customers or finishes
  ```
   |
   +-- CallbackLoanContract.wsdl
   +-- CallbackLoanApproval.wsdl
  ```

##### Java Code Generation from WSDLs

Apache CXF WSDL2Java `cxf-codegen-plugin` is used to generate server and client stuffs for the aforementioned services according to the configuration in the `pom.xml` file. The generated Java sources are under the base package
`westbank.ws`.

>  The _m2eclipse_ plugin that supports Maven in Eclipse will invoke the Apache CXF `cxf-codegen-plugin` whenever you import this project into Eclipse,the existing generated stuffs will be unnecessarily overwritten. Thus, the plugin is currently disabled. Whenever any WSDL is modified, please enable this plugin and execute the command `mvn generate-sources` to re-generate the Java code.

##### Web Services Publishing

The configuration for publishing Web services using Apache CXF and Spring is provided in `com.westbank.config.ServiceConfiguration` loaded by the root application context. It in turn loads the service bean definitions in `com.westbank.config.ServiceBeans`.

As the Web application is running, open a Web browser at http://localhost:9999/portal/services to see a list of running Web services.

In order to modify these Web services, have a look into the folder `WEB-INF/wsdl`. After modifying the WSDLs, run `mvn clean generate-sources` to re-generate Java implementations for these Web services.

The actual implementation of the business logic of each Web service is in the corresponding Java class named `com.westbank.ws.impl.XXXImpl` in which '_XXX_' is the name of that Web service.

## Sidenotes

For further testing and demonstration purposes, some special values are hard-coded in the Web services logics:

* If the borrower's last name is "Power", the privilege is ok, i.e., the number of incidents is 0, the number of banks is 0 (see `com.westbank.ws.impl.BankPrivilegeImpl`)
* The monthly payment is calculated according to a provided formula (see `com.westbank.ws.impl.BankInformationImpl`)
* If choosing the EstateType as HOUSE, then the return risk evaluation is HIGH (see `com.westbank.ws.impl.LoanRiskImpl`)
* If the loan amount < 1 million, then the role will be CLERK, otherwise, SUPERVISOR (see `com.westbank.ws.impl.TaskDispatchImpl`)
* If the borrower's first name is "Alice", the CreditWorthinessOK is `true`, otherwise, `false`  (see `com.westbank.ws.impl.CreditWorthinessImpl`)

