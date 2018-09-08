package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.CV;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends CrudRepository<CV, Integer> {

}
