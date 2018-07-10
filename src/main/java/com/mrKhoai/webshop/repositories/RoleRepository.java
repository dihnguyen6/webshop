package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

}
