package com.example.shop2.dto;

import com.example.shop2.entities.RoleEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class UserDto {
    public long id;

    public String firstName;

    public String lastName;

    public String email;

    public Set<RoleEntity> roles;
}
