package com.westbank.service;

import com.westbank.domain.Role;
import com.westbank.domain.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> findAll();

    Staff getStaffById(String currentStaffId);

    List<Role> findAllRoles();

    Staff authenticateStaff(String id, String password);
}
