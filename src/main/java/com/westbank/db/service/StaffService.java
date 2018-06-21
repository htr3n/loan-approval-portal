package com.westbank.db.service;

import com.westbank.db.entity.Role;
import com.westbank.db.entity.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getAllStaffs();

    Staff getStaffById(String currentStaffId);

    List<Role> getAllRoles();

    Staff authenticateStaff(String id, String password);
}
