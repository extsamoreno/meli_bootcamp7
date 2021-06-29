package com.example.AppConsultorioMySQL.repositories;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
}
