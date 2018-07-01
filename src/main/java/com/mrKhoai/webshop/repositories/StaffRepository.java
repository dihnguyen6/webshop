package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {

}
