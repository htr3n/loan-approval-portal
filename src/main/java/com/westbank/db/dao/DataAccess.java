package com.westbank.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.westbank.db.entity.*;
import com.westbank.mvc.Constants;
import com.westbank.mvc.customer.model.ApplicationForm;
import com.westbank.util.DateUtil;
import com.westbank.util.DbUtil;
import com.westbank.ws.business.loancontract._2009._11.Address;
import com.westbank.ws.business.loancontract._2009._11.LoanContractRequest;
import com.westbank.ws.business.loancontract._2009._11.LoanContractResponse;
import com.westbank.ws.business.loanfile._2009._11.LoanFileRequest;
import com.westbank.ws.business.loanfile._2009._11.LoanFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import westbank.db.entity.Address;
import westbank.db.entity.Agency;
import westbank.db.entity.Contract;
import westbank.db.entity.Customer;
import westbank.db.entity.EstateType;
import westbank.db.entity.LoanFile;
import westbank.db.entity.LoanFileStatus;
import westbank.db.entity.ResidenceType;
import westbank.db.entity.Role;
import westbank.db.entity.Staff;
import westbank.mvc.Constants;
import westbank.mvc.customer.model.ApplicationForm;
import westbank.util.DateUtil;
import westbank.util.DbUtil;
import westbank.ws.business.loancontract._2009._11.LoanContractRequest;
import westbank.ws.business.loancontract._2009._11.LoanContractResponse;
import westbank.ws.business.loanfile._2009._11.LoanFileRequest;
import westbank.ws.business.loanfile._2009._11.LoanFileResponse;

public class DataAccess extends HibernateDaoSupport {

    static Logger log = LoggerFactory.getLogger(DataAccess.class);

    /**
     * Creates and stores a loan contract the underlying database
     *
     * @param request -- a {@link LoanFileRequest} object
     * @return a {@link LoanFileResponse} object
     */
    public LoanContractResponse createLoanContract(LoanContractRequest request) {
        LoanContractResponse response = null;
        if (request != null) {
            Contract contract = createAndStoreNewContract(request);
            response = createLoanContractResponse(contract);
        }
        return response;
    }

    /**
     * Creates and stores a new loan contract. This helper function is invoked by
     * the others
     *
     * @param request -- the input {@link LoanContractRequest}
     * @return the stored {@link Contract} object if successful, otherwise
     * <code>null</code>
     */
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
                contract.setTotalPurchasePrice(loanFile.getTotalPurchasePrice());
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

    /**
     * Creates a {@link LoanContractResponse} based on information of a
     * {@link Contract}
     *
     * @param contract -- the input {@link Contract}
     * @return a {@link LoanContractResponse} object
     */
    protected LoanContractResponse createLoanContractResponse(Contract contract) {
        LoanContractResponse response = new LoanContractResponse();
        if (contract != null) {
            response.setLoanContractId(contract.getContractId());
            Customer borrower = contract.getBorrower();
            if (borrower != null) {
                response.setBorrowerCustomerId(borrower.getCustomerId());
                response.setBorrowerTitle(contract.getBorrower().getTitle());
                response.setBorrowerFirstName(contract.getBorrower().getFirstName());
                response.setBorrowerLastName(contract.getBorrower().getLastName());
                response.setBorrowerDateOfBirth(DateUtil.convert(contract.getBorrower().getDateOfBirth()));
                final Address responseBorrowerAddress = new Address();

                Address borrowerAddress = borrower.getAddress();
                if (borrowerAddress != null) {
                    responseBorrowerAddress.setStreet(borrowerAddress.getStreet());
                    responseBorrowerAddress.setZipcode(borrowerAddress.getZipcode());
                    responseBorrowerAddress.setCity(borrowerAddress.getCity());
                    responseBorrowerAddress.setState(borrowerAddress.getState());
                    responseBorrowerAddress.setCountry(borrowerAddress.getCountry());
                }
                response.setBorrowerAddress(responseBorrowerAddress);
            }
            response.setCoBorrower(contract.isHasCoBorrower());

            if (contract.isHasCoBorrower()) {
                Customer coborrower = contract.getCoBorrower();
                if (coborrower != null) {
                    response.setCoBorrowerCustomerId(coborrower.getCustomerId());
                    response.setCoBorrowerTitle(coborrower.getTitle());
                    response.setCoBorrowerFirstName(coborrower.getFirstName());
                    response.setCoBorrowerLastName(coborrower.getLastName());
                    response.setCoBorrowerDateOfBirth(DateUtil.convert(coborrower.getDateOfBirth()));
                }
            }
            response.setMonthlyPayment(contract.getMonthlyPayment());

            response.setLoanReason(contract.getLoanReason());
            response.setLoanAmount(contract.getLoanAmount());
            response.setLoanTerm(contract.getLoanTerm());
            response.setInterestRate(contract.getInterestRate());

            response.setSettlementDate(DateUtil.convert(contract.getSettlementDate()));

            response.setResidenceType(contract.getResidenceType().name());
            response.setEstateType(contract.getEstateType().name());
            response.setEstateLocation(contract.getEstateLocation());

            Agency agency = contract.getAgency();
            if (agency != null) {
                response.setAgencyCode(agency.getAgencyCode());
                response.setBankName(agency.getBankName());
                final Address agencyAddress = new Address();
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
     * Processes a {@link LoanFileRequest}, extracts borrower's, co-borrower's, and
     * loan information, creates a new {@link LoanFile}, creates new
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
            borrower = getCustomerById(request.getBorrowerCustomerId());
            if (borrower != null)
                log.info("Borrower exists");
            if (borrower == null) {
                log.info("Create a new borrrower");
                borrower = new Customer();
                borrower.setPersonalId(request.getBorrowerPersonalId());
                borrower.setTitle(request.getBorrowerTitle());
                borrower.setFirstName(request.getBorrowerFirstName());
                borrower.setLastName(request.getBorrowerLastName());
                if (request.getBorrowerDateOfBirth() != null)
                    borrower.setDateOfBirth(request.getBorrowerDateOfBirth().toGregorianCalendar().getTime());

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
            boolean hasCoborrower = request.isCoBorrower();
            if (hasCoborrower) {

                coborrower = getCustomerById(request.getCoBorrowerCustomerId());
                if (coborrower != null)
                    log.info("Co-borrrower exists");
                if (coborrower == null) {
                    log.info("Create a new co-borrrower");
                    coborrower = new Customer();
                    coborrower.setPersonalId(request.getCoBorrowerPersonalId());
                    coborrower.setTitle(request.getCoBorrowerTitle());
                    coborrower.setFirstName(request.getCoBorrowerFirstName());
                    coborrower.setLastName(request.getCoBorrowerLastName());
                    if (request.getCoBorrowerDateOfBirth() != null)
                        coborrower.setDateOfBirth(request.getCoBorrowerDateOfBirth().toGregorianCalendar().getTime());
                    coborrower.setPin(DbUtil.generatePassword(DbUtil.PIN_LENGTH));
                    try {
                        coborrower.setIncome(request.getCoBorrowerIncome());
                    } catch (Exception ignored) {
                    }
                    coborrower.setOccupation(request.getCoBorrowerOccupation());
                    try {
                        coborrower.setLengthOfService(request.getCoBorrowerLengthOfService());
                    } catch (Exception ignored) {
                    }

                    coborrower.setEmail(request.getCoBorrowerEmail());
                }
            }
            log.info("Create a new loan file");
            loanFile = new LoanFile();
            loanFile.setLoanFileId(request.getLoanFileId());
            loanFile.setBorrower(borrower);
            loanFile.setHasCoBorrower(hasCoborrower);
            if (hasCoborrower) {
                loanFile.setCoBorrower(coborrower);
            }
            loanFile.setLoanAmount(request.getLoanAmount());
            loanFile.setLoanReason(request.getLoanReason());
            loanFile.setLoanTerm(request.getLoanTerm());
            loanFile.setInterestRate(request.getInterestRate());
            try {
                loanFile.setResidenceType(ResidenceType.valueOf(request.getResidenceType()));
            } catch (IllegalArgumentException ex) {
                log.error("The resident type is not of a valid enum");
            }
            try {
                loanFile.setEstateType(EstateType.valueOf(request.getEstateType()));
            } catch (IllegalArgumentException ex) {
                log.error("The estate type is not of a valid enum");
            }
            loanFile.setEstateLocation(request.getEstateLocation());
            if (request.getSettlementDate() != null)
                loanFile.setSettlementDate(request.getSettlementDate().toGregorianCalendar().getTime());
            loanFile.setTotalPurchasePrice(request.getTotalPurchasePrice());
            loanFile.setPersonalCapitalContribution(request.getPersonalCapitalContribution());
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
                if (coborrower != null && coborrower.getCustomerId() != null) {
                    response.setCoborrowerId(coborrower.getCustomerId());
                }
            } catch (final Throwable e) {
                log.error("Cannot save data: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * Processes a {@link ApplicationForm}, extracts customer's, creates new
     * {@link Customer}s if necessary (otherwise, retrieves existing
     * {@link Customer}s), then, stored them in the databases
     *
     * @param form -- the input {@link ApplicationForm}
     * @return a {@link Customer} object if successful, otherwise <code>null</code>
     */
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
                customer.setNumberOfChildren(form.getBorrowerNumberOfChildren());

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
                if (newPin != null && !newPin.isEmpty() && newPin.equals(newPinAgain)) {
                    customer.setPin(newPin);
                }
                save(customer);
                getHibernateTemplate().flush();
            }
        } catch (Exception e) {
            log.error("Error when updating customer profile: " + e.getMessage());
        }
        return customer;
    }

    /**
     * Authenticates a {@link Customer} based on his email and pin
     *
     * @param email -- the customer's email
     * @param pin   -- the customer's personal identification number (PIN)
     * @return the corresponding {@link Customer} object if successful, otherwise
     * <code>null</code>
     */
    public Customer authenticateCustomer(String email, String pin) {
        final List<Customer> users = (List<Customer>) getHibernateTemplate().findByNamedParam(
                "select c from Customer as c where c.email=:email and c.pin=:pin",
                new String[]{"email", "pin"},
                new Object[]{email, pin});
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    /**
     * Deletes a {@link Customer} from the database
     *
     * @param customer -- the {@link Customer} object to be deleted
     */
    public void deleteCustomer(Customer customer) {
        if (customer != null) {
            getHibernateTemplate().delete(customer);
        }
    }

    /**
     * Deletes a {@link Customer} from the database
     *
     * @param customerId -- the ID of the {@link Customer} to be deleted
     */
    public void deleteCustomer(long customerId) {
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        this.deleteCustomer(customer);
    }

    /**
     * Retrieves all {@link Customer}s stored in the database
     *
     * @return a {@link List} of {@link Customer}s
     */
    public List<Customer> getAllCustomers() {
        return getHibernateTemplate().loadAll(Customer.class);
    }

    /**
     * Retrieves a customer by his/her ID
     *
     * @param customerId -- the customer's ID
     * @return the corresponding {@link Customer} if existed, otherwise
     * <code>null</code>
     */
    public Customer getCustomerById(long customerId) {
        return getHibernateTemplate().get(Customer.class, customerId);
    }

    /**
     * Stored a {@link Customer} in the database
     *
     * @param customer -- the {@link Customer} object to be stored
     */
    public void save(Customer customer) {
        if (customer != null) {
            getHibernateTemplate().saveOrUpdate(customer);
        }
    }

    /**
     * Deletes a {@link LoanFile} from the database
     *
     * @param loanFile -- the {@link LoanFile} object to be deleted
     */
    public void deleteLoanFile(LoanFile loanFile) {
        if (loanFile != null) {
            getHibernateTemplate().delete(loanFile);
        }
    }

    /**
     * Deletes a {@link LoanFile} from the database
     *
     * @param loanFileId -- the ID of the {@link LoanFile} object to be deleted
     */
    public void deleteLoanFile(String loanFileId) {
        if (loanFileId != null) {
            final LoanFile loanFile = new LoanFile();
            loanFile.setLoanFileId(loanFileId);
            deleteLoanFile(loanFile);
        }

    }

    /**
     * Retrieves all {@link LoanFile}s stored in the database
     *
     * @return a {@link List} of {@link LoanFile}s
     */
    public List<LoanFile> getAllLoanFiles() {
        return getHibernateTemplate().loadAll(LoanFile.class);
    }

    /**
     * Retrieves a list of {@link LoanFile}s of a {@link Customer}
     *
     * @param borrowerId -- the borrower's ID
     * @return a {@link List} of {@link LoanFile}s if successful, otherwise an empty
     * {@link List}
     */
    public List<LoanFile> getLoanFileByBorrower(long borrowerId) {
        List<LoanFile> results = null;
        try {
            final Customer borrower = new Customer();
            borrower.setCustomerId(borrowerId);
            results = (List<LoanFile>) getHibernateTemplate().find("from LoanFile lf where lf.borrower = ?", borrower);
        } catch (Exception e) {
            log.error("Cannot retrieve a loanfile by borrowerId: " + e.getMessage());
        }
        return results;
    }

    /**
     * Retrieves a {@link LoanFile} by its ID
     *
     * @param loanFileId -- the ID of the loan file to be retrieved
     * @return the corresponding {@link LoanFile} if existed, otherwise
     * <code>null</code>
     */
    public LoanFile getLoanFileById(String loanFileId) {
        LoanFile result = null;
        if (loanFileId != null) {
            result = getHibernateTemplate().get(LoanFile.class, loanFileId);
        }
        return result;
    }

    /**
     * Stores a {@link LoanFile} object in the database
     *
     * @param loanFile -- the {@link LoanFile} object to be stored
     */
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
                "select lf from LoanFile as lf where " + " lf.customer=:customer " + " and lf.status=:status",
                new String[]{"customer", "status"}, new Object[]{customer, LoanFileStatus.APPROVED});
        return results;
    }

    /**
     * Retrieves a {@link LoanFile} by a staff's role
     *
     * @param role -- the staff's role
     * @return a {@link List} of {@link LoanFile}s if successful, otherwise an empty
     * {@link List}
     */
    public List<LoanFile> getLoanFileByRole(String role) {
        List<LoanFile> results = null;
        if (role != null) {

            // Role credit broker only sees initialized loan files
            if (Role.CREDIT_BROKER.equalsIgnoreCase(role)) {

                results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
                        "select lf from LoanFile as lf where " + " lf.status=:status", new String[]{"status"},
                        new Object[]{LoanFileStatus.INITIALIZED});

            } else if (Role.POST_PROCESSING_CLERK.equalsIgnoreCase(role)) {

                // Role clerk only sees loan files that have loan amount below
                // the threshold
                results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
                        "select lf from LoanFile as lf where " + " lf.status=:status  "
                                + " and lf.loanAmount < :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION, Constants.LOAN_THRESHOLD});

            } else if (Role.SUPERVISOR.equalsIgnoreCase(role)) {

                // Role supversior can see loan files that have loan amount
                // above the threshold
                results = (List<LoanFile>) getHibernateTemplate().findByNamedParam(
                        "select lf from LoanFile as lf where " + " lf.status=:status "
                                + " and lf.loanAmount >= :threshold",
                        new String[]{"status", "threshold"},
                        new Object[]{LoanFileStatus.UNDER_CONSIDERATION, Constants.LOAN_THRESHOLD});

            } else if (Role.MANAGER.equalsIgnoreCase(role)) {
                results = getAllLoanFiles();
            } else {
                log.info("Unrecognized role '" + role + "'");
            }
        }
        return results;
    }

    /**
     * Deletes a {@link Contract} from the database
     *
     * @param contract -- the {@link Contract} object to be deleted
     */
    public void deleteContract(Contract contract) {
        if (contract != null) {
            getHibernateTemplate().delete(contract);
        }
    }

    /**
     * Deletes a {@link Contract} from the database
     *
     * @param contractId -- the ID of the {@link Contract} object to be deleted
     */
    public void deleteLoanContract(String contractId) {
        if (contractId != null) {
            final Contract loanFile = new Contract();
            loanFile.setContractId(contractId);
            deleteContract(loanFile);
        }
    }

    /**
     * Retrieves all {@link Contract}s stored in the database
     *
     * @return a {@link List} of {@link Contract}s
     */
    public List<Contract> getAllContracts() {
        return getHibernateTemplate().loadAll(Contract.class);
    }

    /**
     * Retrieves all {@link Contract}s stored in the database by a borrower's ID
     *
     * @param borrowerId -- the borrower's ID
     * @return a {@link List} of {@link Contract}s if successful, otherwise,
     * <code>null</code>
     */
    public List<Contract> getContractByBorrower(long borrowerId) {
        List<Contract> results = null;
        final Customer borrower = new Customer();
        borrower.setCustomerId(borrowerId);
        results = getContractByBorrower(borrower);
        return results;
    }

    /**
     * Retrieves all {@link Contract}s stored in the database by a {@link Customer}
     *
     * @param borrower -- the {@link Customer} object
     * @return a {@link List} of {@link Contract}s if successful, otherwise,
     * <code>null</code>
     */
    public List<Contract> getContractByBorrower(Customer borrower) {
        List<Contract> results = null;
        if (borrower != null) {
            try {
                results = (List<Contract>) getHibernateTemplate().find("from Contract contract where "
                        + " contract.signedByManager is not null and " + " contract.borrower = ?", borrower);
            } catch (Exception e) {
                log.error("Cannot retreive a loan contract: " + e.getMessage());
            }
        }
        return results;
    }

    /**
     * Retrieves a {@link Contract} stored in the database by its ID
     *
     * @param contractId -- the ID of the {@link Contract} to be retrieved
     * @return the corresponding {@link Contract} if existed, otherwise,
     * <code>null</code>
     */
    public Contract getContractById(String contractId) {
        if (contractId != null) {
            return getHibernateTemplate().get(Contract.class, contractId);
        }
        return null;
    }

    /**
     * Stores a {@link Contract} in the database
     *
     * @param contract -- the {@link Contract} object to be stored
     */
    public void save(Contract contract) {
        if (contract != null) {
            try {
                getHibernateTemplate().saveOrUpdate(contract);
            } catch (DataAccessException e) {
                log.error("Cannot save the contract contract: " + e.getMessage());
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
            final List<Staff> staff = (List<Staff>) getHibernateTemplate().findByNamedParam(
                    "select s from Staff as s where s.staffId=:staffId and s.password=:password",
                    new String[]{"staffId", "password"}, new Object[]{staffId, password});
            if (staff != null && staff.size() == 1) {
                result = (Staff) staff.get(0);
            }
        } catch (Exception e) {
            log.error("Cannot authenticate staff: " + e.getMessage());
        }
        return result;
    }

    /**
     * Deletes a staff from DBMS
     *
     * @param staff -- the staff to be deleted
     */
    public void deleteStaff(Staff staff) {
        if (staff != null) {
            try {
                getHibernateTemplate().delete(staff);
            } catch (DataAccessException e) {
                log.error("Cannot delete the staff: " + e.getMessage());
            }
        }
    }

    /**
     * Deletes a staff by his ID
     *
     * @param staffId -- the ID of the staff to be deleted
     */
    public void deleteStaff(String staffId) {
        if (staffId != null) {
            final Staff staff = new Staff();
            staff.setStaffId(staffId);
            deleteStaff(staff);
        }
    }

    /**
     * Retrieves all {@link Staff} in the database
     *
     * @return a {@link List} of {@link Staff}
     */
    public List<Staff> getAllStaffs() {
        return getHibernateTemplate().loadAll(Staff.class);
    }

    /**
     * Retrieves all {@link Staff} that play the role CREDIT BROKER
     *
     * @return a {@link List} of the corresponding {@link Staff}
     */
    public List<Staff> getCreditBrokers() {
        return getStaffByRole(Role.CREDIT_BROKER);
    }

    /**
     * Retrieves all {@link Staff} that play the role MANAGER
     *
     * @return a {@link List} of the corresponding {@link Staff}
     */
    public List<Staff> getManagers() {
        return getStaffByRole(Role.MANAGER);
    }

    /**
     * Retrieves all {@link Staff} that play the role POST-PROCESSING-CLERK
     *
     * @return a {@link List} of the corresponding {@link Staff}
     */
    public List<Staff> getPostProcessingClerks() {
        return getStaffByRole(Role.POST_PROCESSING_CLERK);
    }

    /**
     * Retrieves all {@link Staff} that play the role SUPERVISOR
     *
     * @return a {@link List} of the corresponding {@link Staff}
     */
    public List<Staff> getSupervisors() {
        return getStaffByRole(Role.SUPERVISOR);
    }

    /**
     * Looks up for a {@link Staff} by his ID
     *
     * @param staffId -- the ID of the staff to be looked up
     * @return the corresponding {@link Staff} if existed, otherwise
     * <code>null</code>
     */
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

    /**
     * Retrieves all {@link Staff} that play a certain role
     *
     * @param role -- the input role
     * @return a {@link List} of the corresponding {@link Staff}
     */
    public List<Staff> getStaffByRole(String role) {
        return getStaffByRole(new Role(role));
    }

    /**
     * Retrieves all {@link Staff} that play a certain role
     *
     * @param role -- the input {@link Role}
     * @return a {@link List} of the corresponding {@link Staff}
     */
    public List<Staff> getStaffByRole(Role role) {
        List<Staff> staff = new ArrayList<Staff>();
        if (role != null) {
            try {
                staff = (List<Staff>) getHibernateTemplate().findByNamedParam("select s from Staff as s where s.role=:role",
                        new String[]{"role"}, new Object[]{role});
            } catch (DataAccessException e) {
                log.error("Cannot retrieve staff: " + e.getMessage());
            }
        }
        return staff;
    }

    /**
     * Stores or updates a {@link Staff} in the database
     *
     * @param customer -- the {@link Staff} object to be stored or updated
     */
    public void save(Staff staff) {
        if (staff != null) {
            getHibernateTemplate().saveOrUpdate(staff);
        }
    }

    /**
     * Retrieves all {@link Role} in the database
     *
     * @return a {@link List} of {@link Role}
     */
    public List<Role> getAllRoles() {
        final List<Role> listOfRoles = getHibernateTemplate().loadAll(Role.class);
        return listOfRoles;
    }

    /**
     * Retrieves all {@link Agency} in the database
     *
     * @return a {@link List} of {@link Agency}
     */
    public List<Agency> getAllAgencies() {
        return getHibernateTemplate().loadAll(Agency.class);
    }
}
