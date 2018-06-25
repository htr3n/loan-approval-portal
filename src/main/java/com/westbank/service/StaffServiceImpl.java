package com.westbank.service;

import com.westbank.dao.StaffDao;
import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao;

    @Autowired
    public StaffServiceImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Staff getStaffById(String staffId) {
        return staffDao.getStaffById(staffId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAllRoles() {
        return staffDao.getAllRoles();
    }

    @Override
    @Transactional(readOnly = true)
    public Staff authenticateStaff(String id, String password) {
        return staffDao.authenticateStaff(id, password);
    }
}
