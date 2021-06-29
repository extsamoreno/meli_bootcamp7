package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.DentistEntity;
import com.meli.AppConsultorioMySQL.models.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<PatientEntity, Long> {
}
