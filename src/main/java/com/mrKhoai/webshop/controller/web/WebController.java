package com.mrKhoai.webshop.controller.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.customer.CustomerService;
import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

@Controller
public class WebController {

    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    RoleService roleService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) throws IOException {
        URL fileUrl = getClass().getResource("/");
        String [] carousel = new String[3];
        File actdir = new File(System.getProperty("user.home"), "/carousel");

        if (!actdir.isDirectory()) {
            throw new IllegalArgumentException(actdir.getAbsolutePath());
        }

        File[] ls = actdir.listFiles();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ls.length; i++) {
            FileInputStream istream = new FileInputStream(ls[i]);
            byte [] fileContent = new byte[(int) ls[i].length()];
            istream.read(fileContent);
            istream.close();
            //carousel[i] = Base64.getEncoder().encodeToString(fileContent);
            builder.append("<div id=\"c1\" class=\"item-slick1 item1-slick1\""
                    + " style=\"background-image: url(data:image/jpeg;base64,"
                    + Base64.getEncoder().encodeToString(fileContent)
                    + ");\">" +
                    "<div class=\"wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170\">" +
                    "<h2 class=\"caption2-slide1 xl-text1 t-center"
                    + " animated visible-false m-b-37\" data-appear=\"fadeInUp\">" +
                    "New arrivals </h2>\n" +
                    "<div class=\"wrap-btn-slide1 w-size1 animated visible-false\" data-appear=\"zoomIn\">" +
                    "<a href=\"product.html\" class=\"flex-c-m size2 bo-rad-23 s-text2 bgwhite hov1 trans-0-4\">" +
                    "Shop Now</a></div></div></div>");
        }
        model.addAttribute("carousel1", carousel[0]);
        model.addAttribute("carousel2", carousel[1]);
        model.addAttribute("carousel3", carousel[2]);
        model.addAttribute("carousel", builder.toString());
        return "anonymous/home";
    }

    @GetMapping("/about")
    public String about() {
        return "anonymous/about";
    }

    @GetMapping("/cart")
    public String cart() {
        return "anonymous/cart";
    }

    @GetMapping("/product-detail")
    public String product_detail() {
        return "anonymous/product-detail";
    }

    @GetMapping("/")
    public String landing() {
        return "redirect:/home";
    }

    @GetMapping("/product")
    public String product() {
        return "anonymous/product";
    }

    @GetMapping("/web-dev")
    public String devPage(Model model) throws JsonProcessingException {
        model.addAttribute("userList", customerService.getAll().toString());
        model.addAttribute("staffList", staffService.getAll().toString());
        model.addAttribute("roleList", roleService.getAll().toString());
        return "web-dev/web-dev";
    }

    @RequestMapping("/admin")
    public String adminLogin(Model model, @RequestParam(value = "error", defaultValue = "none", required = false) String request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Check if it isn't an authenticated user
        if (authentication instanceof AnonymousAuthenticationToken || authentication == null || !authentication.isAuthenticated()) {
            if (request.equals("none")) {
                model.addAttribute("message", "Welcome back my admin!");
                model.addAttribute("messColor", "green");
            } else if (request.equals("loginError")) {
                model.addAttribute("message", "Wrong username or password!");
                model.addAttribute("messColor", "red");
            }
            return "admin/loginAdmin";
        } else {
            LOGGER.info(authentication.getName());
            return "redirect:/admin/management";
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
}
