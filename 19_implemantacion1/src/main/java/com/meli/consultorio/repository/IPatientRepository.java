package com.meli.consultorio.repository;

import com.meli.consultorio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Integer> {

}
