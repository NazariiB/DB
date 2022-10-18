package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface GeneralSer<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
