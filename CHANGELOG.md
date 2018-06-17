# Change Log

2018-06-01

* Java 1.6 --> 1.8
* Migrate log4j to slf4j & logback
* Upgrade Apache Derby 10.5.3.0_1 --> 10.14.2.0 and switch to in-memory instead of using server mode
  * `hibernate.connection.url = jdbc:derby://localhost:1527/testdb;create=true;user=test;password=test` --> `hibernate.connection.url = jdbc:derby:memory:testdb;create=true;user=test;password=test`
  * `org.apache.derby.jdbc.ClientDriver` --> `org.apache.derby.jdbc.EmbeddedDriver`
  * `org.hibernate.dialect.DerbyDialect` --> `org.hibernate.dialect.DerbyTenSevenDialect`

2018-06-14

* Apache CXF 2.2.5 --> 3.2.4
* Upgrade to Java Servlet 3.0 (namespaces in `web.xml`)
* jstl:jstl 1.0 --> javax.servlet:jstl 1.2

* wsdl4j 1.6.2 --> 1.6.3
* javax.servlet:servlet-api 2.5 --> javax.servlet:javax.servlet-api 3.0.1
* javax.xml.bind:jaxb-api 2.1 --> 2.2.2 (the latest 2.3.0 compiled with Java 9, incompatible with Tomcat 7)
* com.sun.xml.bind:jaxb-impl 2.1.12 --> org.glassfish.jaxb:jaxb-runtime 2.3.0.1
* org.apache.neethi:neethi 2.0.4 --> 3.1.1
* org.codehaus.woodstox:woodstox-core-asl 4.0.6 --> 4.4.1
* org.apache.xbean:xbean-spring 3.6 --> 4.8
* Use Java 8 java.util.Base64 to encode and eliminate the use of `commons-codec`

2018-06-15

* Change/upgrade Jetty Maven plugin 6.1.22 to the most recent Eclipse's version 9.x
* Hibernate 3 --> 5 alongside with Spring Framework 3 --> 5
* Migrate `HibernateDaoSupport` 