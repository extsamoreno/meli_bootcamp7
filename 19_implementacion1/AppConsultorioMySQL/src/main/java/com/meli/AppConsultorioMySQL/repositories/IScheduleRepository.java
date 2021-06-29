package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.DentistEntity;
import com.meli.AppConsultorioMySQL.models.SchedulesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository<SchedulesEntity, Long> {
}
