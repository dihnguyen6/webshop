package com.mrKhoai.webshop.controller;

import com.mrKhoai.webshop.controller.color.ColorService;
import com.mrKhoai.webshop.objects.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TestController {
    private static final Logger LOGGER = LogManager.getLogger(TestController.class);

    @Autowired
    private ColorService colorService;
    @RequestMapping(path = "/admin/test", method = RequestMethod.POST)
    public Object test() {


        Color color = new Color("red");
        colorService.save(color);
        color = new Color("black");
        colorService.save(color);
        color = new Color("blue");
        colorService.save(color);
        color = new Color("green");
        colorService.save(color);


        return "/admin/test";
    }
}
