package com.westbank.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 3779259571576400833L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long customerId;

	@Temporal(TemporalType.DATE)
	protected Date dateOfBirth;

	@Basic
	protected String email;

	@Basic
	protected String firstName;

	@Basic
	protected double income;

	@Basic
	protected String lastName;

	@Basic
	protected int lengthOfService;

	@OneToMany(targetEntity = LoanFile.class, mappedBy = "borrower", fetch = FetchType.EAGER)
	protected List<LoanFile> loans;

	@Enumerated(EnumType.STRING)
	protected MaritalStatus maritalStatus;

	@Basic
	protected String mobilePhone;

	@Basic
	protected int numberOfChildren;

	@Basic
	protected String occupation;

	@Basic
	protected String personalId;

	@Basic
	protected String phone;

	@Basic
	protected String pin;

	@Basic
	protected String title;

	@Embedded
	Address address;

	public Customer() {
	}

	public Customer(Long customerId) {
		this.customerId = customerId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getIncome() {
		return income;
	}

	public String getLastName() {
		return lastName;
	}

	public int getLengthOfService() {
		return lengthOfService;
	}

	public List<LoanFile> getLoans() {
		return loans;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getOccupation() {
		return occupation;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getPhone() {
		return phone;
	}

	public String getPin() {
		return pin;
	}

	public String getTitle() {
		return title;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLengthOfService(int lengthOfService) {
		this.lengthOfService = lengthOfService;
	}

	public void setLoans(List<LoanFile> loans) {
		this.loans = loans;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [");
		if (address != null) {
			builder.append("address=").append(address).append(", ");
		}
		if (customerId != null) {
			builder.append("customerId=").append(customerId).append(", ");
		}
		if (dateOfBirth != null) {
			builder.append("dateOfBirth=").append(dateOfBirth).append(", ");
		}
		if (email != null) {
			builder.append("email=").append(email).append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=").append(firstName).append(", ");
		}
		builder.append("income=").append(income).append(", ");
		if (lastName != null) {
			builder.append("lastName=").append(lastName).append(", ");
		}
		builder.append("lengthOfService=").append(lengthOfService).append(", ");
		if (maritalStatus != null) {
			builder.append("maritalStatus=").append(maritalStatus).append(", ");
		}
		if (mobilePhone != null) {
			builder.append("mobilePhone=").append(mobilePhone).append(", ");
		}
		builder.append("numberOfChildren=").append(numberOfChildren).append(
				", ");
		if (occupation != null) {
			builder.append("occupation=").append(occupation).append(", ");
		}
		if (personalId != null) {
			builder.append("personalId=").append(personalId).append(", ");
		}
		if (phone != null) {
			builder.append("phone=").append(phone).append(", ");
		}
		if (pin != null) {
			builder.append("pin=").append(pin).append(", ");
		}
		if (title != null) {
			builder.append("title=").append(title);
		}
		builder.append("]");
		return builder.toString();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

}
