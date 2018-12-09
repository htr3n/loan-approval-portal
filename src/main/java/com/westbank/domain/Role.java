package com.westbank.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = 6120261839537689155L;
	@Transient
	public static final String MANAGER = "Manager";
	@Transient
	public static final String SUPERVISOR = "Supervisor";
	@Transient
	public static final String POST_PROCESSING_CLERK = "Post Processing Clerk";
	@Transient
	public static final String CREDIT_BROKER = "Credit Broker";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	@Basic
	private String roleName;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "role", targetEntity = Staff.class, fetch = FetchType.LAZY)
	protected List<Staff> staff;

	public Role() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role(String role) {
		this.roleName = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void addStaff(Staff newStaff) {
		if (staff == null) {
			staff = new ArrayList<Staff>();
		}
		staff.add(newStaff);
	}

}
