package com.westbank.service;

import com.westbank.helper.DateHelper;
import com.westbank.dao.LoanContractDao;
import com.westbank.domain.Agency;
import com.westbank.domain.Contract;
import com.westbank.domain.Customer;
import com.westbank.ws.business.loancontract._2018._06.Address;
import com.westbank.ws.business.loancontract._2018._06.LoanContractRequest;
import com.westbank.ws.business.loancontract._2018._06.LoanContractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LoanContractServiceImpl implements LoanContractService {

    protected final LoanContractDao loanContractDao;

    @Autowired
    public LoanContractServiceImpl(LoanContractDao loanContractDao) {
        this.loanContractDao = loanContractDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contract> getAllContracts() {
        return loanContractDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contract> getContractById(Long contractId) {
        return loanContractDao.findContractById(contractId);
    }

    @Override
    @Transactional
    public void save(Contract contract) {
        loanContractDao.save(contract);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contract> getContractByBorrower(Long customerId) {
        return loanContractDao.findContractByBorrowerId(customerId);
    }

    @Override
    @Transactional
    public LoanContractResponse createLoanContract(LoanContractRequest request) {
        Contract contract = loanContractDao.createAndStoreNewContract(request);
        return createLoanContractResponse(contract);
    }

    @Override
    @Transactional
    public LoanContractResponse createLoanContractResponse(Contract contract) {
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
                response.setBorrowerDateOfBirth(DateHelper.convert(contract
                        .getBorrower().getDateOfBirth()));
                final Address responseBorrowerAddress = new Address();

                com.westbank.domain.Address borrowerAddress = borrower.getAddress();
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
                    response.setCoBorrowerDateOfBirth(DateHelper
                            .convert(coborrower.getDateOfBirth()));
                }
            }
            response.setMonthlyPayment(contract.getMonthlyPayment());

            response.setLoanReason(contract.getLoanReason());
            response.setLoanAmount(contract.getLoanAmount());
            response.setLoanTerm(contract.getLoanTerm());
            response.setInterestRate(contract.getInterestRate());

            response.setSettlementDate(DateHelper.convert(contract
                    .getSettlementDate()));

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
}
