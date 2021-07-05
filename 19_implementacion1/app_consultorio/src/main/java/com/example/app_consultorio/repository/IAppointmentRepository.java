package com.example.app_consultorio.repository;

import com.example.app_consultorio.model.Appointment;
import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.model.Patient;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    // 3
    List<Appointment> findAppointmentByStatus(String status);

    // 4
    List<Appointment> findAppointmentByDateAndStatus(LocalDate date, String status);

    // 5
    List<Appointment> findAppointmentByDentist_Id(Long id);

    // 7
    List<Appointment> findAppointmentByStatusAndDentist_Id(String status, Long dentistId);
}
