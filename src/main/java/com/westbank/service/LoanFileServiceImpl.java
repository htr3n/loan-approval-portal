package com.westbank.service;

import com.westbank.helper.DbHelper;
import com.westbank.dao.CustomerDao;
import com.westbank.dao.LoanFileDao;
import com.westbank.dao.StaffDao;
import com.westbank.domain.Customer;
import com.westbank.domain.EstateType;
import com.westbank.domain.Address;
import com.westbank.domain.LoanFile;
import com.westbank.domain.LoanFileStatus;
import com.westbank.domain.ResidenceType;
import com.westbank.domain.Staff;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class LoanFileServiceImpl implements LoanFileService {

    protected static Logger log = LoggerFactory.getLogger(LoanFileServiceImpl.class);

    private CustomerDao customerDao;
    private StaffDao staffDao;
    private LoanFileDao loanFileDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Autowired
    public void setLoanFileDao(LoanFileDao loanFileDao) {
        this.loanFileDao = loanFileDao;
    }


    /**
     * Processes a {@link LoanFileRequest}, extracts borrower's, co-borrower's,
     * and loan information, creates a new {@link LoanFile}, creates new
     * {@link Customer}s if necessary (otherwise, retrieves existing
     * {@link Customer}s), then, stored them in the databases
     *
     * @param request -- the input {@link LoanFileRequest}
     * @return a {@link LoanFileResponse} object
     */
    @Override
    @Transactional
    public LoanFileResponse saveLoanRequest(LoanFileRequest request) {
        Customer borrower = null;
        Customer coborrower = null;
        LoanFile loanFile = null;

        LoanFileResponse response = new LoanFileResponse();
        if (request != null) {

            try {
                borrower = customerDao.getCustomerById(request.getBorrowerCustomerId());
                if (borrower != null)
                    log.info("Borrower exists");
            } catch (Exception e) {
            }
            if (borrower == null) {
                log.info("Create a new borrower");
                borrower = new Customer();
                borrower.setPersonalId(request.getBorrowerPersonalId());
                borrower.setTitle(request.getBorrowerTitle());
                borrower.setFirstName(request.getBorrowerFirstName());
                borrower.setLastName(request.getBorrowerLastName());
                if (request.getBorrowerDateOfBirth() != null)
                    borrower.setDateOfBirth(request.getBorrowerDateOfBirth()
                            .toGregorianCalendar().getTime());

                borrower.setPin(DbHelper.generatePassword(DbHelper.PIN_LENGTH));
                borrower.setPhone(request.getBorrowerPhone());
                borrower.setMobilePhone(request.getBorrowerMobilePhone());

                Address a = new Address();
                a.setCity(request.getBorrowerCity());
                a.setCountry(request.getBorrowerCountry());
                a.setState(request.getBorrowerState());
                a.setStreet(request.getBorrowerStreet());
                a.setZipcode(request.getBorrowerZipcode());

                borrower.setAddress(a);

                borrower.setEmail(request.getBorrowerEmail());
                borrower.setIncome(request.getBorrowerIncome());
                borrower.setOccupation(request.getBorrowerOccupation());
                borrower.setLengthOfService(request.getBorrowerLengthOfService());
            }
            // is there a co-borrower?
            boolean hasCoborrower = false;
            hasCoborrower = request.isCoBorrower();
            if (hasCoborrower) {

                coborrower = customerDao.getCustomerById(request.getCoBorrowerCustomerId());
                if (coborrower != null)
                    log.info("Co-borrower exists");
                if (coborrower == null) {
                    log.info("Create a new co-borrower's profile");
                    coborrower = new Customer();
                    coborrower.setPersonalId(request.getCoBorrowerPersonalId());
                    coborrower.setTitle(request.getCoBorrowerTitle());
                    coborrower.setFirstName(request.getCoBorrowerFirstName());
                    coborrower.setLastName(request.getCoBorrowerLastName());
                    if (request.getCoBorrowerDateOfBirth() != null)
                        coborrower.setDateOfBirth(request
                                .getCoBorrowerDateOfBirth()
                                .toGregorianCalendar().getTime());
                    coborrower.setPin(DbHelper
                            .generatePassword(DbHelper.PIN_LENGTH));
                    try {
                        coborrower.setIncome(request.getCoBorrowerIncome());
                    } catch (Exception e) {
                    }
                    coborrower.setOccupation(request.getCoBorrowerOccupation());
                    try {
                        coborrower.setLengthOfService(request
                                .getCoBorrowerLengthOfService());
                    } catch (Exception e) {
                    }

                    coborrower.setEmail(request.getCoBorrowerEmail());
                }
            }
            log.info("Create a new loan file");
            loanFile = new LoanFile();
            if (loanFile != null) {
                loanFile.setLoanFileId(request.getLoanFileId());
                loanFile.setBorrower(borrower);
                loanFile.setHasCoBorrower(hasCoborrower);
                if (hasCoborrower && coborrower != null) {
                    loanFile.setCoBorrower(coborrower);
                }
                loanFile.setLoanAmount(request.getLoanAmount());
                loanFile.setLoanReason(request.getLoanReason());
                loanFile.setLoanTerm(request.getLoanTerm());
                loanFile.setInterestRate(request.getInterestRate());
                try {
                    loanFile.setResidenceType(ResidenceType.valueOf(request
                            .getResidenceType()));
                } catch (IllegalArgumentException ex) {
                    log.error("The resident type is not of a valid enum");
                } catch (NullPointerException ex) {
                }
                try {
                    loanFile.setEstateType(EstateType.valueOf(request
                            .getEstateType()));
                } catch (IllegalArgumentException ex) {
                    log.error("The estate type is not of a valid enum");
                } catch (NullPointerException ex) {
                }
                loanFile.setEstateLocation(request.getEstateLocation());
                if (request.getSettlementDate() != null)
                    loanFile.setSettlementDate(request.getSettlementDate()
                            .toGregorianCalendar().getTime());
                loanFile.setTotalPurchasePrice(request
                        .getTotalPurchasePrice());
                loanFile.setPersonalCapitalContribution(request
                        .getPersonalCapitalContribution());
                loanFile.setCreatedDate(new Date());
                Staff createdStaff = staffDao.getStaffById(request.getStaffId());
                if (createdStaff != null) {
                    loanFile.setCreatedBy(createdStaff);
                } else {
                    log.info("Cannot retrieve a valid staff");
                }

                loanFile.setAccessSensitiveData(request.isAccessSensitiveData());
                log.info("Access Sensitive Data Authorized? : " + request.isAccessSensitiveData());
                loanFile.setStatus(LoanFileStatus.INITIALIZED);
                log.info("Save (co)-borrower's info and the new loan file");
                try {
                    customerDao.save(borrower);
                    if (coborrower != null)
                        customerDao.save(coborrower);
                    loanFileDao.save(loanFile);
                    // TODO getHibernateTemplate().flush();

                    response.setLoanFileId(loanFile.getLoanFileId());
                    if (borrower.getCustomerId() != null) {
                        response.setBorrowerId(borrower.getCustomerId());
                    }
                    if (coborrower != null
                            && coborrower.getCustomerId() != null) {
                        response
                                .setCoborrowerId(coborrower.getCustomerId());
                    }
                } catch (final Throwable e) {
                    log.error("Cannot save data: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                log.error("Cannot create a new loan file object");
            }
        }
        return response;
    }


    @Override
    @Transactional
    public void updateLoanFile(CallbackLoanApprovalRequest request) {
        final Long loanFileId = request.getLoanFileId();
        final String description = request.getDescription();
        LoanFileStatus status = null;
        try {
            status = Enum.valueOf(LoanFileStatus.class, request.getStatus());
        } finally {
            status = LoanFileStatus.INITIALIZED;
        }
        LoanFile loanFile = loanFileDao.getLoanFileById(loanFileId);

        if (loanFile != null) {
            log.info("Update the description of loan file");
            loanFile.setStatus(status);
            loanFile.setDescription(description);
            loanFileDao.save(loanFile);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkCreditWorthiness(CreditWorthinessRequest request) {
        final LoanFile loanFile = loanFileDao.getLoanFileById(request.getLoanFileId());
        return (loanFile != null && "Alice".equalsIgnoreCase(loanFile.getBorrower().getFirstName()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanFile> getAllLoanFiles() {
        return loanFileDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LoanFile getLoanFileById(Long loanFileId) {
        return loanFileDao.getLoanFileById(loanFileId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanFile> getLoanFileByBorrower(Long customerId) {
        return loanFileDao.getLoanFileByBorrower(customerId);
    }

    @Override
    @Transactional
    public void save(LoanFile loanFile) {
        loanFileDao.save(loanFile);
    }

}
