package com.meli.muelitas.repository;

import com.meli.muelitas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatientNitOrderByAppointmentDateDesc(String patientNit);

    List<Appointment> findAllByDentistNameLikeOrderByAppointmentDateDesc(String dentistName);

    List<Appointment> findAllByDentistIdOrderByAppointmentDateDesc(Long dentistId);

    List<Appointment> findAllByAppointmentDateOrderByAppointmentDateAsc(LocalDate appointmentDate);

    @Query("select a from Appointment a where MONTH(a.appointmentDate) = :month ")
    List<Appointment> findAllByAppointmentDate_MonthOrderByAppointmentDateAsc(int month);

    List<Appointment> findAllByStatusOrderByAppointmentDateDesc(String status);

    List<Appointment> findAllByStatusAndAppointmentDateOrderByAppointmentDateDesc(String status, LocalDate date);

    List<Appointment> findAllByDentistNameAndAppointmentCancelledNotNullOrderByAppointmentDateDesc(String dentistName);

    List<Appointment> findAllByDentistIdAndAppointmentCancelledNotNullOrderByAppointmentDateDesc(Long dentistId);

    List<Appointment> findAllByDentistIdAndAppointmentDateAndAppointmentTimeIsBetween(Long dentistId, LocalDate appointmentDate, LocalTime toTime, LocalTime fromTime);

    List<Appointment> findAllByPatientNitAndAppointmentDateAndStatusAndAppointmentTimeIsBetween(String patientNit, LocalDate appointmentDate, String status, LocalTime toTime, LocalTime fromTime);

}
