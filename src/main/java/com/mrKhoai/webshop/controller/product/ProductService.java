package com.mrKhoai.webshop.controller.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.repositories.ProductRepository;
import com.mrKhoai.webshop.repositories.ProductTypeRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService implements ObjectService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public boolean contains(int id) {
        return false;
    }

    @Override
    public JSONArray getAll() throws JsonProcessingException {
        return null;
    }
}
