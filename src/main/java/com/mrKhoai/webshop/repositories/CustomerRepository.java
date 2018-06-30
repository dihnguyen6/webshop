package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Staff, String> {

}
