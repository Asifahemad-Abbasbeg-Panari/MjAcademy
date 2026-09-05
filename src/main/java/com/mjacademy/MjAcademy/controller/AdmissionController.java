package com.mjacademy.MjAcademy.controller;

import com.mjacademy.MjAcademy.entity.Admission;
import com.mjacademy.MjAcademy.service.AdmissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdmissionController {

    private final AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping("/admission/apply")
    public String submitAdmission(@ModelAttribute Admission admission, Model model) {

        admissionService.saveAdmission(admission);

        model.addAttribute("success",
                "Application submitted successfully!");

        return "index";
    }

    @GetMapping("/admin/admissions")
    public String viewAdmissions(Model model) {

        model.addAttribute("admissions", admissionService.getAllAdmissions());

        model.addAttribute("totalAdmissions",
                admissionService.getTotalAdmissions());

        model.addAttribute("pendingAdmissions",
                admissionService.getPendingAdmissions());

        model.addAttribute("approvedAdmissions",
                admissionService.getApprovedAdmissions());

        model.addAttribute("rejectedAdmissions",
                admissionService.getRejectedAdmissions());

        return "admin/admissions";
    }

    @GetMapping("/admin/admissions/{id}")
    public String viewAdmissionDetails(@PathVariable Long id, Model model) {

        Admission admission = admissionService.getAdmissionById(id);

        model.addAttribute("admission", admission);

        return "admin/admission-details";
    }

    @PostMapping("/admin/admissions/{id}/delete")
    public String deleteAdmission(@PathVariable Long id) {

        admissionService.deleteAdmission(id);

        return "redirect:/admin/admissions";
    }

    @PostMapping("/admin/admissions/{id}/approve")
    public String approveAdmission(@PathVariable Long id) {
        admissionService.updateStatus(id, "APPROVED");
        return "redirect:/admin/admissions";
    }

    @PostMapping("/admin/admissions/{id}/reject")
    public String rejectAdmission(@PathVariable Long id) {
        admissionService.updateStatus(id, "REJECTED");
        return "redirect:/admin/admissions";
    }
}