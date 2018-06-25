package com.westbank.dao;

import com.westbank.domain.Role;
import com.westbank.domain.Staff;

import java.util.List;

public interface StaffDao {
    Staff authenticateStaff(String staffId, String password);

    void deleteStaff(Staff staff);

    void deleteStaffById(String staffId);

    List<Staff> findAll();

    List<Staff> getCreditBrokers();

    List<Staff> getManagers();

    List<Staff> getPostProcessingClerks();

    List<Staff> getSupervisors();

    Staff getStaffById(String staffId);

    List<Staff> getStaffByRole(String role);

    List<Staff> getStaffByRole(Role role);

    void save(Staff staff);

    List<Role> getAllRoles();
}
