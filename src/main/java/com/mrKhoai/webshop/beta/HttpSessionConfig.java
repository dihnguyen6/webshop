package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.controller.user.StaffService;
import com.mrKhoai.webshop.objects.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class HttpSessionConfig {
    @Autowired
    private StaffService staffService;

    @Bean                           // bean for http session listener
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent se) {               // This method will be called when session created
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                Staff staff = staffService.findCustomerByName(auth.getName());
                if (!staff.getRole().getRoleName().equals(WebshopConst.CUSTOMER)) {
                    se.getSession().setMaxInactiveInterval(9000);
                }
                System.out.println("Session Created with session id+" + se.getSession().getId());
            }
            @Override
            public void sessionDestroyed(HttpSessionEvent se) {         // This method will be automatically called when session destroyed
                System.out.println("Session Destroyed, Session id:" + se.getSession().getId());
            }
        };
    }
    @Bean                   // bean for http session attribute listener
    public HttpSessionAttributeListener httpSessionAttributeListener() {
        return new HttpSessionAttributeListener() {
            @Override
            public void attributeAdded(HttpSessionBindingEvent se) {            // This method will be automatically called when session attribute added
                System.out.println("Attribute Added following information");
                System.out.println("Attribute Name:" + se.getName());
                System.out.println("Attribute Value:" + se.getName());
            }
            @Override
            public void attributeRemoved(HttpSessionBindingEvent se) {      // This method will be automatically called when session attribute removed
                System.out.println("attributeRemoved");
            }
            @Override
            public void attributeReplaced(HttpSessionBindingEvent se) {     // This method will be automatically called when session attribute replace
                System.out.println("Attribute Replaced following information");
                System.out.println("Attribute Name:" + se.getName());
                System.out.println("Attribute Old Value:" + se.getValue());
            }
        };
    }
}
