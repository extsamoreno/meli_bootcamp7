package com.meli.consultorio.repositories;

import com.meli.consultorio.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
