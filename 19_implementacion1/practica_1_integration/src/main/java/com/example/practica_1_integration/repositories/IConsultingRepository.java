package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultingRepository extends JpaRepository<Appointment, Long> {
}
