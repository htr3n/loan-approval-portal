package com.westbank.dao;

import com.westbank.domain.Customer;
import com.westbank.domain.LoanFile;
import com.westbank.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LoanFileDaoImpl implements LoanFileDao {

    protected static Logger log = LoggerFactory.getLogger(LoanFileDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteLoanFile(LoanFile loanFile) {
        if (loanFile != null) {
            deleteLoanFileById(loanFile.getLoanFileId());
        }
    }

    @Override
    public void deleteLoanFileById(Long loanFileId) {
        LoanFile found = getLoanFileById(loanFileId);

        if (found != null) {
            entityManager.remove(found);
        }
    }

    @Override
    public List<LoanFile> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LoanFile> criteriaQuery = criteriaBuilder.createQuery(LoanFile.class);
        Root<LoanFile> root = criteriaQuery.from(LoanFile.class);
        criteriaQuery.select(root);
        TypedQuery<LoanFile> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<LoanFile> getLoanFileByBorrower(Long borrowerId) {
        List<LoanFile> results = null;
        try {
            final Customer borrower = new Customer();
            borrower.setCustomerId(borrowerId);
            results = new ArrayList<>();
            /* TODO
            results = (List<LoanFile>) hibernateTemplate.find(
                    "from LoanFile lf where lf.borrower = ?", borrower);
            */
        } catch (Exception e) {
            log.error("Cannot retrieve a loan file by borrowerId: " + e.getMessage());
        }
        return results;
    }

    @Override
    public LoanFile getLoanFileById(Long loanFileId) {
        return entityManager.find(LoanFile.class, loanFileId);
    }

    @Override
    public void save(LoanFile loanFile) {
        entityManager.persist(loanFile);
    }

    @Override
    public List<LoanFile> getGrantedLoanFileByCustomer(Long customerId) {
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        List<LoanFile> results = new ArrayList<>();
        /* TODO
        results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                "select lf from LoanFile as lf where "
                        + " lf.customer=:customer " + " and lf.status=:status",
                new String[]{"customer", "status"},
                new Object[]{customer, LoanFileStatus.APPROVED});
        */
        return results;
    }

    @Override
    public List<LoanFile> getLoanFileByRole(String role) {
        List<LoanFile> results = null;
        if (role != null) {

            // Role credit broker only sees initialized loan files
            if (Role.CREDIT_BROKER.equalsIgnoreCase(role)) {
                /* TODO
                results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status",
                        new String[]{"status"},
                        new Object[]{LoanFileStatus.INITIALIZED});
                */
            } else if (Role.POST_PROCESSING_CLERK.equalsIgnoreCase(role)) {

                // Role clerk only sees loan files that have loan amount below
                // the threshold
                /* TODO
                results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status  "
                                + " and lf.loanAmount < :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION,
                                Constants.LOAN_THRESHOLD});
                */
            } else if (Role.SUPERVISOR.equalsIgnoreCase(role)) {

                // Role supervisor can see loan files that have loan amount
                // above the threshold
                /*
                results = (List<LoanFile>) hibernateTemplate.findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status "
                                + " and lf.loanAmount >= :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION,
                                Constants.LOAN_THRESHOLD});
                 */
            } else if (Role.MANAGER.equalsIgnoreCase(role)) {
                results = findAll();
            } else {
                log.info("Unrecognized role '" + role + "'");
            }
        }
        return results;
    }
}