package com.meli.muelitas.repository;

import com.meli.muelitas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    Optional<Patient> findByNit(String nit);

}
