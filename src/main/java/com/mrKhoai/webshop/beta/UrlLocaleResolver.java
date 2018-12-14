package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.controller.WebshopConst;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UrlLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // ==> /SomeContextPath/en/...
        // ==> /SomeContextPath/fr/...
        // ==> /SomeContextPath/WEB-INF/pages/...
        String uri = request.getRequestURI();

        System.out.println("URI=" + uri);

        String prefixEn = request.getServletContext().getContextPath() + "/en/";
        String prefixDe = request.getServletContext().getContextPath() + "/de/";

        Locale locale = null;

        // English
        if (uri.startsWith(prefixEn)) {
            locale = Locale.ENGLISH;
        }
        // German
        else if (uri.startsWith(prefixDe)) {
            locale = Locale.GERMAN;
        }
        if (locale != null) {
            request.getSession().setAttribute(WebshopConst.URL_LOCALE_ATTRIBUTE_NAME, locale);
        }
        if (locale == null) {
            locale = (Locale) request.getSession().getAttribute(WebshopConst.URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                locale = Locale.GERMAN;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Nothing
    }

}
