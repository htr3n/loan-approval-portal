package com.westbank.db.dao;

import com.westbank.db.entity.Customer;
import com.westbank.db.entity.LoanFile;
import com.westbank.db.entity.LoanFileStatus;
import com.westbank.db.entity.Role;
import com.westbank.mvc.Constants;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LoanFileDaoImpl implements LoanFileDao {

    protected static Logger log = LoggerFactory.getLogger(LoanFileDaoImpl.class);

    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void deleteLoanFile(LoanFile loanFile) {
        hibernateTemplate.delete(loanFile);
    }

    @Override
    public void deleteLoanFile(String loanFileId) {
        if (loanFileId != null) {
            final LoanFile loanFile = new LoanFile();
            loanFile.setLoanFileId(loanFileId);
            deleteLoanFile(loanFile);
        }

    }

    @Override
    public List<LoanFile> getAllLoanFiles() {
        return hibernateTemplate.loadAll(LoanFile.class);
    }

    @Override
    public List<LoanFile> getLoanFileByBorrower(long borrowerId) {
        List<LoanFile> results = null;
        try {
            final Customer borrower = new Customer();
            borrower.setCustomerId(borrowerId);
            results = (List<LoanFile>) hibernateTemplate.find(
                    "from LoanFile lf where lf.borrower = ?", borrower);
        } catch (Exception e) {
            log.error("Cannot retrieve a loan file by borrowerId: " + e.getMessage());
        }
        return results;
    }

    @Override
    public LoanFile getLoanFileById(String loanFileId) {
        LoanFile result = null;
        if (loanFileId != null) {
            result = hibernateTemplate.get(LoanFile.class, loanFileId);
        }
        return result;
    }

    @Override
    public void save(LoanFile loanFile) {
        if (loanFile != null) {
            hibernateTemplate.saveOrUpdate(loanFile);
        }
    }

    @Override
    public List<LoanFile> getGrantedLoanFileByCustomer(long customerId) {
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        List<LoanFile> results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                "select lf from LoanFile as lf where "
                        + " lf.customer=:customer " + " and lf.status=:status",
                new String[]{"customer", "status"},
                new Object[]{customer, LoanFileStatus.APPROVED});
        return results;
    }

    @Override
    public List<LoanFile> getLoanFileByRole(String role) {
        List<LoanFile> results = null;
        if (role != null) {

            // Role credit broker only sees initialized loan files
            if (Role.CREDIT_BROKER.equalsIgnoreCase(role)) {

                results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status",
                        new String[]{"status"},
                        new Object[]{LoanFileStatus.INITIALIZED});

            } else if (Role.POST_PROCESSING_CLERK.equalsIgnoreCase(role)) {

                // Role clerk only sees loan files that have loan amount below
                // the threshold
                results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status  "
                                + " and lf.loanAmount < :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION,
                                Constants.LOAN_THRESHOLD});

            } else if (Role.SUPERVISOR.equalsIgnoreCase(role)) {

                // Role supervisor can see loan files that have loan amount
                // above the threshold
                results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status "
                                + " and lf.loanAmount >= :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION,
                                Constants.LOAN_THRESHOLD});

            } else if (Role.MANAGER.equalsIgnoreCase(role)) {
                results = getAllLoanFiles();
            } else {
                log.info("Unrecognized role '" + role + "'");
            }
        }
        return results;
    }
}