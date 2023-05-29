package com.example.shop2.services;

import com.example.shop2.dto.LoginUserDto;
import com.example.shop2.dto.RegisterUserDto;
import com.example.shop2.dto.UserDto;
import com.example.shop2.entities.UserEntity;
import com.example.shop2.exceptions.RoleNotFoundException;
import com.example.shop2.exceptions.UserNotFoundException;
import com.example.shop2.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleServiceImpl roleService;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleServiceImpl roleService,
            PasswordEncoder passwordEncoder
        ) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto create(RegisterUserDto registerUserDto) throws RoleNotFoundException  {
        var newUser = new UserEntity();
        newUser.setFirstName(registerUserDto.getFirstName());
        newUser.setLastName(registerUserDto.getLastName());
        newUser.setEmail(registerUserDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        var role = this.roleService.findByName("USER");
        newUser.setRoles(Set.of(role));

        var created = userRepository.save(newUser);
        return mapToDto(created);
    }

    @Override
    public UserEntity findUserByEmail(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDto verify(LoginUserDto loginUserDto) throws UserNotFoundException {
        var userDb = this.userRepository.findByEmail(loginUserDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Username or password is invalid"));

        if (Objects.equals(userDb.getPassword(), loginUserDto.getPassword())) {
           throw new UserNotFoundException("Username or password is invalid");
        }

        return mapToDto(userDb);
    }

    public UserDto mapToDto(UserEntity userEntity) {
        return UserDto.builder()
                .roles(userEntity.getRoles())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .build();
    }
}
