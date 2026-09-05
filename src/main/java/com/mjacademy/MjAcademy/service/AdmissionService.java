package com.mjacademy.MjAcademy.service;

import com.mjacademy.MjAcademy.entity.Admission;
import com.mjacademy.MjAcademy.repository.AdmissionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdmissionService {

    private final AdmissionRepository admissionRepository;

    public AdmissionService(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    public Admission saveAdmission(Admission admission) {
        admission.setApplicationDate(LocalDateTime.now());
        admission.setStatus("PENDING");
        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission getAdmissionById(Long id) {
        return admissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admission not found"));
    }

    public void deleteAdmission(Long id) {
        admissionRepository.deleteById(id);
    }


    public void updateStatus(Long id, String status) {

        Admission admission = admissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admission not found"));

        admission.setStatus(status);

        admissionRepository.save(admission);
    }

    public long getTotalAdmissions() {
        return admissionRepository.count();
    }

    public long getPendingAdmissions() {
        return admissionRepository.countByStatus("PENDING");
    }

    public long getApprovedAdmissions() {
        return admissionRepository.countByStatus("APPROVED");
    }

    public long getRejectedAdmissions() {
        return admissionRepository.countByStatus("REJECTED");
    }
}