package com.example.app_consultorio.service;

import com.example.app_consultorio.dto.AppointmentDTO;
import com.example.app_consultorio.dto.DentistDTO;
import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    void createAppointment(AppointmentDTO appointmentDTO);

    void deleteAppointmentById(Long id);

    void updateAppointment(Appointment appointment);

    List<AppointmentDTO> findAllAppointments();

    Appointment findAppointmentById(Long id);

    List<AppointmentDTO> findAppointmentsByStatus(String status);

    List<AppointmentDTO> findAppointmentsByDateAndPendiente(String date);

    List<AppointmentDTO> findAppointmentsByDentistId(Long id);
}
