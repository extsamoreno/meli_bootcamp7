package com.example.muelitas.repository;

import com.example.muelitas.model.Appointment;
import com.example.muelitas.model.Patient;
import com.example.muelitas.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    @Query("FROM Patient patient JOIN Appointment appointment ON appointment.patient.id = patient.id WHERE appointment.date BETWEEN :dateStart AND :dateEnd")
    List<Patient> findAllPatientsByDate(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query("SELECT appointment.professional FROM Appointment appointment WHERE DATEDIFF(appointment.date, :date) = 0  GROUP BY appointment.professional HAVING COUNT(appointment.professional) > 2")
    List<Professional> findAllProfessionalsWithMoreThanTwoAppointments(@Param("date") LocalDateTime date);

    @Query("FROM Appointment appointment WHERE appointment.status LIKE 'Finalizado'")
    List<Appointment> findAllAppointmentsWithStateFinalizado();

    @Query("FROM Appointment appointment WHERE appointment.status LIKE 'Pendiente' AND DATEDIFF(appointment.date, :date) = 1")
    List<Appointment> findAllAppointmentsWithStatePendienteAndADay(@Param("date") LocalDateTime date);

    @Query("FROM Appointment appointment JOIN Professional professional ON appointment.professional.id = professional.id WHERE professional.id = :idProfessional")
    List<Appointment> findAllProfessionalAppointments(@Param("idProfessional") Long idProfessional);

    @Query("FROM Appointment appointment JOIN Professional professional ON appointment.professional.id = professional.id WHERE appointment.status LIKE 'Finalizado' AND professional.id = :idProfessional")
    List<Appointment> findAllProfessionalAppointmentsWithStateReprogramado(@Param("idProfessional") Long idProfessional);

    @Query("FROM Appointment appointment WHERE appointment.status LIKE 'Reprogramado'")
    List<Appointment> findAllAppointmentsWithStateReprogramado();
}
