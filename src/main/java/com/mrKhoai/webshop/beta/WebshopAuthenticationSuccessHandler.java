package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.controller.WebshopConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class WebshopAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebshopAuthenticationSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
            if (authority.getAuthority().equals(WebshopConst.ROLE_CUSTOMER)) {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/home");
                } catch (Exception e) {
                    LOGGER.debug(e.getMessage());
                }
            } else if (authority.getAuthority().equals(WebshopConst.ROLE + WebshopConst.WEB_DEV)) {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/web-dev");
                } catch (Exception e) {
                    LOGGER.debug(e.getMessage());
                }
            } else {
                throw new IllegalStateException();
            }
        });
    }
}
