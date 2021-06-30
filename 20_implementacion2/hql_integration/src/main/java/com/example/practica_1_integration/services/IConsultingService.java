package com.example.practica_1_integration.services;

import com.example.practica_1_integration.dtos.ProfessionalDTO;
import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.models.Professional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IConsultingService {
    void createAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> findAllAppointments();
    Optional<Appointment> findAppointmentById(Long id);
    void updateAppointment(Appointment appointment);
    //List<ProfessionalPatientDTO> findPatientForDay(LocalDateTime date);
    List<Professional> findPatientForDay(LocalDateTime date);
    List<ProfessionalDTO> findProfessionalWithMoreThan2AppointmentsForDay(LocalDateTime date);
}
