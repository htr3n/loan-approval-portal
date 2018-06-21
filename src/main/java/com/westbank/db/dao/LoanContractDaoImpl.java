package com.westbank.db.dao;

import com.westbank.db.entity.Agency;
import com.westbank.db.entity.Contract;
import com.westbank.db.entity.Customer;
import com.westbank.db.entity.LoanFile;
import com.westbank.db.entity.LoanFileStatus;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class LoanContractDaoImpl implements LoanContractDao {

    protected static Logger log = LoggerFactory.getLogger(LoanContractDaoImpl.class);

    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public Contract createAndStoreNewContract(LoanContractRequest request) {
        Contract contract = null;
        if (request != null) {
            String loanFileId = request.getLoanFileId();
            LoanFile loanFile = null; // TODO getLoanFileById(loanFileId);

            if (loanFile != null) {
                contract = new Contract();
                contract.setLoanFile(loanFile);
                contract.setContractId(UUID.randomUUID().toString());
                contract.setBorrower(loanFile.getBorrower());
                contract.setCoBorrower(loanFile.getCoBorrower());
                contract.setBorrower(loanFile.getBorrower());
                contract.setHasCoBorrower(loanFile.isHasCoBorrower());
                if (loanFile.isHasCoBorrower()) {
                    contract.setCoBorrower(loanFile.getCoBorrower());
                }
                contract.setMonthlyPayment(request.getMonthlyPayment());
                contract.setLoanReason(loanFile.getLoanReason());
                contract.setLoanAmount(loanFile.getLoanAmount());
                contract.setLoanTerm(loanFile.getLoanTerm());
                contract.setInterestRate(loanFile.getInterestRate());
                contract.setSettlementDate(loanFile.getSettlementDate());
                contract.setResidenceType(loanFile.getResidenceType());
                contract.setEstateType(loanFile.getEstateType());
                contract.setEstateLocation(loanFile.getEstateLocation());
                contract.setTotalPurchasePrice(loanFile.getTotalPurchasePrice());
                Agency agency = new Agency();
                if (agency != null) {
                    contract.setAgency(agency);
                }
                loanFile.setStatus(LoanFileStatus.APPROVED);
                loanFile.setContract(contract);
                save(contract);
                // TODO save(loanFile);
                hibernateTemplate.flush();
                log.info("Finished creating and saving a new loan contract");
            }

        } else {
            log.error("Cannot get a LoanFile to create a new contract");
        }
        return contract;
    }

    @Override
    public void deleteContract(Contract contract) {
        hibernateTemplate.delete(contract);
    }

    @Override
    public void deleteLoanContract(String contractId) {
        final Contract loanFile = new Contract();
        loanFile.setContractId(contractId);
        deleteContract(loanFile);
    }

    @Override
    public List<Contract> getAllContracts() {
        return hibernateTemplate.loadAll(Contract.class);
    }

    @Override
    public List<Contract> getContractByBorrower(long borrowerId) {
        final Customer borrower = new Customer();
        borrower.setCustomerId(borrowerId);
        return getContractByBorrower(borrower);
    }

    @Override
    public List<Contract> getContractByBorrower(Customer borrower) {
        List<Contract> results = null;
        if (borrower != null) {
            try {
                results = (List<Contract>) hibernateTemplate.find(
                        "from Contract contract where "
                                + " contract.signedByManager is not null and "
                                + " contract.borrower = ?", borrower);
            } catch (Exception e) {
                log.error("Cannot retrieve a loan contract: " + e.getMessage());
            }
        }
        return results;
    }

    @Override
    public Contract getContractById(String contractId) {
        return hibernateTemplate.get(Contract.class, contractId);
    }

    @Override
    public void save(Contract contract) {
        hibernateTemplate.saveOrUpdate(contract);
    }
}
