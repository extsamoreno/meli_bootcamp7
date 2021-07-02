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
    //where year(t.endDate) > year(t.startDate)
    //    and month(t.endDate) > month(t.startDate)
    //    and day(t.endDate) > day(t.startDate)
    //DATE(a.appointmentDate) > DATE(:date)
    @Query("FROM Dentist d JOIN Appointment a ON d.id = a.dentist.id WHERE a.appointmentDate between :date AND current_date GROUP BY d.id HAVING COUNT(a.appointmentDate) > 2")
    Set<Dentist> findDentistsByAppointments(@Param("date") LocalDateTime date);
}
