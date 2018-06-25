package com.westbank.dao;

import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    private static Logger log = LoggerFactory.getLogger(StaffDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

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
        TypedQuery<Staff> query = entityManager.createQuery(
                "select s from Staff as s where s.staffId = :staffId and s.password=:password",
                Staff.class);
        query.setParameter("staffId", staffId);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public void deleteStaff(Staff staff) {
        if (staff != null) {
            deleteStaffById(staff.getStaffId());
        }
    }

    @Override
    public void deleteStaffById(String staffId) {
        Staff found = getStaffById(staffId);
        if (found != null) {
            entityManager.remove(found);
        }
    }

    @Override
    public List<Staff> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Staff> criteriaQuery = builder.createQuery(Staff.class);
        Root<Staff> root = criteriaQuery.from(Staff.class);
        criteriaQuery.select(root);
        TypedQuery<Staff> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Staff> result = typedQuery.getResultList();
        // lazy loading !!!
        result.forEach(staff -> staff.getRole().size());
        return result;
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
        return entityManager.find(Staff.class, staffId);
    }

    @Override
    public List<Staff> getStaffByRole(String roleId) {
        return getStaffByRole(new Role(roleId));
    }

    @Override
    public List<Staff> getStaffByRole(Role role) {
        List<Staff> staff = new ArrayList<>();
        if (role != null) {
            try {
                /* TODO
                staff = (List<Staff>) hibernateTemplate.findByNamedParam(
                        "select s from Staff as s where s.role=:role",
                        new String[]{"role"}, new Object[]{role});
                */
            } catch (DataAccessException e) {
                log.error("Cannot retrieve staff: " + e.getMessage());
            }
        }
        return staff;
    }

    @Override
    public void save(Staff staff) {
        if (staff != null) {
            entityManager.persist(staff);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        criteriaQuery.select(root);
        TypedQuery<Role> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}