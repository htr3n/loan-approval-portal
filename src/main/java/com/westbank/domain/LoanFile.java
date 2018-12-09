package com.westbank.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "loanfile")
public class LoanFile implements Serializable {

	private static final long serialVersionUID = -7780385054212644226L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long loanFileId;

	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "borrower")
	protected Customer borrower;

	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "coBorrower")
	protected Customer coBorrower;

	@ManyToOne(targetEntity = Staff.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy")
	protected Staff createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@Basic
	protected String description;

	@Basic
	protected String estateLocation;

	@Enumerated(EnumType.STRING)
	protected EstateType estateType;

	@Basic
	protected boolean hasCoBorrower;

	protected Double interestRate;

	protected Double loanAmount;

	protected String loanReason;

	protected Integer loanTerm;

	@Enumerated(EnumType.STRING)
	protected ResidenceType residenceType;

	@Enumerated(EnumType.STRING)
	protected LoanRisk risk;

	@Temporal(TemporalType.DATE)
	protected Date settlementDate;

	@Enumerated(EnumType.STRING)
	protected LoanFileStatus status;

	@Basic
	protected Double totalPurchasePrice;

	@Basic
	protected Double personalCapitalContribution;

	@ManyToOne(targetEntity = Staff.class, fetch = FetchType.LAZY)
	@JoinColumn
	protected Staff updatedBy;

	@Basic
	protected String updatedByRole;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedDate;

	@OneToOne(targetEntity = Contract.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_fk")
	protected Contract contract;
	
	@Basic
	protected boolean accessSensitiveData;

	public LoanFile() {
	}

	public Customer getBorrower() {
		return borrower;
	}

	public Customer getCoBorrower() {
		return coBorrower;
	}

	public Staff getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
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

	public Long getLoanFileId() {
		return loanFileId;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public Integer getLoanTerm() {
		return loanTerm;
	}

	public ResidenceType getResidenceType() {
		return residenceType;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public LoanFileStatus getStatus() {
		return status;
	}

	public Double getTotalPurchasePrice() {
		return totalPurchasePrice;
	}

	public Staff getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
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

	public void setCreatedBy(Staff createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public void setLoanFileId(Long loanFileId) {
		this.loanFileId = loanFileId;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	public void setLoanTerm(Integer loanTerm) {
		this.loanTerm = loanTerm;
	}

	public void setResidenceType(ResidenceType residenceType) {
		this.residenceType = residenceType;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public void setStatus(LoanFileStatus status) {
		this.status = status;
	}

	public void setTotalPurchasePrice(Double totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}

	public void setUpdatedBy(Staff updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanFile [");
		if (borrower != null) {
			builder.append("borrower=");
			builder.append(borrower.getCustomerId());
			builder.append(", ");
		}
		if (coBorrower != null) {
			builder.append("coBorrower=");
			builder.append(coBorrower.getCustomerId());
			builder.append(", ");
		}
		if (contract != null) {
			builder.append("contract=");
			builder.append(contract.getContractId());
			builder.append(", ");
		}
		if (createdBy != null) {
			builder.append("createdBy=");
			builder.append(createdBy);
			builder.append(", ");
		}
		if (createdDate != null) {
			builder.append("createdDate=");
			builder.append(createdDate);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		if (estateLocation != null) {
			builder.append("estateLocation=");
			builder.append(estateLocation);
			builder.append(", ");
		}
		if (estateType != null) {
			builder.append("estateType=");
			builder.append(estateType);
			builder.append(", ");
		}
		builder.append("hasCoBorrower=");
		builder.append(hasCoBorrower);
		builder.append(", interestRate=");
		builder.append(interestRate);
		builder.append(", loanAmount=");
		builder.append(loanAmount);
		builder.append(", ");
		if (loanFileId != null) {
			builder.append("loanFileId=");
			builder.append(loanFileId);
			builder.append(", ");
		}
		if (loanReason != null) {
			builder.append("loanReason=");
			builder.append(loanReason);
			builder.append(", ");
		}
		builder.append("loanTerm=");
		builder.append(loanTerm);
		builder.append(", personalCapitalContribution=");
		builder.append(personalCapitalContribution);
		builder.append(", ");
		if (residenceType != null) {
			builder.append("residenceType=");
			builder.append(residenceType);
			builder.append(", ");
		}
		if (risk != null) {
			builder.append("risk=");
			builder.append(risk);
			builder.append(", ");
		}
		if (settlementDate != null) {
			builder.append("settlementDate=");
			builder.append(settlementDate);
			builder.append(", ");
		}
		if (status != null) {
			builder.append("status=");
			builder.append(status);
			builder.append(", ");
		}
		builder.append("totalPurchasePrice=");
		builder.append(totalPurchasePrice);
		builder.append(", ");
		if (updatedBy != null) {
			builder.append("updatedBy=");
			builder.append(updatedBy);
			builder.append(", ");
		}
		if (updatedByRole != null) {
			builder.append("updatedByRole=");
			builder.append(updatedByRole);
			builder.append(", ");
		}
		if (updatedDate != null) {
			builder.append("updatedDate=");
			builder.append(updatedDate);
			builder.append(", ");
		}
		
		builder.append("accessSensitiveData=");
		builder.append(accessSensitiveData);
		
		builder.append("]");
		return builder.toString();
	}

	public String getEstateLocation() {
		return estateLocation;
	}

	public void setEstateLocation(String estateLocation) {
		this.estateLocation = estateLocation;
	}

	public Double getPersonalCapitalContribution() {
		return personalCapitalContribution;
	}

	public void setPersonalCapitalContribution(Double personalCapitalContribution) {
		this.personalCapitalContribution = personalCapitalContribution;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getUpdatedByRole() {
		return updatedByRole;
	}

	public void setUpdatedByRole(String updatedByRole) {
		this.updatedByRole = updatedByRole;
	}

	public LoanRisk getRisk() {
		return risk;
	}

	public void setRisk(LoanRisk risk) {
		this.risk = risk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isAccessSensitiveData() {
		return accessSensitiveData;
	}
	
	public boolean getAccessSensitiveData() {
		return accessSensitiveData;
	}
	
	public void setAccessSensitiveData(boolean accessSensitiveData) {
		this.accessSensitiveData = accessSensitiveData;
	}
}
