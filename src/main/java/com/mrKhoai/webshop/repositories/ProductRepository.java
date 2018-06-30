package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
