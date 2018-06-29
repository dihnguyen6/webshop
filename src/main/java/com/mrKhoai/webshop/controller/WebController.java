package com.mrKhoai.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "MrKhoai");
        return "home-02";
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        return "product";
    }
}
