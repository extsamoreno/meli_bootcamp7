package com.example.app_consultorio.repository;

import com.example.app_consultorio.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    // 2
    @Query("SELECT app.dentist FROM Appointment app WHERE app.date=:date GROUP BY app.dentist HAVING COUNT(app.dentist) >= 2")
    List<Dentist> findByAppGreaterThanTwo(LocalDate date);
}
