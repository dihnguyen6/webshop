package com.mrKhoai.webshop.controller.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WebshopErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error-404";
    }

    @RequestMapping("/error-403")
    public String accessDenied() {
        return "error-403";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
