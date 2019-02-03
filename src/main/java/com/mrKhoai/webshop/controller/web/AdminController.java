package com.mrKhoai.webshop.controller.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.product.ProductService;
import com.mrKhoai.webshop.objects.Carousel;
import com.mrKhoai.webshop.repositories.CarouselRepository;
import com.mrKhoai.webshop.tools.WebshopConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    ProductService productService;

    @Autowired
    private CarouselRepository carouselRepository;

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

    @RequestMapping("/admin/carousel")
    public String editCarousel(Model model) throws IOException {
        /*File actdir = new File(System.getProperty("user.home"), "/carousel");

        if (!actdir.isDirectory()) {
            throw new IllegalArgumentException(actdir.getAbsolutePath());
        }

        File[] ls = actdir.listFiles();

        int size = ls.length;
        JSONArray carList = new JSONArray();
        for (int i = 0; i < size; i++) {
            FileInputStream istream = new FileInputStream(ls[i]);
            byte[] fileContent = new byte[(int) ls[i].length()];
            istream.read(fileContent);
            istream.close();
            carList.put("data:image/jpeg;base64,"
                    + Base64.getEncoder().encodeToString(fileContent));
        }*/

        List<Carousel> carousels = carouselRepository.getAll();
        int size = carousels.size();
        JSONArray carList = new JSONArray();
        for (int i = 0; i < size; i++) {
            byte[] fileContent = carousels.get(i).getFoto();
            carList.put("data:image/jpeg;base64,"
                    + Base64.getEncoder().encodeToString(fileContent));
        }
        model.addAttribute("carouselList", carList.toString());
        return "admin/carousel";
    }

    @RequestMapping("/admin/product")
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

    @RequestMapping("/admin/email-inbox")
    public String mailInbox(Model model) {
        return "admin/email-inbox";
    }

}
