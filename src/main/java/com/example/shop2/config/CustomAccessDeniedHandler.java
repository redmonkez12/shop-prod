package com.example.shop2.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getPrincipal() == null) {
            response.sendRedirect(request.getContextPath() + "/access-denied");
        } else {
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }

    }
}
