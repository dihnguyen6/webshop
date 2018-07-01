package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private StaffService customerService;

    /**
     * load User by ussername
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = customerService.findCustomerByName(username);
        if(staff == null) {
            throw new UsernameNotFoundException(WebshopConst.USER_NOT_FOUND);
        }
        UserBuilder builder = User.withUsername(staff.getStaffName());
        builder.password(staff.getPassword());
        if(username.equalsIgnoreCase(WebshopConst.ADMIN)) {
            builder.authorities(WebshopConst.ADMIN, WebshopConst.USER);
        } else {
            builder.authorities(WebshopConst.USER);
        }
        return builder.build();
    }
}
