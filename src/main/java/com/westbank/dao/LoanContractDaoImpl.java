package com.westbank.dao;

import com.westbank.domain.Agency;
import com.westbank.domain.Contract;
import com.westbank.domain.Customer;
import com.westbank.domain.LoanFile;
import com.westbank.domain.LoanFileStatus;
import com.westbank.domain.Staff;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
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
import java.util.Optional;
import java.util.UUID;

public class LoanContractDaoImpl implements LoanContractDao {

    protected static Logger log = LoggerFactory.getLogger(LoanContractDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

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
                // TODO create(loanFile);
                log.info("Finished creating and saving a new loan contract");
            }

        } else {
            log.error("Cannot get a LoanFile to create a new contract");
        }
        return contract;
    }

    @Override
    public void deleteContract(Contract contract) {
        Optional<Contract> optional = this.findContractById(contract.getContractId());
        optional.ifPresent(c -> entityManager.remove(c));
    }

    @Override
    public void deleteLoanContractById(String contractId) {
        final Contract loanFile = new Contract();
        loanFile.setContractId(contractId);
        deleteContract(loanFile);
    }

    @Override
    public List<Contract> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contract> criteriaQuery = criteriaBuilder.createQuery(Contract.class);
        Root<Contract> root = criteriaQuery.from(Contract.class);
        criteriaQuery.select(root);
        TypedQuery<Contract> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findContractByBorrowerId(Integer borrowerId) {
        final Customer borrower = new Customer();
        borrower.setCustomerId(borrowerId);
        return findContractByBorrower(borrower);
    }

    @Override
    public List<Contract> findContractByBorrower(Customer borrower) {
        List<Contract> results = null;
        if (borrower != null) {
            results = new ArrayList<>();
            // TODO
            /*
            Query query = entityManager.createQuery(
                    "from Contract contract where "
                            + " contract.signedByManager is not null and "
                            + " contract.borrower = ?");
            */
        }
        return results;
    }

    @Override
    public Optional<Contract> findContractById(String contractId) {
        return Optional.ofNullable(entityManager.find(Contract.class, contractId));
    }

    @Override
    public void save(Contract contract) {
        entityManager.persist(contract);
    }
}
