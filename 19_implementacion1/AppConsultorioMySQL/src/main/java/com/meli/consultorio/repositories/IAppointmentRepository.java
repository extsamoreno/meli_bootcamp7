package com.meli.consultorio.repositories;

import com.meli.consultorio.models.Appointment;
import com.meli.consultorio.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
    Set<Appointment> findAppointmentsByDentistId(Long id);
    Set<Appointment> findAppointmentsByPatientId(Long id);

    //Dentista con mas de dos turnos en una fecha

    Set<Appointment> findAppointmentsByState(String state);

    Set<Appointment> findAppointmentsByStateAndAppointmentDateBetween(String state, LocalDateTime from, LocalDateTime to);

    Set<Appointment> findAppointmentsByDentistIdAndState(Long id, String state);
}
