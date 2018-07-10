package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
