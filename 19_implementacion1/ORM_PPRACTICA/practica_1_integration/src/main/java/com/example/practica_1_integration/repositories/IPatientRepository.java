package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
    
}
