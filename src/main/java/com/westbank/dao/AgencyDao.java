package com.westbank.dao;

import com.westbank.domain.Agency;

import java.util.List;

public interface AgencyDao {
    List<Agency> findAll();
}
