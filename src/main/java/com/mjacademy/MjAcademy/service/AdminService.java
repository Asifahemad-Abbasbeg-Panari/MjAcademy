package com.mjacademy.MjAcademy.service;

import com.mjacademy.MjAcademy.entity.AdminUser;
import com.mjacademy.MjAcademy.repository.AdminUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminUserRepository adminUserRepository,
                        PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AdminUser createAdmin(String username, String password) {

        AdminUser admin = new AdminUser();

        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));
        admin.setRole("ADMIN");

        return adminUserRepository.save(admin);
    }

    public boolean changePassword(String username,
                                  String currentPassword,
                                  String newPassword) {

        AdminUser admin = adminUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // Check current password
        if (!passwordEncoder.matches(currentPassword, admin.getPassword())) {
            return false;
        }

        // Save new encrypted password
        admin.setPassword(passwordEncoder.encode(newPassword));
        adminUserRepository.save(admin);

        return true;
    }
}