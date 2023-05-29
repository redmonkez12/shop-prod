package com.example.shop2.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserDto {
    @NotEmpty(message = "Email is mandatory")
    public String email;

    @NotEmpty(message = "Password is mandatory")
    public String password;
}
