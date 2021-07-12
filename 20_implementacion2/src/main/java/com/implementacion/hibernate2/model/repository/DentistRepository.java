package com.implementacion.hibernate2.model.repository;

import com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsDTO;
import com.implementacion.hibernate2.model.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

    @Query("SELECT new com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsDTO(d.name, COUNT(a.id)) FROM Dentist d "+
            "INNER JOIN Schedule s ON d.schedule.id = s.id "+
            "INNER JOIN Appointment a ON s.id = a.schedule.id "+
            "WHERE DATE(a.date) = DATE(:date) "+
            "GROUP BY d.name "+
            "HAVING COUNT(a.id)  >= (:turns)")
    //List<Object[]> findAllByDateAndTurns(@Param("date") Date date, @Param("turns") Long turns);
    List<DentistAndTurnsDTO> findAllByDateAndTurns(@Param("date") Date date, @Param("turns") Long turns);


}
