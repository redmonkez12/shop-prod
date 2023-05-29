package com.example.shop2.services;

import com.example.shop2.entities.RoleEntity;
import com.example.shop2.exceptions.RoleNotFoundException;

public interface RoleService {
    RoleEntity findByName(String name) throws RoleNotFoundException;
}
