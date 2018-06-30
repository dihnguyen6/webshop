package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.objects.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (customerService.containsCustomer(username)) {

        }
        return null;
    }

    public Customer getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Check if it isn't an authenticated user
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        String currentUserName = authentication.getName();
        return customerService.findCustomerByName(currentUserName);
    }
}
