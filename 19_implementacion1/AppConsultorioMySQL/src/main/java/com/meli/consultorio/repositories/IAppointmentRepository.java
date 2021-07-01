package com.meli.consultorio.repositories;

import com.meli.consultorio.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
    Set<Appointment> findAppointmentsByDentistId(Long id);
    Set<Appointment> findAppointmentsByPatientId(Long id);
}
