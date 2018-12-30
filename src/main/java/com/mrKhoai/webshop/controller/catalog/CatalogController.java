package com.mrKhoai.webshop.controller.catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.objects.Catalog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class CatalogController {
    private static final Logger LOGGER = LogManager.getLogger(CatalogController.class);

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(path = "/admin/add_catalog", method = RequestMethod.POST)
    public Object addCatalogForm(@RequestBody String request) {
        LOGGER.debug(request);
        try {
            ObjectMapper mapper = new ObjectMapper();
            Catalog catalog = mapper.readValue(request, Catalog.class);
            catalogService.save(catalog);
        } catch (IOException e) {
            LOGGER.debug(e);
        }
        return "/admin/add_catalog?id=";
    }
}
