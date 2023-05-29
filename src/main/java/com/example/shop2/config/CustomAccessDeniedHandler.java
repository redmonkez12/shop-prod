package com.example.shop2.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

//    public static final Logger LOG
//            = Logger.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        var auth
//                = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            LOG.warn("User: " + auth.getName()
//                    + " attempted to access the protected URL: "
//                    + request.getRequestURI());
//        }

        response.sendRedirect(request.getContextPath() + "/access-denied");
    }
}
