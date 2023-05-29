package com.example.shop2.services;

import com.example.shop2.entities.RoleEntity;
import com.example.shop2.exceptions.RoleNotFoundException;
import com.example.shop2.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    public final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity findByName(String name) throws RoleNotFoundException {
        return this.roleRepository.findByName(name)
                .orElseThrow(() -> new RoleNotFoundException("Role not found [%s]".formatted(name)));
    }
}
