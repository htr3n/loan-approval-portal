package com.westbank.db.service;

import com.westbank.db.dao.StaffDao;
import com.westbank.db.entity.Role;
import com.westbank.db.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao;

    public StaffServiceImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffDao.getAllStaffs();
    }

    @Override
    public Staff getStaffById(String staffId) {
        return staffDao.getStaffById(staffId);
    }

    @Override
    public List<Role> getAllRoles() {
        return staffDao.getAllRoles();
    }

    @Override
    public Staff authenticateStaff(String id, String password) {
        return staffDao.authenticateStaff(id, password);
    }
}
