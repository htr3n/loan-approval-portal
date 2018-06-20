package com.westbank.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.westbank.db.entity.Address;
import com.westbank.db.entity.Agency;
import com.westbank.db.entity.Contract;
import com.westbank.db.entity.Customer;
import com.westbank.db.entity.EstateType;
import com.westbank.db.entity.LoanFile;
import com.westbank.db.entity.LoanFileStatus;
import com.westbank.db.entity.ResidenceType;
import com.westbank.db.entity.Role;
import com.westbank.db.entity.Staff;
import com.westbank.mvc.Constants;
import com.westbank.mvc.customer.model.ApplicationForm;
import com.westbank.util.DateUtil;
import com.westbank.util.DbUtil;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * A DAO utility class for manipulating {@link Customer}, {@link LoanFile},
 * {@link Contract}, and {@link Agency} databases.
 *
 * @author Huy Tran (htran_at_infosys.tuwien.ac.at)
 * @version 2.0
 * @since 2.0
 */
@SuppressWarnings(value = "unchecked")
public class DataAccess extends HibernateDaoSupport {

    static Logger log = LoggerFactory.getLogger(DataAccess.class);

    public LoanContractResponse createLoanContract(LoanContractRequest request) {
        LoanContractResponse response = null;
        if (request != null) {
            Contract contract = createAndStoreNewContract(request);
            response = createLoanContractResponse(contract);
        }
        return response;
    }

    protected Contract createAndStoreNewContract(LoanContractRequest request) {
        Contract contract = null;
        if (request != null) {
            String loanFileId = request.getLoanFileId();
            LoanFile loanFile = getLoanFileById(loanFileId);

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
                contract
                        .setTotalPurchasePrice(loanFile.getTotalPurchasePrice());
                Agency agency = new Agency();
                if (agency != null) {
                    contract.setAgency(agency);
                }
                loanFile.setStatus(LoanFileStatus.APPROVED);
                loanFile.setContract(contract);
                save(contract);
                save(loanFile);
                getHibernateTemplate().flush();
                log.info("Finished creating and saving a new loan contract");
            }

        } else {
            log.error("Cannot get a LoanFile to create a new contract");
        }
        return contract;
    }

    protected LoanContractResponse createLoanContractResponse(Contract contract) {
        LoanContractResponse response = new LoanContractResponse();
        if (contract != null) {
            response.setLoanContractId(contract.getContractId());
            Customer borrower = contract.getBorrower();
            if (borrower != null) {
                response.setBorrowerCustomerId(borrower.getCustomerId());
                response.setBorrowerTitle(contract.getBorrower().getTitle());
                response.setBorrowerFirstName(contract.getBorrower()
                        .getFirstName());
                response.setBorrowerLastName(contract.getBorrower()
                        .getLastName());
                response.setBorrowerDateOfBirth(DateUtil.convert(contract
                        .getBorrower().getDateOfBirth()));
                final com.westbank.ws.business.loancontract._2018._06.Address responseBorrowerAddress = new com.westbank.ws.business.loancontract._2018._06.Address();

                Address borrowerAddress = borrower.getAddress();
                if (borrowerAddress != null) {
                    responseBorrowerAddress.setStreet(borrowerAddress
                            .getStreet());
                    responseBorrowerAddress.setZipcode(borrowerAddress
                            .getZipcode());
                    responseBorrowerAddress.setCity(borrowerAddress.getCity());
                    responseBorrowerAddress
                            .setState(borrowerAddress.getState());
                    responseBorrowerAddress.setCountry(borrowerAddress
                            .getCountry());
                }
                response.setBorrowerAddress(responseBorrowerAddress);
            }
            response.setCoBorrower(contract.isHasCoBorrower());

            if (contract.isHasCoBorrower()) {
                Customer coborrower = contract.getCoBorrower();
                if (coborrower != null) {
                    response
                            .setCoBorrowerCustomerId(coborrower.getCustomerId());
                    response.setCoBorrowerTitle(coborrower.getTitle());
                    response.setCoBorrowerFirstName(coborrower.getFirstName());
                    response.setCoBorrowerLastName(coborrower.getLastName());
                    response.setCoBorrowerDateOfBirth(DateUtil
                            .convert(coborrower.getDateOfBirth()));
                }
            }
            response.setMonthlyPayment(contract.getMonthlyPayment());

            response.setLoanReason(contract.getLoanReason());
            response.setLoanAmount(contract.getLoanAmount());
            response.setLoanTerm(contract.getLoanTerm());
            response.setInterestRate(contract.getInterestRate());

            response.setSettlementDate(DateUtil.convert(contract
                    .getSettlementDate()));

            response.setResidenceType(contract.getResidenceType().name());
            response.setEstateType(contract.getEstateType().name());
            response.setEstateLocation(contract.getEstateLocation());

            Agency agency = contract.getAgency();
            if (agency != null) {
                response.setAgencyCode(agency.getAgencyCode());
                response.setBankName(agency.getBankName());
                final com.westbank.ws.business.loancontract._2018._06.Address agencyAddress = new com.westbank.ws.business.loancontract._2018._06.Address();
                agencyAddress.setStreet(agency.getStreet());
                agencyAddress.setZipcode(agency.getZipcode());
                agencyAddress.setCity(agency.getCity());
                agencyAddress.setState(agency.getState());
                agencyAddress.setCountry(agency.getCountry());
                response.setAgencyAddress(agencyAddress);
            }
        }
        return response;
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
    public LoanFileResponse saveLoanRequest(LoanFileRequest request) {
        Customer borrower = null;
        Customer coborrower = null;
        LoanFile loanFile = null;

        LoanFileResponse response = new LoanFileResponse();
        if (request != null) {

            try {
                borrower = getCustomerById(request.getBorrowerCustomerId());
                if (borrower != null)
                    log.info("Borrrower exists");
            } catch (Exception e) {
            }
            if (borrower == null) {
                log.info("Create a new borrrower");
                borrower = new Customer();
                borrower.setPersonalId(request.getBorrowerPersonalId());
                borrower.setTitle(request.getBorrowerTitle());
                borrower.setFirstName(request.getBorrowerFirstName());
                borrower.setLastName(request.getBorrowerLastName());
                if (request.getBorrowerDateOfBirth() != null)
                    borrower.setDateOfBirth(request.getBorrowerDateOfBirth()
                            .toGregorianCalendar().getTime());

                borrower.setPin(DbUtil.generatePassword(DbUtil.PIN_LENGTH));
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

                coborrower = getCustomerById(request.getCoBorrowerCustomerId());
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
                    coborrower.setPin(DbUtil
                            .generatePassword(DbUtil.PIN_LENGTH));
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
                Staff createdStaff = getStaffById(request.getStaffId());
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
                    save(borrower);
                    if (coborrower != null)
                        save(coborrower);
                    save(loanFile);
                    getHibernateTemplate().flush();

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

    public Customer updateCustomerProfile(long customerId, ApplicationForm form) {
        Customer customer = null;
        try {
            customer = getCustomerById(customerId);
            if (form != null && customer != null) {
                customer.setPersonalId(form.getBorrowerPersonalId());
                customer.setTitle(form.getBorrowerTitle());
                customer.setFirstName(form.getBorrowerFirstName());
                customer.setLastName(form.getBorrowerLastName());
                customer.setDateOfBirth(form.getBorrowerDateOfBirth());

                customer.setMaritalStatus(form.getBorrowerMaritalStatus());
                customer
                        .setNumberOfChildren(form.getBorrowerNumberOfChildren());

                customer.setPhone(form.getBorrowerPhone());
                customer.setMobilePhone(form.getBorrowerMobilePhone());

                Address a = new Address();
                a.setStreet(form.getBorrowerStreet());
                a.setCity(form.getBorrowerCity());
                a.setState(form.getBorrowerState());
                a.setZipcode(form.getBorrowerZipcode());
                a.setCountry(form.getBorrowerCountry());
                customer.setAddress(a);

                customer.setEmail(form.getBorrowerEmail());
                customer.setIncome(form.getBorrowerIncome());
                customer.setOccupation(form.getBorrowerOccupation());
                customer.setLengthOfService(form.getBorrowerLengthOfService());

                String newPin = form.getNewPin();
                String newPinAgain = form.getNewPinAgain();
                if (newPin != null && !newPin.isEmpty()
                        && newPin.equals(newPinAgain)) {
                    customer.setPin(newPin);
                }
                save(customer);
                getHibernateTemplate().flush();
            }
        } catch (Exception e) {
        }
        return customer;
    }

    /**
     * Authenticates a {@link Customer} based on his email and pin
     *
     * @param email -- the customer's email
     * @param pin   -- the customer's personal identification number (PIN)
     * @return the corresponding {@link Customer} object if successful,
     * otherwise <code>null</code>
     */
    public Customer authenticateCustomer(String email, String pin) {
        final List<Customer> users = (List<Customer>) getHibernateTemplate()
                .findByNamedParam(
                        "select c from Customer as c where c.email=:email and c.pin=:pin",
                        new String[]{"email", "pin"},
                        new Object[]{email, pin});
        if (users.size() == 1) {
            return (Customer) users.get(0);
        }
        return null;
    }

    public void deleteCustomer(Customer customer) {
        if (customer != null) {
            getHibernateTemplate().delete(customer);
        }
    }

    public void deleteCustomer(long customerId) {
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        this.deleteCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return getHibernateTemplate().loadAll(Customer.class);
    }

    public Customer getCustomerById(long customerId) {
        Customer customer = null;
        customer = getHibernateTemplate().get(Customer.class,
                customerId);
        return customer;
    }

    public void save(Customer customer) {
        if (customer != null) {
            getHibernateTemplate().saveOrUpdate(customer);
        }
    }

    public void deleteLoanFile(LoanFile loanFile) {
        if (loanFile != null) {
            getHibernateTemplate().delete(loanFile);
        }
    }

    public void deleteLoanFile(String loanFileId) {
        if (loanFileId != null) {
            final LoanFile loanFile = new LoanFile();
            loanFile.setLoanFileId(loanFileId);
            deleteLoanFile(loanFile);
        }

    }

    public List<LoanFile> getAllLoanFiles() {
        return getHibernateTemplate().loadAll(LoanFile.class);
    }

    public List<LoanFile> getLoanFileByBorrower(long borrowerId) {
        List<LoanFile> results = null;
        try {
            final Customer borrower = new Customer();
            borrower.setCustomerId(borrowerId);
            results = (List<LoanFile>)getHibernateTemplate().find(
                    "from LoanFile lf where lf.borrower = ?", borrower);
        } catch (Exception e) {
            log.error("Cannot retrieve a loan file by borrowerId: "
                    + e.getMessage());
        }
        return results;
    }

    public LoanFile getLoanFileById(String loanFileId) {
        LoanFile result = null;
        if (loanFileId != null) {
            result = getHibernateTemplate().get(LoanFile.class, loanFileId);
        }
        return result;
    }

    public void save(LoanFile loanFile) {
        if (loanFile != null) {
            getHibernateTemplate().saveOrUpdate(loanFile);
        }
    }

    public List<LoanFile> getGrantedLoanFileByCustomer(long customerId) {
        List<LoanFile> results = null;
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
                "select lf from LoanFile as lf where "
                        + " lf.customer=:customer " + " and lf.status=:status",
                new String[]{"customer", "status"},
                new Object[]{customer, LoanFileStatus.APPROVED});
        return results;
    }

    public List<LoanFile> getLoanFileByRole(String role) {
        List<LoanFile> results = null;
        if (role != null) {

            // Role credit broker only sees initialized loan files
            if (Role.CREDIT_BROKER.equalsIgnoreCase(role)) {

                results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status",
                        new String[]{"status"},
                        new Object[]{LoanFileStatus.INITIALIZED});

            } else if (Role.POST_PROCESSING_CLERK.equalsIgnoreCase(role)) {

                // Role clerk only sees loan files that have loan amount below
                // the threshold
                results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
                        "select lf from LoanFile as lf where "
                                + " lf.status=:status  "
                                + " and lf.loanAmount < :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION,
                                Constants.LOAN_THRESHOLD});

            } else if (Role.SUPERVISOR.equalsIgnoreCase(role)) {

                // Role supervisor can see loan files that have loan amount
                // above the threshold
                results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
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

    public void deleteContract(Contract contract) {
        if (contract != null) {
            getHibernateTemplate().delete(contract);
        }
    }

    public void deleteLoanContract(String contractId) {
        if (contractId != null) {
            final Contract loanFile = new Contract();
            loanFile.setContractId(contractId);
            deleteContract(loanFile);
        }
    }

    public List<Contract> getAllContracts() {
        return getHibernateTemplate().loadAll(Contract.class);
    }

    public List<Contract> getContractByBorrower(long borrowerId) {
        List results = null;
        final Customer borrower = new Customer();
        borrower.setCustomerId(borrowerId);
        results = getContractByBorrower(borrower);
        return results;
    }

    public List<Contract> getContractByBorrower(Customer borrower) {
        List<Contract> results = null;
        if (borrower != null) {
            try {
                results = (List<Contract>) getHibernateTemplate().find(
                        "from Contract contract where "
                                + " contract.signedByManager is not null and "
                                + " contract.borrower = ?", borrower);
            } catch (Exception e) {
                log.error("Cannot retrieve a loan contract: " + e.getMessage());
            }
        }
        return results;
    }

    public Contract getContractById(String contractId) {
        if (contractId != null) {
            return getHibernateTemplate().get(Contract.class, contractId);
        }
        return null;
    }

    public void save(Contract loan) {
        if (loan != null) {
            try {
                getHibernateTemplate().saveOrUpdate(loan);
            } catch (DataAccessException e) {
                log.error("Cannot save the loan contract: " + e.getMessage());
            }
        }
    }

    /**
     * Authenticates a {@link Staff} based on his ID and password
     *
     * @param staffId  -- the staff's ID
     * @param password -- the staff's password
     * @return the corresponding {@link Staff} if successful, otherwise
     * <code>null</code>
     */
    public Staff authenticateStaff(String staffId, String password) {
        Staff result = null;
        try {
            final List staff = getHibernateTemplate()
                    .findByNamedParam(
                            "select s from Staff as s where s.staffId=:staffId and s.password=:password",
                            new String[]{"staffId", "password"},
                            new Object[]{staffId, password});
            if (staff != null && staff.size() == 1) {
                result = (Staff) staff.get(0);
            }
        } catch (Exception e) {
            log.error("Cannot authenticate staff: " + e.getMessage());
        }
        return result;
    }

    public void deleteStaff(Staff staff) {
        if (staff != null) {
            try {
                getHibernateTemplate().delete(staff);
            } catch (DataAccessException e) {
                log.error("Cannot delete the staff: " + e.getMessage());
            }
        }
    }

    public void deleteStaff(String staffId) {
        if (staffId != null) {
            final Staff staff = new Staff();
            staff.setStaffId(staffId);
            deleteStaff(staff);
        }
    }

    public List<Staff> getAllStaffs() {
        return getHibernateTemplate().loadAll(Staff.class);
    }

    public List<Staff> getCreditBrokers() {
        return getStaffByRole(Role.CREDIT_BROKER);
    }

    public List<Staff> getManagers() {
        return getStaffByRole(Role.MANAGER);
    }

    public List<Staff> getPostProcessingClerks() {
        return getStaffByRole(Role.POST_PROCESSING_CLERK);
    }

    public List<Staff> getSupervisors() {
        return getStaffByRole(Role.SUPERVISOR);
    }

    public Staff getStaffById(String staffId) {
        Staff staff = null;
        if (staffId != null) {
            try {
                staff = getHibernateTemplate().get(Staff.class, staffId);
            } catch (Exception e) {
                log.error("Cannot get the staff: " + e.getMessage());
            }
        }
        return staff;
    }

    public List<Staff> getStaffByRole(String role) {
        return getStaffByRole(new Role(role));
    }

    public List<Staff> getStaffByRole(Role role) {
        List<Staff> staff = new ArrayList<>();
        if (role != null) {
            try {
                staff = (List<Staff>) getHibernateTemplate().findByNamedParam(
                        "select s from Staff as s where s.role=:role",
                        new String[]{"role"}, new Object[]{role});
            } catch (DataAccessException e) {
                log.error("Cannot retrieve staff: " + e.getMessage());
            }
        }
        return staff;
    }

    public void save(Staff staff) {
        if (staff != null) {
            getHibernateTemplate().saveOrUpdate(staff);
        }
    }

    public List<Role> getAllRoles() {
        final List<Role> listOfRoles = getHibernateTemplate().loadAll(
                Role.class);
        return listOfRoles;
    }

    public List<Agency> getAllAgencies() {
        return getHibernateTemplate().loadAll(Agency.class);
    }
}
