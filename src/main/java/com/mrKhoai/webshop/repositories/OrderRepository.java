package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
