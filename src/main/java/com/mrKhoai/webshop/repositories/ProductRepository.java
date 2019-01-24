package com.mrKhoai.webshop.repositories;

import com.mrKhoai.webshop.objects.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    @Query(
            value = "SELECT * FROM Product",
            nativeQuery = true
    )
    List<Product> getAll();

    @Query(
            value = "SELECT p FROM Product p WHERE p.product_id IN " +
                    "(SELECT product_id FROM product_product_type WHERE product_type_id IN " +
                    "(SELECT product_type_id FROM catalog_product_type WHERE catalog_id = :id))",
            nativeQuery = true
    )
    List<Product> getByCatalog(@Param("id") String calatogId);

    @Query(
            value = "SELECT p FROM Product p WHERE p.product_id IN " +
                    "(SELECT product_id FROM product_product_type WHERE product_type_id = :id)",
            nativeQuery = true
    )
    List<Product> getByProductType(@Param("id") String ptId);

    @Query(
            value = "SELECT p FROM Product p WHERE MATCH " +
                    "(product_name_en, product_description_en, product_name_de, product_description_de) " +
                    "AGAINST (:search IN NATURAL LANGUAGE MODE)",
            nativeQuery = true
    )
    List<Product> searchProduct(@Param("search") String searchString);

    @Query(
            value = "SELECT COUNT(product_id) FROM Product",
            nativeQuery = true
    )
    int getCountAll();

    @Query(
            value = "SELECT COUNT(product_id) FROM Product p WHERE p.product_id IN " +
                    "(SELECT product_id FROM product_product_type WHERE product_type_id IN " +
                    "(SELECT product_type_id FROM catalog_product_type WHERE catalog_id = :id))",
            nativeQuery = true
    )
    int getCountCatalog();

    @Query(
            value = "SELECT COUNT(product_id) FROM Product p WHERE p.product_id IN " +
                    "(SELECT product_id FROM product_product_type WHERE product_type_id = :id)",
            nativeQuery = true
    )
    int getCountProductType();

    @Query(
            value = "SELECT COUNT(product_id) FROM basket_product WHERE p.product_id=:id",
            nativeQuery = true
    )
    int countSell(@Param("id") String id);
}
