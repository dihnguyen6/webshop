package com.mrKhoai.webshop.controller.color;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Color;
import com.mrKhoai.webshop.repositories.ColorRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService implements ObjectService<Color> {
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public void save(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void delete(Color color) {
        colorRepository.delete(color);
    }

    @Override
    public Color findById(String id) {
        return null;
    }

    @Override
    public Color findById(int id) {
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
    public String getAll() throws JsonProcessingException {
        return null;
    }
}
