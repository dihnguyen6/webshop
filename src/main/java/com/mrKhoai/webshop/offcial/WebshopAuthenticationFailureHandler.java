package com.mrKhoai.webshop.offcial;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class WebshopAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebshopAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("status", "failed");
            jsonObject.put("mess", "Access Denied. Wrong Username or Password !");
            jsonObject.put("mColor", "#BF3737");
            jsonObject.put("alert", "block");
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        WebshopAuthenticationSuccessHandler.sendResponse(httpServletResponse, jsonObject);
    }
}
