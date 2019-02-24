package com.mrKhoai.webshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ObjectService<T> {
    void save(T t);

    void delete(T t);

    T findById(String id);

    T findById(int id);

    boolean contains(String id);

    boolean contains(int id);

    String getAll() throws JsonProcessingException;
}
