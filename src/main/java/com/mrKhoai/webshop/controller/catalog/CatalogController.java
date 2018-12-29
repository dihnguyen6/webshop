package com.mrKhoai.webshop.controller.catalog;

import com.mrKhoai.webshop.objects.Catalog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/catalog")
public class CatalogController {
    private static final Logger LOGGER = LogManager.getLogger(CatalogController.class);

    /*@GetMapping("/admin/catalog")
    public String addCatalogForm(Model model) {
        model.addAttribute("catalog", new Catalog());
        return "admin/catalog";
    }*/
}
