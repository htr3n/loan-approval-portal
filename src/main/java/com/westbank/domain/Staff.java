package com.westbank.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {

	private static final long serialVersionUID = 3307266703100699329L;

	@Id
	protected String staffId;

	@Basic
	protected String firstName;

	@Basic
	protected String lastName;

	@Basic
	protected String password;

	@ManyToMany(targetEntity = Role.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "staff_role", joinColumns = @JoinColumn(name = "staff_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
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
