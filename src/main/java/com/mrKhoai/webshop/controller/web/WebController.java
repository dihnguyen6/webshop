package com.mrKhoai.webshop.controller.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.customer.CustomerService;
import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        //File actdir = new File(fileUrl.getFile() + "static/basis/images/carousel");
        File actdir = new File(System.getProperty("user.home"), "/carousel");

        if (!actdir.isDirectory()) {
            throw new IllegalArgumentException(actdir.getAbsolutePath());
        }

        File[] ls = null;

        ls = actdir.listFiles();

        LOGGER.info("Have {} files", ls.length);

        for (int i = 0; i < 3; i++) {
            LOGGER.info("File name: {}", ls[i].getAbsoluteFile());
            FileInputStream istream = new FileInputStream(ls[i]);
            byte [] fileContent = new byte[(int) ls[i].length()];
            istream.read(fileContent);
            istream.close();
            carousel[i] = Base64.getEncoder().encodeToString(fileContent);
        }
        model.addAttribute("carousel1", carousel[0]);
        model.addAttribute("carousel2", carousel[1]);
        model.addAttribute("carousel3", carousel[2]);
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

    @GetMapping("/admin**")
    public String adminLogin(Model model) {

        return "admin/loginAdmin";
    }

    @GetMapping("/admin/management")
    public String adminPage(Model model) {

        return "admin/index";
    }

    @GetMapping("edit-carousel")
    public String editCarousel() {
        return "anonymous/edit-carousel";
    }
}
