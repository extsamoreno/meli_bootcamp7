package com.example.AppConsultorioMySQL.repositories;

import com.example.AppConsultorioMySQL.models.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ITurnRepository extends JpaRepository<Turn, Long> {
    // Listar todos los turnos con estado finalizado
    @Query(value = "select * FROM turns WHERE state = 'Finalizado'", nativeQuery = true)
    List<Turn> listTurnsStateEnd();

    // Listar todos los turnos con estado pendiente de un día
    //select * from turns t inner join schedules s on t.schedule_id = s.id where state = 'PENDIENTE' and s.date = '2021-10-10';
    @Query(value = "select * FROM turns t JOIN schedules s on t.schedule_id = s.id where state = 'PENDIENTE' and s.date = :date", nativeQuery = true )
    List<Turn> listTurnsStatePendingByDate(@Param("date") LocalDate date);
}
