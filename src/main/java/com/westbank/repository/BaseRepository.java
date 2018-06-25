package com.westbank.repository;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;

public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <S extends T> S create(S entity);

    T update(T entity);

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    void deleteById(ID id);

    void delete(T entity);

    boolean existsById(ID primaryKey);

}
