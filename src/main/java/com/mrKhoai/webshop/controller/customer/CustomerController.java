package com.mrKhoai.webshop.controller.customer;

import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import com.mrKhoai.webshop.objects.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    RoleService roleService;

    @PostMapping("/register")
    public String register(HttpServletRequest request) {
        String name = request.getParameter("username").toLowerCase();
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String repeatPassword = request.getParameter("repeat-pass");

        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerFullName(fullName);
        customer.setEmail(email);
        customer.setPassword(new BCryptPasswordEncoder().encode(password));
        customerService.save(customer);

        /*try {
            request.login(customer.getCustomerName(), customer.getPassword());
        } catch (ServletException e) {
            LOGGER.info(e.getMessage());
        }*/

        return "redirect:/login";
    }
}
