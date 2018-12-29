package com.mrKhoai.webshop.controller.catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.objects.Catalog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
            e.printStackTrace();
        }
        return true;
    }
}
