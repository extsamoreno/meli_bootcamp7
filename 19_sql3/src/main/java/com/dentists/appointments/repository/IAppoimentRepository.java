package com.dentists.appointments.repository;

import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.Patient;
import com.dentists.appointments.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppoimentRepository extends JpaRepository<Appointment, Long>{

    List<Appointment> findAppointmentBydate(LocalDate localDate);

    Appointment findFirstByDateEqualsAndAndPatient(LocalDate date, Patient patient);

    List<Appointment> findByStatus(Status status);

}
