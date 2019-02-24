package com.mrKhoai.webshop.controller.product;

import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
