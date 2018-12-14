package com.mrKhoai.webshop.controller.product;

import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add")
    public void addProduct(@RequestParam(name = "name") String name) {
        Product prod = new Product();
        prod.setProductNameEN(name);
        productRepository.save(prod);
    }

    @RequestMapping(value = "/edit-car", method = RequestMethod.POST)
    public void getInformation(@RequestPart("file") MultipartFile request,
                               @RequestParam(name = "index") String index) throws IOException {
        File folder = new File(System.getProperty("user.home"), "/carousel");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(System.getProperty("user.home"), "/carousel/carousel" + index);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream ostream = new FileOutputStream(file);
        ostream.write(request.getBytes());
        ostream.flush();
        ostream.close();
    }
}
