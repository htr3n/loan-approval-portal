package westbank.db.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int roleId;

	@Basic
	protected String roleName;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "role", targetEntity = Staff.class)
	protected List<Staff> staff;

	public Role() {
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
