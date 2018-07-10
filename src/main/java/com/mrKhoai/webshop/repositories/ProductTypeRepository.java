package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, String> {

}
