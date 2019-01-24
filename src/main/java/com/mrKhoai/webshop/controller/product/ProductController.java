package com.mrKhoai.webshop.controller.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;



    @PostMapping("/add")
    public void addProduct(@RequestParam(name = "name") String name) {
        Product prod = new Product();
        prod.setProductNameEN(name);
        productRepository.save(prod);
    }
}
