package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {

}
