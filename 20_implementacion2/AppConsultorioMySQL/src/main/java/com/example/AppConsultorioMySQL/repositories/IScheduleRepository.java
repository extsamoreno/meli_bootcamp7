package com.example.AppConsultorioMySQL.repositories;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
    // Listar la agenda de un dentista
    @Query(value = "select * FROM schedules where dentist_id = :dentist_id and date = :date", nativeQuery = true)
    List<Schedule> listScheduleByDentist(@Param("date") LocalDate date, @Param("dentist_id") Long dentist_id);
}
