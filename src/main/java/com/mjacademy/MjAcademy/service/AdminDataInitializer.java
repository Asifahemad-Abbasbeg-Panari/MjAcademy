package com.mjacademy.MjAcademy.service;

import com.mjacademy.MjAcademy.entity.AdminUser;
import com.mjacademy.MjAcademy.repository.AdminUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminDataInitializer implements CommandLineRunner {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminDataInitializer(AdminUserRepository adminUserRepository,
                                PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (adminUserRepository.count() == 0) {

            AdminUser admin = new AdminUser();

            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");

            adminUserRepository.save(admin);

            System.out.println("=================================");
            System.out.println("ADMIN ACCOUNT CREATED");
            System.out.println("Username: admin");
            System.out.println("Password: admin123");
            System.out.println("=================================");

        }
    }
}