package com.westbank.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agency")
public class Agency {

	public static final String BANK = "WestBank";
	public static final String NAME = "WestBank Agency";
	public static final String ID = "WSTN-021";
	public static final String STREET = "123 Queen Street";
	public static final String ZIPCODE = "3001";
	public static final String CITY = "Melbourne";
	public static final String STATE = "Victoria";
	public static final String COUNTRY = "Australia";

	@Id
	protected String agencyCode;

	@Basic
	protected String bankName;

	protected String city;

	protected String country;

	protected String state;

	protected String street;

	protected String zipcode;

	public Agency() {
		this.agencyCode = ID;
		this.bankName = BANK;
		this.agencyCode = NAME;
		this.street = STREET;
		this.zipcode = ZIPCODE;
		this.city = CITY;
		this.state = STATE;
		this.country = COUNTRY;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyName) {
		this.agencyCode = agencyName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agency [agencyCode=").append(agencyCode).append(", bankName=").append(bankName)
				.append(", city=").append(city).append(", country=").append(country).append(", state=").append(state)
				.append(", street=").append(street).append(", zipcode=").append(zipcode).append("]");
		return builder.toString();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
