package com.mrKhoai.webshop.controller.customer;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import com.mrKhoai.webshop.objects.Customer;
import com.mrKhoai.webshop.objects.Role;
import com.mrKhoai.webshop.objects.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    RoleService roleService;

    /*@Autowired
    protected AuthenticationManager authenticationManager;*/

    @PostMapping("/register")
    public String register(HttpServletRequest request) {
        String name = request.getParameter("username");
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String repeatPassword = request.getParameter("repeat-pass");

        if (!roleService.contains(WebshopConst.WEB_DEV)) {
            Role role = new Role();
            role.setRoleName(WebshopConst.WEB_DEV);
            roleService.save(role);
        }

        if (name.equals("dnguyen6")) {
            Staff staff = new Staff();
            staff.setStaffName(name);
            staff.setStaffFullName(fullName);
            staff.setEmail(email);
            staff.setPassword(new BCryptPasswordEncoder().encode(password));
            staff.setRole(roleService.findByName(WebshopConst.WEB_DEV));
            staffService.save(staff);
        } else {
            Customer customer = new Customer();
            customer.setCustomerName(name);
            customer.setCustomerFullName(fullName);
            customer.setEmail(email);
            customer.setPassword(new BCryptPasswordEncoder().encode(password));
            customerService.save(customer);
        }

        return "redirect:/login/";
    }

    /*private void authenticateUserAndSetSession(Customer customer, HttpServletRequest request) {
        String username = customer.getCustomerName();
        String password = customer.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }*/
}
