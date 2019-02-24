package com.mrKhoai.webshop.controller.foto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Foto;
import com.mrKhoai.webshop.repositories.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService implements ObjectService<Foto> {
    @Autowired
    FotoRepository fotoRepository;

    @Override
    public void save(Foto foto) {
        fotoRepository.save(foto);
    }

    @Override
    public void delete(Foto foto) {
        fotoRepository.delete(foto);
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
    public String getAll() throws JsonProcessingException {
        return null;
    }
}
