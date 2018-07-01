package com.mrKhoai.webshop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    StaffService customerService;

    @PostMapping(path = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (customerService.containsCustomer(username)) {

        }
        return null;
    }
}
