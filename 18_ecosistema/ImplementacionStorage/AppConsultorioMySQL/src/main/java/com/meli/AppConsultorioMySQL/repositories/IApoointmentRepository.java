package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.ApoointmentEntity;
import com.meli.AppConsultorioMySQL.models.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApoointmentRepository extends JpaRepository<ApoointmentEntity, Long> {
}
