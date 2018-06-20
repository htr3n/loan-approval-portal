package com.westbank.db.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Staff implements Serializable {

	private static final long serialVersionUID = 3307266703100699329L;

	@Id
	@Column(length = 10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	protected String staffId;

	@Column(length = 30)
	protected String firstName;

	@Column(length = 30)
	protected String lastName;

	@Column(length = 10)
	protected String password;

	@ManyToMany(targetEntity = Role.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "STAFF_ROLE", joinColumns = @JoinColumn(name = "STAFF_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	protected List<Role> role;

	public Staff() {
	}

	public Staff(String staffId, String firstName, String lastName, String password, List<Role> role) {
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	public String getStaffId() {
		return staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public void addRole(Role newRole) {
		if (role == null) {
			role = new ArrayList<Role>();
		}
		role.add(newRole);
	}

	@Override
	public String toString() {
		return "Staff: " + staffId + ": " + firstName + " " + lastName + "; role=" + role;
	}

}
