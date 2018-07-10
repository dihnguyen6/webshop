package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

}
