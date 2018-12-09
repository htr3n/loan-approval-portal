package com.westbank.ws.impl;

import com.westbank.dao.LoanContractDao;
import com.westbank.dao.LoanFileDao;
import com.westbank.domain.Address;
import com.westbank.domain.Contract;
import com.westbank.domain.Customer;
import com.westbank.domain.LoanFileStatus;
import com.westbank.domain.Role;
import com.westbank.helper.DateHelper;
import com.westbank.service.CustomerService;
import com.westbank.ws.business.bankinformation._2018._06.BankInformation;
import com.westbank.ws.business.bankinformation._2018._06.BankInformationRequest;
import com.westbank.ws.business.bankinformation._2018._06.BankInformationResponse;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilegeRequest;
import com.westbank.ws.business.bankprivilege._2018._06.BankPrivilegeResponse;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessRequest;
import com.westbank.ws.business.creditworthiness._2018._06.CreditWorthinessResponse;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosing;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosingRequest;
import com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosingResponse;
import com.westbank.ws.business.loancontract._2018._06.LoanContract;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;
import com.westbank.ws.business.loanfile._2018._06.LoanFile;
import com.westbank.ws.business.loanfile._2018._06.LoanFileRequest;
import com.westbank.ws.business.loanfile._2018._06.LoanFileResponse;
import com.westbank.ws.business.loanrisk._2018._06.LoanRisk;
import com.westbank.ws.business.loanrisk._2018._06.LoanRiskRequest;
import com.westbank.ws.business.loanrisk._2018._06.LoanRiskResponse;
import com.westbank.ws.business.loansettlement._2018._06.LoanSettlement;
import com.westbank.ws.business.loansettlement._2018._06.LoanSettlementRequest;
import com.westbank.ws.business.loansettlement._2018._06.LoanSettlementResponse;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatch;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatchRequest;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatchResponse;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval;
import com.westbank.ws.client.callbackloanapproval.CallbackLoanApprovalRequest;
import com.westbank.ws.client.callbackloancontract.CallbackLoanContract;
import com.westbank.ws.client.callbackloancontract.CallbackLoanContractRequest;
import com.westbank.ws.process.loanapproval._2018._06.AddressType;
import com.westbank.ws.process.loanapproval._2018._06.CustomerDecision;
import com.westbank.ws.process.loanapproval._2018._06.LoanApproval;
import com.westbank.ws.process.loanapproval._2018._06.LoanApprovalRequest;
import com.westbank.ws.process.loanapproval._2018._06.ManagerDecision;
import com.westbank.ws.process.loanapproval._2018._06.ManagerSignature;
import com.westbank.ws.process.loanapproval._2018._06.StaffIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
@javax.jws.WebService(
        serviceName = "LoanApproval",
        portName = "LoanApprovalPort",
        targetNamespace = "urn:com:westbank:ws:process:LoanApproval:2018:06",
        endpointInterface = "com.westbank.ws.process.loanapproval._2018._06.LoanApproval")
public class LoanApprovalImpl implements LoanApproval {

    protected static final Logger log = LoggerFactory.getLogger(LoanApprovalImpl.class);

    static final String WSDL = "?wsdl";
    static final String BankInformation = "BankInformation";
    static final String BankPrivilege = "BankPrivilege";
    static final String CreditWorthiness = "CreditWorthiness";
    static final String LoanApprovalClosing = "LoanApprovalClosing";
    static final String LoanFile = "LoanFile";
    static final String LoanContract = "LoanContract";
    static final String LoanRisk = "LoanRisk";
    static final String LoanSettlement = "LoanSettlement";
    static final String TaskDispatch = "TaskDispatch";
    static final String CallbackLoanApproval = "CallbackLoanApproval";
    static final String CallbackLoanContract = "CallbackLoanContract";

    String endpointBase;

    com.westbank.ws.business.bankinformation._2018._06.BankInformation bankInformation;
    com.westbank.ws.business.bankprivilege._2018._06.BankPrivilege bankPrivilege;
    com.westbank.ws.business.creditworthiness._2018._06.CreditWorthiness creditWorthiness;
    com.westbank.ws.business.loanapprovalclosing._2018._06.LoanApprovalClosing loanApprovalClosing;
    com.westbank.ws.business.loanfile._2018._06.LoanFile loanFile;
    com.westbank.ws.business.loancontract._2018._06.LoanContract loanContract;
    com.westbank.ws.business.loanrisk._2018._06.LoanRisk loanRisk;
    com.westbank.ws.business.loansettlement._2018._06.LoanSettlement loanSettlement;
    com.westbank.ws.business.taskdispatch._2018._06.TaskDispatch taskDispatch;
    com.westbank.ws.client.callbackloanapproval.CallbackLoanApproval callbackLoanApproval;
    com.westbank.ws.client.callbackloancontract.CallbackLoanContract callbackLoanContract;

    @Autowired
    private LoanContractDao loanContractDao;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private LoanFileDao loanFileDao;

    @Override
    public void start(LoanApprovalRequest request) {
        log.info("Received a loan request: " + request);
        try {
            createLoanFile(request);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void processedByStaff(StaffIdentity request) {
        log.info("Received a staff identity:" + request);
        if (request != null) {

            String staffId = request.getStaffId();
            String staffRole = request.getStaffRole();
            Long loanFileId = request.getLoanFileId();

            if (Role.CREDIT_BROKER.equals(staffRole)) {
                try {
                    invokeBankPrivilege(loanFileId, staffId, staffRole);
                    requestBankInformation(loanFileId, staffId, staffRole);
                    dispatchTask(loanFileId, staffId, staffRole);
                } catch (final Exception e) {
                    e.printStackTrace();
                }

            } else if (Role.POST_PROCESSING_CLERK.equals(staffRole) || Role.SUPERVISOR.equals(staffRole)) {
                try {
                    checkCreditWorthiness(loanFileId, staffId, staffRole);
                    LoanRiskResponse risk = evaluateLoanRisk(loanFileId, staffId, staffRole);
                    if (risk != null && !risk.isHighRisk()) {
                        createLoanContract(loanFileId, staffId, staffRole);
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else {
                log.info("Role '" + staffRole + "' has not been supported at this point");
            }
        }
    }

    @Override
    public void decidedByManager(ManagerDecision request) {
        log.info("Received the manager's decision:" + request);
        if (request != null) {
            Long loanFileId = request.getLoanFileId();
            String staffId = request.getStaffId();
            String staffRole = Role.MANAGER;
            // the high-risk loan is granted ...
            if (request.isGranted()) {
                try {
                    createLoanContract(loanFileId, staffId, staffRole);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else { /* ... or rejected */
                try {
                    notifyCustomer(loanFileId, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void informedByCustomer(CustomerDecision request) {
        log.info("Received the customer's signature:" + request);
        Long contractId = request.getContractId();
        Optional<Contract> contract = loanContractDao.findContractById(contractId);
        if (contract.isPresent()) {
            Long loanFileId = contract.get().getLoanFile().getLoanFileId();
            performLoanSettlement(contractId);
            closeLoanApproval(loanFileId, contractId);
            notifyCustomer(loanFileId, contractId);
        }
    }

    @Override
    public void signedByManager(ManagerSignature request) {
        log.info("Received the manager's signature:" + request);
        Long contractId = request.getContractId();
        String staffId = request.getStaffId();
        String staffRole = Role.MANAGER;
        if (contractId != null) {
            sendLoanContract(contractId, staffId, staffRole);
        }
    }

    // CreateLoanFile
    protected LoanFileResponse createLoanFile(LoanApprovalRequest loanRequest) {

        final LoanFileRequest loanFileRequest = new LoanFileRequest();

        Long borrowerCustomerId = loanRequest.getBorrowerCustomerId();
        Customer borrower = null;
        if (borrowerCustomerId != null) {
            borrower = customerService.findCustomerById(borrowerCustomerId);
        }
        if (borrower != null) {
            loanFileRequest.setBorrowerCustomerId(borrowerCustomerId);
            loanFileRequest.setBorrowerTitle(borrower.getTitle());
            loanFileRequest.setBorrowerFirstName(borrower.getFirstName());
            loanFileRequest.setBorrowerLastName(borrower.getLastName());
            loanFileRequest.setBorrowerPersonalId(borrower.getPersonalId());
            loanFileRequest.setBorrowerDateOfBirth(DateHelper.convert(borrower.getDateOfBirth()));
            final Address address = borrower.getAddress();
            if (address != null) {
                loanFileRequest.setBorrowerStreet(address.getStreet());
                loanFileRequest.setBorrowerCity(address.getCity());
                loanFileRequest.setBorrowerZipcode(address.getZipcode());
                loanFileRequest.setBorrowerState(address.getState());
                loanFileRequest.setBorrowerCountry(address.getCountry());
            }
            loanFileRequest.setBorrowerPhone(borrower.getPhone());
            loanFileRequest.setBorrowerMobilePhone(borrower.getMobilePhone());
            loanFileRequest.setBorrowerEmail(borrower.getEmail());
            loanFileRequest.setBorrowerOccupation(borrower.getOccupation());
            loanFileRequest.setBorrowerLengthOfService(borrower.getLengthOfService());
            loanFileRequest.setBorrowerIncome(borrower.getIncome());
            if (borrower.getMaritalStatus() != null)
                loanFileRequest.setBorrowerMaritalStatus(borrower.getMaritalStatus().name());
            loanFileRequest.setBorrowerNumberOfChildren(borrower.getNumberOfChildren());

        } else {
            loanFileRequest.setBorrowerTitle(loanRequest.getBorrowerTitle());
            loanFileRequest.setBorrowerFirstName(loanRequest.getBorrowerFirstName());
            loanFileRequest.setBorrowerLastName(loanRequest.getBorrowerLastName());
            loanFileRequest.setBorrowerPersonalId(loanRequest.getBorrowerPersonalId());
            loanFileRequest.setBorrowerDateOfBirth(loanRequest.getBorrowerDateOfBirth());
            final AddressType address = loanRequest.getBorrowerAddress();
            if (address != null) {
                loanFileRequest.setBorrowerStreet(address.getStreet());
                loanFileRequest.setBorrowerCity(address.getCity());
                loanFileRequest.setBorrowerZipcode(address.getZipcode());
                loanFileRequest.setBorrowerState(address.getState());
                loanFileRequest.setBorrowerCountry(address.getCountry());
            }
            loanFileRequest.setBorrowerPhone(loanRequest.getBorrowerPhone());
            loanFileRequest.setBorrowerMobilePhone(loanRequest.getBorrowerMobilePhone());
            loanFileRequest.setBorrowerEmail(loanRequest.getBorrowerEmail());
            loanFileRequest.setBorrowerOccupation(loanRequest.getBorrowerOccupation());
            loanFileRequest.setBorrowerLengthOfService(loanRequest.getBorrowerLengthOfService());
            loanFileRequest.setBorrowerIncome(loanRequest.getBorrowerIncome());
            loanFileRequest.setBorrowerMaritalStatus(loanRequest.getBorrowerMaritalStatus());
            loanFileRequest.setBorrowerNumberOfChildren(loanRequest.getBorrowerNumberOfChildren());

            // loan information
            loanFileRequest.setResidenceType(loanRequest.getResidenceType());
            loanFileRequest.setEstateType(loanRequest.getEstateType());
            loanFileRequest.setEstateLocation(loanRequest.getEstateLocation());
        }
        // is there any co-borrower?
        loanFileRequest.setCoBorrower(loanRequest.isCoBorrower());
        if (loanRequest.isCoBorrower()) {

            Long coborrowerCustomerId = loanRequest.getCoBorrowerCustomerId();
            Customer coborrower = null;
            if (coborrowerCustomerId != null) {
                coborrower = customerService.findCustomerById(coborrowerCustomerId);
                log.info("Co-borrower existed!");
            }
            if (coborrower != null) {
                loanFileRequest.setCoBorrowerCustomerId(coborrowerCustomerId);
                loanFileRequest.setCoBorrowerTitle(coborrower.getTitle());
                loanFileRequest.setCoBorrowerFirstName(coborrower.getFirstName());
                loanFileRequest.setCoBorrowerLastName(coborrower.getLastName());
                loanFileRequest.setCoBorrowerDateOfBirth(DateHelper.convert(coborrower.getDateOfBirth()));
                loanFileRequest.setCoBorrowerOccupation(coborrower.getOccupation());
                loanFileRequest.setCoBorrowerLengthOfService(coborrower.getLengthOfService());
                loanFileRequest.setCoBorrowerIncome(coborrower.getIncome());
                loanFileRequest.setCoBorrowerEmail(coborrower.getEmail());
            } else {
                loanFileRequest.setCoBorrowerTitle(loanRequest.getCoBorrowerTitle());
                loanFileRequest.setCoBorrowerFirstName(loanRequest.getCoBorrowerFirstName());
                loanFileRequest.setCoBorrowerLastName(loanRequest.getCoBorrowerLastName());
                loanFileRequest.setCoBorrowerDateOfBirth(loanRequest.getCoBorrowerDateOfBirth());
                loanFileRequest.setCoBorrowerOccupation(loanRequest.getCoBorrowerOccupation());
                loanFileRequest.setCoBorrowerLengthOfService(loanRequest.getCoBorrowerLengthOfService());
                loanFileRequest.setCoBorrowerIncome(loanRequest.getCoBorrowerIncome());
                loanFileRequest.setCoBorrowerEmail(loanRequest.getCoBorrowerEmail());
            }
        }
        // loan info
        loanFileRequest.setResidenceType(loanRequest.getResidenceType());
        loanFileRequest.setEstateType(loanRequest.getEstateType());
        loanFileRequest.setEstateLocation(loanRequest.getEstateLocation());
        loanFileRequest.setLoanReason(loanRequest.getLoanReason());
        loanFileRequest.setLoanAmount(loanRequest.getLoanAmount());
        loanFileRequest.setLoanTerm(loanRequest.getLoanTerm());
        loanFileRequest.setInterestRate(loanRequest.getInterestRate());
        loanFileRequest.setTotalPurchasePrice(loanRequest.getTotalPurchasePrice());
        loanFileRequest.setPersonalCapitalContribution(loanRequest.getPersonalCapitalContribution());
        loanFileRequest.setSettlementDate(loanRequest.getSettlementDate());

        loanFileRequest.setAccessSensitiveData(loanRequest.isAccessSensitiveData());
        log.info("Access Sensitive Data Authorized? : " + loanRequest.isAccessSensitiveData());
        LoanFileResponse response = null;
        try {
            response = loanFile.update(loanFileRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    protected BankPrivilegeResponse invokeBankPrivilege(Long loanFileId, String staffId, String staffRole) {
        BankPrivilegeResponse response = null;

        final BankPrivilegeRequest request = new BankPrivilegeRequest();

        com.westbank.domain.LoanFile loanFile = loanFileDao.getLoanFileById(loanFileId);
        if (loanFile != null) {
            request.setBorrowerCustomerId(loanFile.getBorrower().getCustomerId());
            request.setBorrowerFirstName(loanFile.getBorrower().getFirstName());
            request.setBorrowerLastName(loanFile.getBorrower().getLastName());
            request.setBorrowerDateOfBirth(DateHelper.convert(loanFile.getBorrower().getDateOfBirth()));
            request.setStaffId(staffId);
            request.setStaffRole(staffRole);
            response = bankPrivilege.check(request);
        }
        return response;
    }

    protected BankInformationResponse requestBankInformation(Long loanFileId, String staffId, String staffRole) {

        final BankInformationRequest request = new BankInformationRequest();

        BankInformationResponse response = null;

        com.westbank.domain.LoanFile loanFile = loanFileDao.getLoanFileById(loanFileId);
        if (loanFile != null) {
            request.setLoanAmount(loanFile.getLoanAmount());
            request.setLoanTerm(loanFile.getLoanTerm());
            request.setInterestRate(loanFile.getInterestRate());
            request.setStaffId(staffId);
            request.setStaffRole(staffRole);
            response = bankInformation.retrieve(request);
        }
        return response;
    }

    protected TaskDispatchResponse dispatchTask(Long loanFileId, String staffId, String staffRole) {

        final TaskDispatchRequest request = new TaskDispatchRequest();

        TaskDispatchResponse response = null;

        com.westbank.domain.LoanFile loanFile = loanFileDao.getLoanFileById(loanFileId);
        if (loanFile != null) {
            request.setLoanAmount(loanFile.getLoanAmount());
            request.setStaffId(staffId);
            request.setStaffRole(staffRole);
            response = taskDispatch.dispatch(request);
        }
        return response;
    }

    protected CreditWorthinessResponse checkCreditWorthiness(Long loanFileId, String staffId, String staffRole) {

        final CreditWorthinessRequest request = new CreditWorthinessRequest();

        CreditWorthinessResponse response = null;

        if (loanFileId != null) {
            request.setLoanFileId(loanFileId);
            request.setNumberOfIncidents(new Random().nextInt());
            request.setNumberOfBanks(new Random().nextInt());
            request.setStaffId(staffId);
            request.setStaffRole(staffRole);
            response = creditWorthiness.check(request);
        }
        return response;
    }

    protected LoanRiskResponse evaluateLoanRisk(Long loanFileId, String staffId, String staffRole) {

        final LoanRiskRequest request = new LoanRiskRequest();
        if (loanFileId != null) {
            request.setLoanFileId(loanFileId);
            request.setStaffId(staffId);
            request.setStaffRole(staffRole);
        }
        return loanRisk.evaluate(request);
    }

    protected LoanContractResponse createLoanContract(Long loanFileId, String staffId, String staffRole) {

        final LoanContractRequest request = new LoanContractRequest();
        if (loanFileId != null) {
            request.setLoanFileId(loanFileId);
            request.setStaffId(staffId);
            request.setStaffRole(staffRole);
        }
        return loanContract.create(request);
    }

    protected LoanApprovalClosingResponse closeLoanApproval(Long loanFileId, Long contractId) {

        final LoanApprovalClosingRequest request = new LoanApprovalClosingRequest();
        if (loanFileId != null) {
            request.setLoanFileId(loanFileId);
        }
        if (contractId != null) {
            request.setLoanContractId(contractId);
        }
        return loanApprovalClosing.close(request);
    }

    protected LoanSettlementResponse performLoanSettlement(Long contractId) {

        final LoanSettlementRequest request = new LoanSettlementRequest();
        if (contractId != null) {
            request.setLoanContractId(contractId);
        }
        return loanSettlement.start(request);
    }

    protected void sendLoanContract(Long contractId, String staffId, String staffRole) {

        final CallbackLoanContractRequest request = new CallbackLoanContractRequest();
        if (contractId != null) {
            request.setLoanContractId(contractId);
        }
        callbackLoanContract.send(request);
    }

    protected void notifyCustomer(Long loanFileId, Long contractId) {
        final CallbackLoanApprovalRequest request = new CallbackLoanApprovalRequest();

        if (contractId != null) {
            request.setContractId(contractId);
        }

        com.westbank.domain.LoanFile loanFile = loanFileDao.getLoanFileById(loanFileId);

        if (loanFile != null) {
            request.setBorrowerCustomerId(loanFile.getBorrower().getCustomerId());
            request.setStatus(LoanFileStatus.APPROVED.name());
            request.setDescription(loanFile.getStatus().name());
        }
        callbackLoanApproval.notify(request);
    }

    public void setBankInformation(BankInformation bankInformation) {
        this.bankInformation = bankInformation;
    }

    public void setBankPrivilege(BankPrivilege bankPrivilege) {
        this.bankPrivilege = bankPrivilege;
    }

    public void setCreditWorthiness(CreditWorthiness creditWorthiness) {
        this.creditWorthiness = creditWorthiness;
    }

    public void setLoanApprovalClosing(LoanApprovalClosing loanApprovalClosing) {
        this.loanApprovalClosing = loanApprovalClosing;
    }

    public void setLoanFile(LoanFile loanFile) {
        this.loanFile = loanFile;
    }

    public void setLoanContract(LoanContract loanContract) {
        this.loanContract = loanContract;
    }

    public void setLoanRisk(LoanRisk loanRisk) {
        this.loanRisk = loanRisk;
    }

    public void setLoanSettlement(LoanSettlement loanSettlement) {
        this.loanSettlement = loanSettlement;
    }

    public void setTaskDispatch(TaskDispatch taskDispatch) {
        this.taskDispatch = taskDispatch;
    }

    public void setCallbackLoanApproval(CallbackLoanApproval callbackLoanApproval) {
        this.callbackLoanApproval = callbackLoanApproval;
    }

    public void setCallbackLoanContract(CallbackLoanContract callbackLoanContract) {
        this.callbackLoanContract = callbackLoanContract;
    }

    public void setEndpointBase(String endpointBase) {
        this.endpointBase = endpointBase;
    }

}
