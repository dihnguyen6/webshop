package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.controller.staff.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class HttpSessionConfig {
    @Autowired
    private StaffService staffService;

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpSessionConfig.class);

    @Bean                           // bean for http session listener
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent se) {               // This method will be called when session created
                LOGGER.info("Session Created with session id: {}", se.getSession().getId());
            }

            @Override
            public void sessionDestroyed(HttpSessionEvent se) {         // This method will be automatically called when session destroyed
                LOGGER.info("Session Destroyed, Session id: {}", se.getSession().getId());
            }
        };
    }

    @Bean                   // bean for http session attribute listener
    public HttpSessionAttributeListener httpSessionAttributeListener() {
        return new HttpSessionAttributeListener() {
            @Override
            public void attributeAdded(HttpSessionBindingEvent se) {            // This method will be automatically called when session attribute added
                LOGGER.info("Attribute Added following information Attribute Name: {} Attribute Value: {}",
                        se.getName(), se.getValue());
            }

            @Override
            public void attributeRemoved(HttpSessionBindingEvent se) {      // This method will be automatically called when session attribute removed
                LOGGER.info("attributeRemoved");
            }

            @Override
            public void attributeReplaced(HttpSessionBindingEvent se) {     // This method will be automatically called when session attribute replace
                LOGGER.info("Attribute Replaced following information Attribute Name: {} Attribute Value: {}",
                        se.getName(), se.getValue());
            }
        };
    }
}
