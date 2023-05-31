package com.example.shop2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPages {

    @GetMapping("/access-denied")
    public String accessDeniedPage() {
        return "error-403";
    }
}
