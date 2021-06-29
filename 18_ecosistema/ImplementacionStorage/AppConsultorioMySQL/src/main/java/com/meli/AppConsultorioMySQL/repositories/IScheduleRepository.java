package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.DentistEntity;
import com.meli.AppConsultorioMySQL.models.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}
