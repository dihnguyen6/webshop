package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {

}
