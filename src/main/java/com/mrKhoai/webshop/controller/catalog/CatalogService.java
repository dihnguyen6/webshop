package com.mrKhoai.webshop.controller.catalog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Catalog;
import com.mrKhoai.webshop.repositories.CatalogRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService implements ObjectService<Catalog> {

    @Autowired
    private CatalogRepository catalog;

    @Override
    public void save(Catalog catalog) {

    }

    @Override
    public void delete(Catalog catalog) {

    }

    @Override
    public Catalog findById(String id) {
        return null;
    }

    @Override
    public Catalog findById(int id) {
        return null;
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public boolean contains(int id) {
        return false;
    }

    @Override
    public JSONArray getAll() throws JsonProcessingException {
        return null;
    }
}
