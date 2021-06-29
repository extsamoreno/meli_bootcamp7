package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.repositories.entities.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<DentistEntity, Long> {
}
