package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}
