package com.example.shop2;

import com.example.shop2.entities.RoleEntity;
import com.example.shop2.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Shop2Application {

    private final RoleRepository roleRepository;

    public Shop2Application(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Shop2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            try {
                this.roleRepository.saveAll(List.of(
                        new RoleEntity("USER"),
                        new RoleEntity("ADMIN"),
                        new RoleEntity("SUPER_ADMIN")
                ));
            } catch (Exception e) {
                // ..
            }
        };
    }
}
