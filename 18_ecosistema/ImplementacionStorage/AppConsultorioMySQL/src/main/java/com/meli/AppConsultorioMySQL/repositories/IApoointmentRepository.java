package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApoointmentRepository extends JpaRepository<Apoointment, Long> {
}
