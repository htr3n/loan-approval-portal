package westbank.mvc;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.DispatcherServlet;

import westbank.db.entity.Agency;
import westbank.db.entity.Contract;
import westbank.db.entity.Customer;
import westbank.db.entity.LoanFile;
import westbank.db.entity.Role;
import westbank.db.entity.Staff;

public class PortalDispatcherServlet extends DispatcherServlet {

	static final Logger log = LoggerFactory.getLogger(PortalDispatcherServlet.class);

	private static final long serialVersionUID = -2019150462501488511L;
	
	public PortalDispatcherServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		checkDataSchema();
	}

	protected void checkDataSchema() {
		final ApplicationContext ctx = getWebApplicationContext();
		final SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		if (ctx != null && sessionFactory != null) {

			if (!isDatabaseValid(sessionFactory)) {
				log.info("The data schema might not exist or be corrupted.");
				createDatabase(ctx);
				initializeTestingData(sessionFactory);
				log.info("Finished database initializing.");
			} else {
				log.info("Tables exist and are valid. Ready to launch ... ");
			}
		} else {
			log.error("Cannot retrieve the Web application context");
		}
	}

	protected boolean isDatabaseValid(SessionFactory sessionFactory) {
		try {
			log.info("Please wait while the database schema is validated...");
			final HibernateTemplate template = new HibernateTemplate(sessionFactory);
			template.loadAll(Customer.class);
			template.loadAll(LoanFile.class);
			template.loadAll(Contract.class);
			template.loadAll(Staff.class);
			return true;
		} catch (DataAccessException e) {
		}
		return false;
	}

	protected void createDatabase(ApplicationContext ctx) {
		log.info("No worry. Let's create a new database ...");
		final LocalSessionFactoryBean factoryBean = (LocalSessionFactoryBean) ctx.getBean("&sessionFactory");
		final MetadataSources sources = factoryBean.getMetadataSources();
		final MetadataImplementor metadata = (MetadataImplementor) sources.buildMetadata();
		new SchemaExport().execute(EnumSet.of(TargetType.DATABASE), SchemaExport.Action.CREATE, metadata);
	}

	protected void initializeTestingData(SessionFactory sessionFactory) {
		final HibernateTemplate template = new HibernateTemplate(sessionFactory);

		final Role manager = new Role(Role.MANAGER);
		final Role supervisor = new Role(Role.SUPERVISOR);
		final Role broker = new Role(Role.CREDIT_BROKER);
		final Role clerk = new Role(Role.POST_PROCESSING_CLERK);

		final List<Role> r1 = new ArrayList<Role>();
		r1.add(manager);
		final List<Role> r2 = new ArrayList<Role>();
		r2.add(supervisor);
		final List<Role> r3 = new ArrayList<Role>();
		r3.add(clerk);
		final List<Role> r4 = new ArrayList<Role>();
		r4.add(broker);

		final String password = "abc123";

		final Staff staff1 = new Staff("gerald", "Gerald", "Manager", password, r1);
		final Staff staff2 = new Staff("james", "James", "Supervisor", password, r2);
		final Staff staff3 = new Staff("david", "David", "Clerk", password, r3);
		final Staff staff4 = new Staff("bryan", "Bryan", "Broker", password, r4);

		Agency agency = new Agency();
		template.save(agency);

		template.save(manager);
		template.save(supervisor);
		template.save(broker);
		template.save(clerk);

		template.save(staff1);
		template.save(staff2);
		template.save(staff3);
		template.save(staff4);
		template.flush();
	}

}
