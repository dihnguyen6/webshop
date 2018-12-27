package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Foto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends CrudRepository<Foto, MediaType> {
}
