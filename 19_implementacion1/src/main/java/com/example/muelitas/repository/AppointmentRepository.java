package com.example.muelitas.repository;

import com.example.muelitas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
}
