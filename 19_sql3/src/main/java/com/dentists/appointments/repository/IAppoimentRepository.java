package com.dentists.appointments.repository;

import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.DTO.DentistCountDates;
import com.dentists.appointments.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppoimentRepository extends JpaRepository<Appointment, Long>{

    List<Appointment> findAppointmentBydate(LocalDate localDate);

    Appointment findFirstByDateEqualsAndAndPatient(LocalDate date, Patient patient);

}
