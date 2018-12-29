package com.mrKhoai.webshop.controller.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mrKhoai.webshop.controller.WebshopConst;
import com.mrKhoai.webshop.controller.customer.CustomerService;
import com.mrKhoai.webshop.controller.role.RoleService;
import com.mrKhoai.webshop.controller.staff.StaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Locale;

@Controller
public class WebController {

    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    RoleService roleService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        return "redirect:/" + getLocale(request).getLanguage() + "/home";
    }

    @GetMapping("/{lang:en|de}/home")
    public String home(Model model, /*@RequestParam(name = "lang", required = true) String lang,*/
                       @PathVariable String lang, HttpServletResponse response) throws IOException {
        setLang(lang, response);
        String[] carousel = new String[3];
        File actdir = new File(System.getProperty("user.home"), "/carousel");

        if (!actdir.isDirectory()) {
            throw new IllegalArgumentException(actdir.getAbsolutePath());
        }

        File[] ls = actdir.listFiles();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ls.length; i++) {
            FileInputStream istream = new FileInputStream(ls[i]);
            byte[] fileContent = new byte[(int) ls[i].length()];
            istream.read(fileContent);
            istream.close();
            //carousel[i] = Base64.getEncoder().encodeToString(fileContent);
            builder.append("<div id=\"c1\" class=\"item-slick1 item1-slick1\""
                    + " style=\"background-image: url(data:image/jpeg;base64,"
                    + Base64.getEncoder().encodeToString(fileContent)
                    + ");\">" +
                    "<div class=\"wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170\">" +
                    "<h2 class=\"caption2-slide1 xl-text1 t-center"
                    + " animated visible-false m-b-37\" data-appear=\"fadeInUp\">" +
                    "New arrivals </h2>\n" +
                    "<div class=\"wrap-btn-slide1 w-size1 animated visible-false\" data-appear=\"zoomIn\">" +
                    "<a href=\"product.html\" class=\"flex-c-m size2 bo-rad-23 s-text2 bgwhite hov1 trans-0-4\">" +
                    "Shop Now</a></div></div></div>");
        }
        model.addAttribute("carousel1", carousel[0]);
        model.addAttribute("carousel2", carousel[1]);
        model.addAttribute("carousel3", carousel[2]);
        model.addAttribute("carousel", builder.toString());
        return "anonymous/home";
    }

    @GetMapping("/about")
    public String about() {
        return "anonymous/about";
    }

    @GetMapping("/cart")
    public String cart(HttpServletRequest request) {
        return "redirect:/" + getLocale(request).getLanguage() + "/cart";
    }

    @GetMapping("/{lang:en|de}/cart")
    public String redirectCart() {
        return "anonymous/cart";
    }

    @GetMapping("/product-detail")
    public String product_detail(HttpServletRequest request) {
        return "redirect:/" + getLocale(request).getLanguage() + "/product-detail";
    }

    @GetMapping("/{lang:en|de}/product-detail")
    public String redirectProductDetail() {
        return "anonymous/product-detail";
    }

    @RequestMapping("/")
    public String landing(HttpServletRequest request) {
        return "redirect:/" + getLocale(request).getLanguage() + "/home";
    }

    @GetMapping("/product")
    public String product(@RequestParam(name = "id") String id, HttpServletRequest request) {
        return "redirect:/" + getLocale(request).getLanguage() + "/product?id=" + id;
    }

    @GetMapping("/{lang:en|de}/product")
    public String redirectProduct() {
        return "anonymous/product";
    }

    @GetMapping("/web-dev")
    public String devPage(Model model) throws JsonProcessingException {
        model.addAttribute("userList", customerService.getAll().toString());
        model.addAttribute("staffList", staffService.getAll().toString());
        model.addAttribute("roleList", roleService.getAll().toString());
        return "web-dev/web-dev";
    }


    /**
     * Get pramater "lang" from cookie in request header
     *
     * @param request
     * @return
     */
    private String getLang(HttpServletRequest request) {
        String rawCookie = request.getHeader("Cookie");
        String[] rawCookieParams = rawCookie.split(";");
        for (String rawCookieNameAndValue : rawCookieParams) {
            String[] rawCookieNameAndValuePair = rawCookieNameAndValue.split("=");
            System.out.println(rawCookieNameAndValuePair[0] + " " + rawCookieNameAndValuePair[1]);
            if (rawCookieNameAndValuePair[0].trim().equals("locale")) {
                LOGGER.info(rawCookieNameAndValuePair[0] + ": " + rawCookieNameAndValuePair[1]);
                return rawCookieNameAndValuePair[1];
            }
        }
        return "de";
    }

    /**
     * Get attribute "lang" from Session
     *
     * @param request
     * @return
     */
    private Locale getLocale(HttpServletRequest request) {
        Locale locale = null;
        locale = (Locale) request.getSession().getAttribute(WebshopConst.URL_LOCALE_ATTRIBUTE_NAME);
        if (locale == null) {
            locale = Locale.GERMAN;
        }
        return locale;
    }

    /**
     * Update "lang" by response header
     *
     * @param lang
     * @param response
     */
    private void setLang(String lang, HttpServletResponse response) {
        Cookie myCookie = new Cookie("locale", lang);
        response.addCookie(myCookie);
    }
}
