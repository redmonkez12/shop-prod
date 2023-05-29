package com.example.shop2.services;

import com.example.shop2.dto.LoginUserDto;
import com.example.shop2.dto.RegisterUserDto;
import com.example.shop2.dto.UserDto;
import com.example.shop2.entities.UserEntity;
import com.example.shop2.exceptions.RoleNotFoundException;
import com.example.shop2.exceptions.UserNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDto create(RegisterUserDto registerUserDto) throws RoleNotFoundException;

    UserDto verify(LoginUserDto loginUserDto) throws UserNotFoundException;

    UserEntity findUserByEmail(String email) throws UsernameNotFoundException;
}
