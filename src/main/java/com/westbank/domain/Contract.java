package com.westbank.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = -8079310405218198036L;

	@ManyToOne(targetEntity = Agency.class)
	@JoinColumn(name = "agency")
	protected Agency agency;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "borrower")
	protected Customer borrower;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "coBorrower")
	protected Customer coBorrower;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long contractId;

	@Basic
	protected String estateLocation;

	@Enumerated(EnumType.STRING)
	protected EstateType estateType;

	@Basic
	protected boolean hasCoBorrower;

	@Basic
	protected double interestRate;

	@Basic
	protected double loanAmount;

	@Basic
	protected String loanReason;

	@Basic
	protected Integer loanTerm;

	@Basic
	protected Double monthlyPayment;

	@Enumerated(EnumType.STRING)
	protected ResidenceType residenceType;

	@Temporal(TemporalType.DATE)
	protected Date settlementDate;

	@Basic
	protected Double totalPurchasePrice; /* The total price of the flat */

	@OneToOne(targetEntity = LoanFile.class, mappedBy = "contract", cascade = CascadeType.ALL)
	protected LoanFile loanFile;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date signedByCustomer;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date signedByManager;

	public Contract() {
	}

	public Customer getBorrower() {
		return borrower;
	}

	public Customer getCoBorrower() {
		return coBorrower;
	}

	public Long getContractId() {
		return contractId;
	}

	public Customer getCustomer() {
		return borrower;
	}

	public EstateType getEstateType() {
		return estateType;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public Integer getLoanTerm() {
		return loanTerm;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public ResidenceType getResidenceType() {
		return residenceType;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public double getTotalPurchasePrice() {
		return totalPurchasePrice;
	}

	public boolean isHasCoBorrower() {
		return hasCoBorrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}

	public void setCoBorrower(Customer coBorrower) {
		this.coBorrower = coBorrower;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public void setCustomer(Customer customer) {
		this.borrower = customer;
	}

	public void setEstateType(EstateType estateType) {
		this.estateType = estateType;
	}

	public void setHasCoBorrower(boolean hasCoBorrower) {
		this.hasCoBorrower = hasCoBorrower;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	public void setLoanTerm(Integer loanTerm) {
		this.loanTerm = loanTerm;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public void setResidenceType(ResidenceType residenceType) {
		this.residenceType = residenceType;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public void setTotalPurchasePrice(double totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contract [");
		if (agency != null) {
			builder.append("agency=").append(agency).append(", ");
		}
		if (borrower != null) {
			builder.append("borrower=").append(borrower).append(", ");
		}
		if (coBorrower != null) {
			builder.append("coBorrower=").append(coBorrower).append(", ");
		}
		if (contractId != null) {
			builder.append("contractId=").append(contractId).append(", ");
		}
		if (estateLocation != null) {
			builder.append("estateLocation=").append(estateLocation).append(
					", ");
		}
		if (estateType != null) {
			builder.append("estateType=").append(estateType).append(", ");
		}
		builder.append("hasCoBorrower=").append(hasCoBorrower).append(
				", interestRate=").append(interestRate).append(", loanAmount=")
				.append(loanAmount).append(", ");
		if (loanFile != null) {
			builder.append("loanFile=").append(loanFile.getLoanFileId())
					.append(", ");
		}
		if (loanReason != null) {
			builder.append("loanReason=").append(loanReason).append(", ");
		}
		builder.append("loanTerm=").append(loanTerm)
				.append(", monthlyPayment=").append(monthlyPayment)
				.append(", ");
		if (residenceType != null) {
			builder.append("residenceType=").append(residenceType).append(", ");
		}
		if (settlementDate != null) {
			builder.append("settlementDate=").append(settlementDate).append(
					", ");
		}
		if (signedByCustomer != null) {
			builder.append("signedByCustomer=").append(signedByCustomer)
					.append(", ");
		}
		if (signedByManager != null) {
			builder.append("signedByManager=").append(signedByManager).append(
					", ");
		}
		builder.append("totalPurchasePrice=").append(totalPurchasePrice)
				.append("]");
		return builder.toString();
	}

	public String getEstateLocation() {
		return estateLocation;
	}

	public void setEstateLocation(String estateLocation) {
		this.estateLocation = estateLocation;
	}

	public LoanFile getLoanFile() {
		return loanFile;
	}

	public void setLoanFile(LoanFile loanFile) {
		this.loanFile = loanFile;
	}

	public Date getSignedByCustomer() {
		return signedByCustomer;
	}

	public void setSignedByCustomer(Date signedByCustomer) {
		this.signedByCustomer = signedByCustomer;
	}

	public Date getSignedByManager() {
		return signedByManager;
	}

	public void setSignedByManager(Date signedByManager) {
		this.signedByManager = signedByManager;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}
