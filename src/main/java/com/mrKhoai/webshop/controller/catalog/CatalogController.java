package com.mrKhoai.webshop.controller.catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.objects.Catalog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CatalogController {
    private static final Logger LOGGER = LogManager.getLogger(CatalogController.class);

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/admin/add_catalog")
    public Object addCatalogForm(HttpServletRequest request) {
        try {
            JSONObject jsonObject = new JSONObject(request);
            ObjectMapper mapper = new ObjectMapper();
            Catalog catalog = mapper.readValue(request.toString(), Catalog.class);
            catalogService.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
