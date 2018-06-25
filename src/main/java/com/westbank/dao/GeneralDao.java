package com.westbank.dao;

public interface GeneralDao<T> {
    public void create(T entity);

    public void retrieve(T entity);

    public void update(T entity);

    public void delete(T entity);
}
