package com.dentists.appointments.repository;

import com.dentists.appointments.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppoimentRepository extends JpaRepository<Appointment, Long>{

    List<Appointment> findAppointmentBydate(LocalDate localDate);
}
