package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Foto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

@Repository
public interface FotoRepository extends CrudRepository<Foto, String> {
}
