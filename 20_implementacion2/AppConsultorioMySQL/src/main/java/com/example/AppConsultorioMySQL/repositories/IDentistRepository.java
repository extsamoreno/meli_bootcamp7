package com.example.AppConsultorioMySQL.repositories;

import com.example.AppConsultorioMySQL.models.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    // Listar todos los dentistas que tengan más de dos turnos en una fecha
    @Query(value = "select d.* from turns t inner join schedules s on s.id = t.schedule_id inner join dentists d on d.id = s.dentist_id where s.date = :date GROUP BY t.schedule_id HAVING COUNT(*) > 1", nativeQuery = true)
    List<Dentist> listDentistMoreThan2TurnsByDate(@Param("date") LocalDate date);
}
