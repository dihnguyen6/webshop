package com.mrKhoai.webshop.offcial;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.controller.customer.CustomerService;
import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    @Autowired
    private StaffService staffService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CustomerService customerService;

    /**
     * load User by ussername
     *
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equalsIgnoreCase("admin")) {
            throw new UsernameNotFoundException(WebshopConst.USER_NOT_FOUND);
        }
        User.UserBuilder builder = User.withUsername(username);
        builder.password(new BCryptPasswordEncoder().encode("admin"));
        String role = "ADMIN";
        builder.authorities(WebshopConst.ROLE + role);
        return builder.build();
        /*username = username.toLowerCase();
        Staff staff = staffService.findByName(username);
        if(staff == null) {
            Customer customer = customerService.findByName(username);
            if (customer == null) {
                UserBuilder builder = User.withUsername(customer.getCvName());
                builder.password(customer.getPassword());
                builder.authorities(WebshopConst.ROLE_CUSTOMER);
                return builder.build();
            } else {
                throw new UsernameNotFoundException(WebshopConst.USER_NOT_FOUND);
            }
        } else {
            UserBuilder builder = User.withUsername(staff.getStaffName());
            builder.password(staff.getPassword());
            String role = staff.getRole().getRoleName().toUpperCase();
            builder.authorities(WebshopConst.ROLE + role);
            return builder.build();
        }*/
        //return null;
    }
}
