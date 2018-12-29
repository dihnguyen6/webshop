package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, String> {

}
