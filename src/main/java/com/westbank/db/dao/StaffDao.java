package com.westbank.db.dao;

import com.westbank.db.entity.Role;
import com.westbank.db.entity.Staff;

import java.util.List;

public interface StaffDao {
    Staff authenticateStaff(String staffId, String password);

    void deleteStaff(Staff staff);

    void deleteStaff(String staffId);

    List<Staff> getAllStaffs();

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
