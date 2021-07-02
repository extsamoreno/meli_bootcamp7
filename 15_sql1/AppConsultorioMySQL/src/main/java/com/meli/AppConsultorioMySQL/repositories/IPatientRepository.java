package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.repositories.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<PatientEntity, Long> {
}
