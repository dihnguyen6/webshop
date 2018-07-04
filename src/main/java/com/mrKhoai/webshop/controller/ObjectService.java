package com.mrKhoai.webshop.controller;

import com.mrKhoai.webshop.objects.Staff;
import org.json.JSONArray;
import org.json.JSONException;

public interface ObjectService<T> {
    void save(T t);

    void delete(T t);

    T findById(String id);

    T findById(int id);

    boolean contains(String id);

    boolean contains(int id);

    JSONArray getAll() throws JSONException;
}
