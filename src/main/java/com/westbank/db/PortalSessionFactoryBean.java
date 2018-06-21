package com.westbank.db;

import com.westbank.db.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class PortalSessionFactoryBean extends LocalSessionFactoryBean {

	private static final Logger log = LoggerFactory.getLogger(PortalSessionFactoryBean.class);

	@Override
	protected SessionFactory buildSessionFactory(LocalSessionFactoryBuilder sfb) {
		SessionFactory sessionFactory = super.buildSessionFactory(sfb);
		checkAndCreateSchema(sessionFactory);
		initializeTestingData(sessionFactory);
		return sessionFactory;
	}

	void checkAndCreateSchema(SessionFactory sessionFactory) {
		if (!isSchemaValid(sessionFactory)) {
			log.info("The data schema might be corrupted or not exist.");
			createSchema();
		} else {
			log.info("Tables exist and are valid. Ready to launch ... ");
		}
	}

	boolean isSchemaValid(SessionFactory sessionFactory) {
		try {
			log.info("Please wait while the database schema is validated...");
			final HibernateTemplate template = new HibernateTemplate(sessionFactory);
			template.loadAll(Customer.class);
			template.loadAll(LoanFile.class);
			template.loadAll(Contract.class);
			template.loadAll(Staff.class);
			return true;
		} catch (DataAccessException ignored) {
		}
		return false;
	}

	void createSchema() {
		log.info("No worry. Let's create a new database ...");
		final MetadataSources sources = getMetadataSources();
		final MetadataImplementor metadata = (MetadataImplementor) sources.buildMetadata();
		new SchemaExport().execute(EnumSet.of(TargetType.DATABASE), SchemaExport.Action.CREATE, metadata);
		log.info("Finished database initialising.");
	}

	void initializeTestingData(SessionFactory sessionFactory) {
		log.info("Inserting some data for testing/developing purpose");

		final HibernateTemplate template = new HibernateTemplate(sessionFactory);
		// See: https://stackoverflow.com/a/16109441/339302
		template.setCheckWriteOperations(false);

		final Role manager = new Role(Role.MANAGER);
		final Role supervisor = new Role(Role.SUPERVISOR);
		final Role broker = new Role(Role.CREDIT_BROKER);
		final Role clerk = new Role(Role.POST_PROCESSING_CLERK);

		final List<Role> r1 = new ArrayList<>();
		r1.add(manager);
		final List<Role> r2 = new ArrayList<>();
		r2.add(supervisor);
		final List<Role> r3 = new ArrayList<>();
		r3.add(clerk);
		final List<Role> r4 = new ArrayList<>();
		r4.add(broker);

		final String password = "abc123";

		final Staff staff1 = new Staff("gerald", "Gerald", "Manager", password, r1);
		final Staff staff2 = new Staff("james", "James", "Supervisor", password, r2);
		final Staff staff3 = new Staff("david", "David", "Clerk", password, r3);
		final Staff staff4 = new Staff("bryan", "Bryan", "Broker", password, r4);

		Agency agency = new Agency();

		// start saving data to the database
		final Session session = sessionFactory.openSession();
		try {
			final Transaction transaction = session.beginTransaction();
			template.save(agency);
			template.save(manager);
			template.save(supervisor);
			template.save(broker);
			template.save(clerk);
			template.save(staff1);
			template.save(staff2);
			template.save(staff3);
			template.save(staff4);
			transaction.commit();
		} finally {
			session.close();
		}
	}

}
