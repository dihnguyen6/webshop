package com.mrKhoai.webshop.controller.foto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Foto;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class FotoService implements ObjectService<Foto> {
    @Override
    public void save(Foto foto) {

    }

    @Override
    public void delete(Foto foto) {

    }

    @Override
    public Foto findById(String id) {
        return null;
    }

    @Override
    public Foto findById(int id) {
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
