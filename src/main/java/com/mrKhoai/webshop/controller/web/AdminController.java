package com.mrKhoai.webshop.controller.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.product.ProductService;
import com.mrKhoai.webshop.tools.WebshopConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller("/admin")
public class AdminController {

    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    ProductService productService;

    @RequestMapping("/admin")
    public String adminLogin(Model model, @RequestParam(value = "error", defaultValue = "none", required = false) String request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Check if it isn't an authenticated user
        if (authentication instanceof AnonymousAuthenticationToken || authentication == null || !authentication.isAuthenticated()) {
            if (request.equals("none")) {
                model.addAttribute("message", "Welcome back Admin!");
                model.addAttribute("messColor", "green");
            } else if (request.equals("loginError")) {
                model.addAttribute("message", "Access Denied");
                model.addAttribute("messColor", "red");
            }
            return "admin/loginAdmin";
        } else {
            if(authentication.getName().equalsIgnoreCase(WebshopConst.ADMIN)) {
                return "redirect:/admin/management";
            } else {
                return "admin/loginAdmin";
            }
        }
    }

    /*@RequestMapping("/admin/login")
    public String admin_login() {
        return "redirect:/admin/management";
    }*/

    @RequestMapping("/admin/management")
    public String adminPage(Model model) {
        return "admin/index";
    }

    @GetMapping("edit-carousel")
    public String editCarousel() {
        return "anonymous/edit-carousel";
    }

    @GetMapping("/admin/product")
    public String product(Model model) throws JsonProcessingException {
        model.addAttribute("productList", productService.getAll().toString());
        return "admin/product";
    }

    @RequestMapping("/admin/catalog")
    public String catalog(Model model) {
        return "admin/catalog";
    }

    @RequestMapping("/admin/demo")
    public String demo(Model model) {
        return "admin/demo";
    }

    @RequestMapping("/admin/test")
    public String test(Model model) {
        return "admin/test";
    }

}
