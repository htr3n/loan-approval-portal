package com.westbank.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 3779259571576400833L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long customerId;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Basic
	private String email;

	@Basic
	private String firstName;

	@Basic
	private Double income;

	@Basic
	private String lastName;

	@Basic
	private Integer lengthOfService;

	@OneToMany(targetEntity = LoanFile.class, mappedBy = "borrower", fetch = FetchType.LAZY)
	private List<LoanFile> loans;

	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	@Basic
	private String mobilePhone;

	@Basic
	private Integer numberOfChildren;

	@Basic
	private String occupation;

	@Basic
	private String personalId;

	@Basic
	private String phone;

	@Basic
	private String pin;

	@Basic
	private String title;

	@Embedded
	private Address address;

	public Customer() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getLengthOfService() {
		return lengthOfService;
	}

	public void setLengthOfService(Integer lengthOfService) {
		this.lengthOfService = lengthOfService;
	}

	public List<LoanFile> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanFile> loans) {
		this.loans = loans;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(Integer numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId=" + customerId +
				", dateOfBirth=" + dateOfBirth +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", income=" + income +
				", lastName='" + lastName + '\'' +
				", lengthOfService=" + lengthOfService +
				", loans=" + loans +
				", maritalStatus=" + maritalStatus +
				", mobilePhone='" + mobilePhone + '\'' +
				", numberOfChildren=" + numberOfChildren +
				", occupation='" + occupation + '\'' +
				", personalId='" + personalId + '\'' +
				", phone='" + phone + '\'' +
				", pin='" + pin + '\'' +
				", title='" + title + '\'' +
				", address=" + address +
				'}';
	}
}
