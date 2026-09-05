package com.mjacademy.MjAcademy.controller;

import com.mjacademy.MjAcademy.service.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin-login";
    }

    @GetMapping("/admin/change-password")
    public String changePasswordPage() {
        return "admin/change-password";
    }

    @PostMapping("/admin/change-password")
    public String changePassword(
            @RequestParam String currentPassword,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        if (newPassword.length() < 8) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "New password must be at least 8 characters long."
            );

            return "redirect:/admin/change-password";
        }

        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "New password and confirm password do not match."
            );

            return "redirect:/admin/change-password";
        }

        boolean changed = adminService.changePassword(
                authentication.getName(),
                currentPassword,
                newPassword
        );

        if (!changed) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "Current password is incorrect."
            );

            return "redirect:/admin/change-password";
        }

        redirectAttributes.addFlashAttribute(
                "success",
                "Password changed successfully."
        );

        return "redirect:/admin/change-password";
    }
}