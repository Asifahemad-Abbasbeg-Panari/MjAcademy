package com.mjacademy.MjAcademy.repository;

import com.mjacademy.MjAcademy.entity.Admission;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

    long countByStatus(String status);
    List<Admission> findByPhone(String phone);
}