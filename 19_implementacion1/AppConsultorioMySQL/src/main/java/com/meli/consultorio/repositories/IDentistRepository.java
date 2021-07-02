package com.meli.consultorio.repositories;

import com.meli.consultorio.models.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    //Dentista con mas de dos turnos en una fecha
    @Query("SELECT d FROM Dentist d JOIN Appointment a ON d.id = a.dentist.id WHERE DATE(a.appointmentDate) = DATE(:date) GROUP BY d.id HAVING COUNT(a.appointmentDate) > 2")
    Set<Dentist> findDentistsByAppointments(@Param("date") LocalDateTime date);
}
