package com.example.muelitas.repository;

import com.example.muelitas.model.Appointment;
import com.example.muelitas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    @Query("SELECT patient.id, patient.name, patient.medicalInsurance FROM Patient patient JOIN Appointment appointment ON appointment.patient.id = patient.id WHERE appointment.date BETWEEN :dateStart AND :dateEnd")
    List findAllPatientsByDate(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query("SELECT professional.id, professional.name, COUNT(*) FROM Professional professional JOIN Appointment appointment ON appointment.professional.id = professional.id GROUP BY professional.id")
    List findAllProfessionalsWithMoreThanTwoAppointments();

    @Query("SELECT appointment.id FROM Appointment appointment WHERE appointment.status LIKE 'Finalizado'")
    List findAllAppointmentsWithStateFinalizado();

    @Query("SELECT appointment.id FROM Appointment appointment WHERE appointment.status LIKE 'Finalizado' AND appointment.date BETWEEN :dateStart AND :dateEnd")
    List findAllAppointmentsWithStatePendienteAndADay(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query("SELECT appointment.id FROM Professional professional JOIN Appointment appointment ON appointment.professional.id = professional.id WHERE professional.id = :idProfessional")
    List findAllProfessionalAppointments(@Param("idProfessional") Long idProfessional);

    @Query("SELECT appointment.id FROM Appointment appointment JOIN Professional professional ON appointment.professional.id = professional.id WHERE appointment.status LIKE 'Finalizado'")
    List findAllProfessionalAppointmentsWithStateReprogramado();

    @Query("SELECT appointment.id FROM Appointment appointment WHERE appointment.status LIKE 'Reprogramado'")
    List findAllAppointmentsWithStateReprogramado();
}
