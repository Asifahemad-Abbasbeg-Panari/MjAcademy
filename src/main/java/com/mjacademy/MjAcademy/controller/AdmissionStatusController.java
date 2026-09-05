package com.mjacademy.MjAcademy.controller;

import com.mjacademy.MjAcademy.entity.Admission;
import com.mjacademy.MjAcademy.repository.AdmissionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdmissionStatusController {

    private final AdmissionRepository admissionRepository;

    public AdmissionStatusController(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    @GetMapping("/admission-status")
    public String admissionStatus(
            @RequestParam(required = false) String phone,
            Model model) {

        if (phone != null && !phone.trim().isEmpty()) {

            List<Admission> admissions =
                    admissionRepository.findByPhone(phone.trim());

            if (!admissions.isEmpty()) {
                model.addAttribute("admissions", admissions);
            } else {
                model.addAttribute("error",
                        "No application found with this mobile number.");
            }
        }

        return "admission-status";
    }
}