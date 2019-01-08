package com.mrKhoai.webshop.controller.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.repositories.ProductRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
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
        JSONArray jsonArray = new JSONArray();
        Iterator<Product> userList = productRepository.findAll().iterator();
        while (userList.hasNext()) {
            Product product = userList.next();
            ObjectMapper mapper = new ObjectMapper();
            jsonArray.put(mapper.writeValueAsString(product));
        }
        return jsonArray;
    }
}
