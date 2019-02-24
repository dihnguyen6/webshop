package com.mrKhoai.webshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    @Value("${werbung.msg:test}")
    private String message = "Werbung";

    @GetMapping("/footer")
    public String getFooter() {
        return "fragments/footer";
    }

    @GetMapping("/headerfiles")
    public String getHeaderFiles() {
        return "fragments/headerfiles";
    }

    @GetMapping("/navbar")
    public String getNavbar(Model model) {
        model.addAttribute("msg", this.message);
        return "fragments/navbar";
    }

    @GetMapping("/headerfiles-admin")
    public String getHeaderFilesAdmin() {
        return "fragments/headerfiles-admin";
    }

    @GetMapping("/navbar-admin")
    public String getNavbarAdmin() {
        return "fragments/navbar-admin";
    }

    @GetMapping("/footer-admin")
    public String getFooterAdmin() {
        return "fragments/footer-admin";
    }

    @GetMapping("/sidebar-admin")
    public String getSidebarAdmin() {
        return "fragments/footer-admin";
    }
}
