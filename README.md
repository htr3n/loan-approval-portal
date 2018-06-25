# Loan Approval Portal

This project provides a Web interface portal for end-users to work with the loan approval process of the fictitious WestBank. Besides, for testing purpose it also includes the Web services and underlying databases that provide necessary business functions used by the loan approval process.

## Technologies

* SOAP/Web Services (WSDL/XML/SOAP/HTTP) implemented using [JAX-WS](https://en.wikipedia.org/wiki/Java_API_for_XML_Web_Services) / [Apache CXF](http://cxf.apache.org) / [Spring Framework](https://spring.io)
* [Spring MVC Framework](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) for user interface running in a Web application server
* [JPA](https://en.wikipedia.org/wiki/Java_Persistence_API) / [Hibernate](http://hibernate.org) on top of an RDBMS with [HikariCP](https://github.com/brettwooldridge/HikariCP) for JDBC connection pooling.
* [H2](http://www.h2database.com/html/main.html), [Apache Derby](https://db.apache.org/derby), [HyperSQL](http://hsqldb.org), [MySQL](https://www.mysql.com), [PostgreSQL](https://www.postgresql.org) have been included and tested but any RDBMS can be also used with extra configuration effort
* [Logback](https://logback.qos.ch) and [Simple Logging Facade for Java (SLF4J)](https://www.slf4j.org) for efficient logging
* [Apache Maven](https://maven.apache.org) for dependency management, building, packaging, and deployment

## Quick Start

##### Executing using command line

The Loan Approval Portal can be deployed as a Web application (`*.war`) and executed with a Web application server such as Apache Tomcat, Eclipse Jetty, JBoss Wildfly AS, etc. Nevertheless, we can directly execute them at the command line for testing purpose. Go to the project folder and proceed with the following command.

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

The main development configuration is defined in `pom.xml` and the main Web application configuration is `WEB-INF/web.xml`.

#### Web Layer

The user interface for the customers of the loan approval process which is implemented with [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html). Data manipulation and persistence are done using [Hibernate](http://hibernate.org).

* The main configuration for the Web application is `WEB-INF/web.xml`. 

* `ContextLoadListener`, that stars the root web application context is used load the Spring managed beans for web services (`cxf.ml`) and data handling (`data-access.xml`).

```xml
<listener>
  <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<context-param>
  <param-name>contextConfigLocation</param-name>
  <param-value>
    /WEB-INF/cxf.xml
    /WEB-INF/data-access.xml
  </param-value>
</context-param>
```

By convention, the default configuration for [DispatcherServlet](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/DispatcherServlet.html) will be `mvc-servlet.xml`. Note that `mvc` is the name of the servlet defined in `web.xml`. For better understanding, I explicitly specified the configuration file though.

```xml
<servlet>
  <servlet-name>mvc</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/mvc-servlet.xml</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>
```

The Spring managed and annotated controllers for customers and staffs are under `com.westbank.web.customer` and `com.westbank.web.staff` respectively. The portal's index page is mapped to `HomeController`.

```xml
<mvc:annotation-driven />

<!-- These statements are required for Spring MVC Annotations -->
<context:component-scan base-package="..." />

<context:annotation-config />
```


All views (JSP/JSTL) are in the folder `src/main/webapp/WEB-INF/jsp/` for customers (`customer/*.jsp`) and staff (`staff/*.jsp`). Other resources like CSSs, images, and JavasSripts are in the folders `src/main/webapp/[css | images | js ]`.

###### Some Relevant Resources

* `src/main/resources/endpoint.properties` -- defining the process and Web service endpoints
* `src/main/resources/messages.properties` for the information displayed to the customers such as success and error notifications.
* `src/main/resources/logback.xml` for Logback

#### Data Access Layer

* Data entities are annotated with JPA conventions (see `com.westbank.db.entities`). 
* The Hibernate configuration is in `WEB-INF/data-access.xml` loaded by`org.springframework.web.context.ContextLoaderListener`.
* The DAO helpers are in the package `db.dao` for manipulating the underlying data/objects using Spring HibernateTemplate such as `CustomerDao`, `ProviderDao`, `LoanDao`, `StaffDao`, `RoleDao`, etc.
* Some required Spring beans will be injected into Spring managed controllers and DAO helpers. Those beans are also defined in `WEB-INF/data-access.xml`.
* As we must validate and initialise the database if necessary, I extend [LocalSessionFactoryBean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/orm/hibernate5/LocalSessionFactoryBean.html) with [PortalSessionFactoryBean](https://github.com/htr3n/loan-approval-portal/blob/master/src/main/java/westbank/db/PortalSessionFactoryBean) for extra tasks on database initialisation.
* The currently used RDBMS is in-memory H2. Nevertheless, any other RDBMS can be used as well. In order to use other RDBMSs instead of Apache Derby, note the following points:
  * Create a database name 'WESTBANKDB'
  * Create a user 'westbank' with password 'secret' and assign that user to the database.
  * Go to file `WEB-INF/data-access.xml`, find the bean named  `propertyPlaceholderConfigurer`, and replace `hibernate.properties` with the corresponding value according to the RDBMS being used. Keep the rest unchanged.
  * Add necessary Maven dependencies for the new DBMS in `pom.xml`.
  * Issue the command `mvn jetty:run` to check if the Web application works. 
  * In case of problems, tune the verbosity in `logback.xml` for debugging.

#### Web Services

This project also implements some Web services using JAX-WS / Apache CXF to provide the business functions needed by the loan approval process. These Web service interfaces (`*.wsdl`) are in the folder `src/main/webapp/WEB-INF/wsdl`. We distinguish 3 main service types

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

###### Java Code Generation from WSDLs

Apache CXF WSDL2Java `cxf-codegen-plugin` is used to generate server and client stuffs for the aforementioned services according to the configuration in the `pom.xml` file. The generated Java sources are under the base package
`westbank.ws`.

>  The _m2eclipse_ plugin that supports Maven in Eclipse will invoke the Apache CXF `cxf-codegen-plugin` whenever you import this project into Eclipse,the existing generated stuffs will be unnecessarily overwritten. Thus, the plugin is currently disabled. Whenever any WSDL is modified, please enable this plugin and execute the command `mvn generate-sources` to re-generate the Java code.

###### Web Services Publishing

The configuration for publishing Web services using Apache CXF and Spring is provided in `WEB-INF/cxf.xml` which is loaded by the root WebApplicationContext.

After the Web application is running, open a Web browser at http://localhost:9999/portal/services to see a list of running Web services.

In order to modify these Web services, have a look into the folder `WEB-INF/wsdl`. After modifying the WSDLs, run `mvn clean generate-sources` to re-generate Java implementations for these Web services.

The real implementation of the business logic of each Web service is in the corresponding Java class named `XXXImpl` in which '_XXX_' is the name of that Web service.

## Sidenotes

* File `WEB-INF/test.xml` is used for testing only. It will inject some predefined data for the customer's input forms. In the final release, it should be disabled by commenting/removing the corresponding import statement in `WEB-INF/mvc-servlet.xml`.

For further testing and demonstration purposes, some special values are hard-coded in the Web services logics:

* If the borrower's last name is "Power", the privilege is ok, i.e., the number of incidents is 0, the number of banks is 0 (see `com.westbank.ws.impl.BankPrivilegeImpl`)
* The monthly payment is calculated according to a provided formula (see `com.westbank.ws.impl.BankInformationImpl`)
* If choosing the EstateType as HOUSE, then the return risk evaluation is HIGH (see `com.westbank.ws.impl.LoanRiskImpl`)
* If the loan amount < 1 million, then the role will be CLERK, otherwise, SUPERVISOR (see `com.westbank.ws.impl.TaskDispatchImpl`)
* If the borrower's first name is "Alice", the CreditWorthinessOK is `true`, otherwise, `false`  (see `com.westbank.ws.impl.CreditWorthinessImpl`)

