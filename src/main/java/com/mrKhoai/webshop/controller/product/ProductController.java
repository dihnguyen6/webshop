package com.mrKhoai.webshop.controller.product;

import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    //private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

    @PostMapping("/add")
    public void addProduct(@RequestParam(name = "name") String name) {
        Product prod = new Product();
        prod.setProductName(name);
        productRepository.save(prod);
        //LOGGER.info("request add {}", prod);
    }
}
