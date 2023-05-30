package com.example.shop2.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPages {

    @GetMapping("/access-denied")
    public String accessDeniedPage(HttpServletRequest request) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(request.getRemoteUser());
        System.out.println(auth.getCredentials());
        System.out.println(auth.getAuthorities());
        System.out.println(auth.getDetails());
        System.out.println(auth.getPrincipal());

        return "error-403";
    }
}
