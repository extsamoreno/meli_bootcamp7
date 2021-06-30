package com.meli.consultory.repositories;

import com.meli.consultory.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Patient, Long> {
}
