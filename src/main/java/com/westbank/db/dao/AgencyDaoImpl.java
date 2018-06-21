package com.westbank.db.dao;

import com.westbank.db.entity.Agency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AgencyDaoImpl implements AgencyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Agency> getAllAgencies() {
        Session session = sessionFactory.getCurrentSession();
        //return getHibernateTemplate().loadAll(Agency.class);
        return new ArrayList<>();
    }
}