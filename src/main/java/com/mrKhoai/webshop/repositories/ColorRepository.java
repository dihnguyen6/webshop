package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color, String> {

}
