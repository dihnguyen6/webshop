package com.mrKhoai.webshop.controller.product_type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.ProductType;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements ObjectService<ProductType> {
    @Override
    public void save(ProductType productType) {

    }

    @Override
    public void delete(ProductType productType) {

    }

    @Override
    public ProductType findById(String id) {
        return null;
    }

    @Override
    public ProductType findById(int id) {
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
    public String getAll() throws JsonProcessingException {
        return null;
    }
}
