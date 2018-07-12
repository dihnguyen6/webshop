package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Integer> {

}
