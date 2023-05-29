package com.example.shop2.controllers;

import com.example.shop2.dto.LoginUserDto;
import com.example.shop2.dto.RegisterUserDto;
import com.example.shop2.entities.UserEntity;
import com.example.shop2.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

@Controller
public class AuthController {

    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginUserPage(Model model, @RequestParam("error") Optional<String> error) {
        var user = new UserEntity();
        model.addAttribute("user", user);

        if (error.isPresent()) {
            model.addAttribute("message", "Invalid password or username");
        }

        return "login";
    }

    @GetMapping("/register")
    public String registerUserPage(Model model) {
        var user = new RegisterUserDto();
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid RegisterUserDto user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.create(user);
        } catch (Exception e) {
            model.addAttribute("message", "This email is already registered");
            return "register";
        }

        return "redirect:/login";
    }
}
