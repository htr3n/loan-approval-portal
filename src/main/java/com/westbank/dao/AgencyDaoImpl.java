package com.westbank.dao;

import com.westbank.domain.Agency;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AgencyDaoImpl implements AgencyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Agency> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Agency> criteriaQuery = criteriaBuilder.createQuery(Agency.class);
        TypedQuery<Agency> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}