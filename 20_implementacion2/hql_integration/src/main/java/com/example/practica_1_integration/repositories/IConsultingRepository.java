package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultingRepository extends JpaRepository<Appointment, Long> {

    @Query("FROM Appointment A " +
            "WHERE DATEDIFF(A.date, :date) = 0")
    List<Appointment> findPatientsOfProfessionalByDate(@Param("date") LocalDateTime date);

    //  Listar todos los dentistas que tengan más de dos turnos en una fecha. (en la base no hay ninguno)
    @Query( "SELECT A.professional " +
            "FROM Appointment A " +
            "WHERE DATEDIFF(A.date, :date) = 0 " +
            "GROUP BY A.professional HAVING COUNT(A.professional) > 2")
    List<Professional> findProfessionalsByDateAndMoreThanTwoAppointments(@Param("date") LocalDateTime date);

    // Listar todos los turnos con estado finalizado
    @Query("FROM Appointment A " +
            "WHERE A.state = 'Finalizado'")
    List<Appointment> findFinishedAppointments();

    //  Listar todos los turnos con estado pendiente de un día
    @Query("FROM Appointment A " +
            "WHERE A.state = 'Pendiente' AND DATEDIFF(A.date, :date) = 0")
    List<Appointment> findPendingAppointmentByDate(@Param("date") LocalDateTime date);

    //  Listar la agenda de un dentista
    @Query("FROM Appointment A " +
            "WHERE A.professional.id = :id")
    List<Appointment> findAppointmentsByProfessional(@Param("id") Long id);

    //  Listar todos los turnos que fueron reprogramados de un dentista (extra)
    @Query("FROM Appointment A " +
            "WHERE A.state = 'Reprogramado' AND A.professional.id = :id")
    List<Appointment> findDelayedAppointmentsByProfessional(@Param("id") Long id);

    //  Listar todos los turnos que fueron reprogramados. (extra)
    @Query("FROM Appointment A " +
            "WHERE A.state = 'Reprogramado'")
    List<Appointment> findDelayedAppointments();
}
