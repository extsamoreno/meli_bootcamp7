package com.example.app_consultorio.repository;

import com.example.app_consultorio.model.Appointment;
import com.example.app_consultorio.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
