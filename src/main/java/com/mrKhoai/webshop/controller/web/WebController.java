package com.mrKhoai.webshop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home-02";
    }

    @GetMapping("/product")
    public String product(){
        return "product";
    }
}
