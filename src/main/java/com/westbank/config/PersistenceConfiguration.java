package com.westbank.config;

import com.westbank.repository.BaseRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.westbank.repository", excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BaseRepository.class})})
@PropertySource({"classpath:hibernate.properties", "classpath:hibernate-extra.properties"})
@ComponentScan(basePackages = {"com.westbank.domain", "com.westbank.service"})
@Import(DataBeans.class)
public class PersistenceConfiguration {

    /* Packages to scan */
    private static final String PACKAGE_SERVICE = "com.westbank.db.service";
    private static final String PACKAGE_REPOSITORY = "com.westbank.repository";
    private static final String PACKAGE_DOMAIN = "com.westbank.domain";

    /* JDBC constants */
    private static final String AUTO_COMMIT_ON_CLOSE = "autoCommitOnClose";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_CONNECTION_AUTOCOMMIT = "hibernate.connection.autocommit";

    private static final String JDBC_CONNECTION_URL = "jdbc.connection.url";
    private static final String JDBC_CONNECTION_DRIVER_CLASS = "jdbc.connection.driver_class";
    private static final String JDBC_CONNECTION_USERNAME = "jdbc.connection.username";
    private static final String JDBC_CONNECTION_PASSWORD = "jdbc.connection.password";
    private static final String HIBERNATE_EJB_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";

    @Resource
    private Environment env;

    @Bean(destroyMethod = "close")
    HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(JDBC_CONNECTION_DRIVER_CLASS));
        dataSource.setJdbcUrl(env.getRequiredProperty(JDBC_CONNECTION_URL));
        dataSource.setUsername(env.getProperty(JDBC_CONNECTION_USERNAME));
        dataSource.setPassword(env.getProperty(JDBC_CONNECTION_PASSWORD));
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource);

        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        // JPA must cover all necessary beans
        entityManagerFactory.setPackagesToScan(PACKAGE_DOMAIN, PACKAGE_REPOSITORY, PACKAGE_SERVICE);

        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put(HIBERNATE_HBM2DDL_AUTO, env.getProperty(HIBERNATE_HBM2DDL_AUTO));

        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        jpaProperties.put(HIBERNATE_EJB_NAMING_STRATEGY, env.getProperty(HIBERNATE_EJB_NAMING_STRATEGY));

        jpaProperties.put(HIBERNATE_CONNECTION_AUTOCOMMIT, env.getProperty(HIBERNATE_CONNECTION_AUTOCOMMIT));

        jpaProperties.put(AUTO_COMMIT_ON_CLOSE, env.getProperty(AUTO_COMMIT_ON_CLOSE));

        jpaProperties.put(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));

        jpaProperties.put(HIBERNATE_FORMAT_SQL, env.getProperty(HIBERNATE_FORMAT_SQL));

        entityManagerFactory.setJpaProperties(jpaProperties);

        return entityManagerFactory;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("load-user-and-role.sql"));
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(resourceDatabasePopulator);
        return initializer;
    }

}
