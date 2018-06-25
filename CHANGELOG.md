# Change Log

2018-06-01

* Java 1.6 --> 1.8
  * Also use Java 8 java.util.Base64 to encode and eliminate the use of `commons-codec`
* Migrate logging to slf4j & logback
* Upgrade Apache Derby 10.5.3.0_1 --> 10.14.2.0 and add options for using in-memory database

2018-06-14

* Apache CXF 2.2.5 --> 3.2.4
* jstl:jstl 1.0 --> javax.servlet:jstl 1.2
* wsdl4j 1.6.2 --> 1.6.3
* javax.servlet:servlet-api 2.5 --> javax.servlet:javax.servlet-api 3.1.0
* javax.xml.bind:jaxb-api 2.1 --> 2.2.11 (the latest 2.3.0 compiled with Java 9, incompatible with Tomcat 7)
* com.sun.xml.bind:jaxb-impl 2.1.12 --> 2.2.11
* org.apache.neethi:neethi 2.0.4 --> 3.1.1

2018-06-15

* Change/upgrade Jetty Maven plugin 6.1.22 to the most recent Eclipse's version 9.x
* Migrate Hibernate 3 --> 5 alongside with Spring Framework 3 --> 5
* Eliminate the use of `HibernateDaoSupport` 

2018-06-16

* Upgrade to Java Servlet 3.0+ (namespaces in `web.xml`)
  * Move to XML free Web application
    * Spring `WebApplicationInitializer`
    * https://stackoverflow.com/a/21714524/339302
 * Switch the database-in-use from [Apache Derby](https://db.apache.org/derby) to [H2](http://www.h2database.com/html/main.html) for less memory footprint

2018-06-21
* Refactore big fat DAOs and creates Service classes
* Switch the database pooling from [c3p0](https://www.mchange.com/projects/c3p0) to [HikariCP](https://github.com/brettwooldridge/HikariCP)

2018-06-22

* Switch to JPA and use EntityManager

2018-06-25

* Switch to XML-less configuration

