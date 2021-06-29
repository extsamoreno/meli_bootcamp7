package com.example.app_consultorio.repository;

import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
