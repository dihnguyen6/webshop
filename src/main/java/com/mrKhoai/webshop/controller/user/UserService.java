package com.mrKhoai.webshop.controller.user;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.objects.Customer;
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
    private CustomerService customerService;

    /**
     * load User by ussername
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByName(username);
        if(customer == null) {
            throw new UsernameNotFoundException(WebshopConst.USER_NOT_FOUND);
        }
        UserBuilder builder = User.withUsername(customer.getCustomerName());
        builder.password(customer.getPassword());
        if(username.equalsIgnoreCase(WebshopConst.ADMIN)) {
            builder.authorities(WebshopConst.ADMIN, WebshopConst.USER);
        } else {
            builder.authorities(WebshopConst.USER);
        }
        return builder.build();
    }
}
