package com.westbank.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbstractRepository<T, ID extends Serializable> implements BaseRepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    // https://developer.jboss.org/wiki/GenericDataAccessObjects
    // http://blog.xebia.com/acessing-generic-types-at-runtime-in-java
    private Class<T> persistentClass;

    public AbstractRepository() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public <S extends T> S create(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(getPersistentClass(), id));
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getPersistentClass());
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void deleteById(ID id) {
        Optional<T> found = findById(id);
        if (found.isPresent())
            entityManager.remove(found);
    }

    @Override
    public abstract void delete(T entity);

}
