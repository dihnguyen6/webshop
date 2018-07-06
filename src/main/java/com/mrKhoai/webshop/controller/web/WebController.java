package com.mrKhoai.webshop.controller.web;

import com.mrKhoai.webshop.controller.customer.CustomerService;
import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

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
    public String home() {
        return "anonymous/home-02";
    }

    @GetMapping("/product")
    public String product() {
        return "anonymous/product";
    }

    @GetMapping("/web-dev")
    public String devPage(Model model) throws JSONException {
        model.addAttribute("userList", customerService.getAll().toString());
        model.addAttribute("staffList", staffService.getAll().toString());
        model.addAttribute("roleList", roleService.getAll().toString());
        return "web-dev/web-dev";
    }
}
