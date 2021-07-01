package com.example.practica_1_integration.services;

import com.example.practica_1_integration.dtos.AppointmentDTO;
import com.example.practica_1_integration.dtos.ProfessionalDTO;
import com.example.practica_1_integration.dtos.ProfessionalPatientDTO;
import com.example.practica_1_integration.models.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IConsultingService {
    void createAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> findAllAppointments();
    Optional<Appointment> findAppointmentById(Long id);
    void updateAppointment(Appointment appointment);
    List<ProfessionalPatientDTO> findPatientForDay(LocalDateTime date);
    List<ProfessionalDTO> findProfessionalWithMoreThan2AppointmentsForDay(LocalDateTime date);
    List<AppointmentDTO> findFinishedAppointments();
    List<AppointmentDTO> findPendingAppointmentByDate(LocalDateTime date);
    List<AppointmentDTO> findAppointmentsByProfessional(int id);
    List<AppointmentDTO> findDelayedAppointmentsByProfessional(int id);
    List<AppointmentDTO> findDelayedAppointments();
}
