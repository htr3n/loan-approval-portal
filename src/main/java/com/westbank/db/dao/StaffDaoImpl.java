package com.westbank.db.dao;

import com.westbank.db.entity.Role;
import com.westbank.db.entity.Staff;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;


public class StaffDaoImpl implements StaffDao {

    private static Logger log = LoggerFactory.getLogger(StaffDaoImpl.class);

    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /**
     * Authenticates a {@link Staff} based on his ID and password
     *
     * @param staffId  -- the staff's ID
     * @param password -- the staff's password
     * @return the corresponding {@link Staff} if successful, otherwise
     * <code>null</code>
     */
    @Override
    public Staff authenticateStaff(String staffId, String password) {
        Staff result = null;
        try {
            final List staff = hibernateTemplate
                    .findByNamedParam(
                            "select s from Staff as s where s.staffId=:staffId and s.password=:password",
                            new String[]{"staffId", "password"},
                            new Object[]{staffId, password});
            if (staff != null && staff.size() == 1) {
                result = (Staff) staff.get(0);
            }
        } catch (Exception e) {
            log.error("Cannot authenticate staff: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void deleteStaff(Staff staff) {
        if (staff != null) {
            try {
                hibernateTemplate.delete(staff);
            } catch (DataAccessException e) {
                log.error("Cannot delete the staff: " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteStaff(String staffId) {
        if (staffId != null) {
            final Staff staff = new Staff();
            staff.setStaffId(staffId);
            deleteStaff(staff);
        }
    }

    @Override
    public List<Staff> getAllStaffs() {
        return hibernateTemplate.loadAll(Staff.class);
    }

    @Override
    public List<Staff> getCreditBrokers() {
        return getStaffByRole(Role.CREDIT_BROKER);
    }

    @Override
    public List<Staff> getManagers() {
        return getStaffByRole(Role.MANAGER);
    }

    @Override
    public List<Staff> getPostProcessingClerks() {
        return getStaffByRole(Role.POST_PROCESSING_CLERK);
    }

    @Override
    public List<Staff> getSupervisors() {
        return getStaffByRole(Role.SUPERVISOR);
    }

    @Override
    public Staff getStaffById(String staffId) {
        Staff staff = null;
        if (staffId != null) {
            try {
                staff = hibernateTemplate.get(Staff.class, staffId);
            } catch (Exception e) {
                log.error("Cannot get the staff: " + e.getMessage());
            }
        }
        return staff;
    }

    @Override
    public List<Staff> getStaffByRole(String role) {
        return getStaffByRole(new Role(role));
    }

    @Override
    public List<Staff> getStaffByRole(Role role) {
        List<Staff> staff = new ArrayList<Staff>();
        if (role != null) {
            try {
                staff = (List<Staff>) hibernateTemplate.findByNamedParam(
                        "select s from Staff as s where s.role=:role",
                        new String[]{"role"}, new Object[]{role});
            } catch (DataAccessException e) {
                log.error("Cannot retrieve staff: " + e.getMessage());
            }
        }
        return staff;
    }

    @Override
    public void save(Staff staff) {
        if (staff != null) {
            hibernateTemplate.saveOrUpdate(staff);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        final List<Role> listOfRoles = hibernateTemplate.loadAll(
                Role.class);
        return listOfRoles;
    }
}