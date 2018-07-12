package com.mrKhoai.webshop.controller.customer;

import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import com.mrKhoai.webshop.objects.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.FileFilter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    RoleService roleService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse reponse) {
        /*String name = request.getParameter("username").toLowerCase();
        String email = request.getParameter("email");*/

        URL fileUrl = getClass().getResource("/");
        String webappRoot = servletContext.getRealPath("/");
        //webappRoot = webappRoot.substring(0, webappRoot.length() - 1);
        LOGGER.info("Webapp Root Real Path: {}",fileUrl);
        LOGGER.info("Somthing {}", servletContext.getResourcePaths("/"));
        LOGGER.info("Test path: {} {} {}", request.getServletPath(), request.getLocale().getDisplayCountry(), request.getLocale().getDisplayLanguage());

        File actdir = new File(fileUrl.getFile() + "static/basis/images/carousel");

        if (!actdir.isDirectory()) {
            throw new IllegalArgumentException(actdir.getAbsolutePath());
        }

        File[] ls = null;

        ls = actdir.listFiles();

        LOGGER.info("Have {} files", ls.length);

        for (int i = 0; i < ls.length; i++) {
            LOGGER.info("File name: {}", ls[i].getAbsoluteFile());
        }

       /* Customer customer = new Customer();
        customer.setCustomerName(name);
        customerService.save(customer);*/

        /*try {
            request.login(customer.getCustomerName(), customer.getPassword());
        } catch (ServletException e) {
            LOGGER.info(e.getMessage());
        }*/

        return "redirect:/login";
    }
}
