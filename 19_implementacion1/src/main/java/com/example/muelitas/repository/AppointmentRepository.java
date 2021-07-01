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
}
