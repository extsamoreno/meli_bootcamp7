package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Integer> {

    //Listar todos los dentistas que tengan más de dos turnos en una fecha
    @Query("select d from Dentist d " +
            "join d.turnSet t " +
            "where t.startTime = :date " +
            "group by d HAVING COUNT(t) > 2")
    List<Dentist> findDentistWithMoreOf2Turns(@Param("date")LocalDateTime date);

    //La query en sql la haria asi:
    /**
     SELECT dentists.name,COUNT(t.id_turn) AS trns
     FROM dentists
     JOIN turns_dentists td ON td.id_dentist = dentists.id_dentist
     JOIN turns t ON td.id_turn = t.id_turn
     GROUP BY dentists.name HAVING trns > 2;
     */

}

