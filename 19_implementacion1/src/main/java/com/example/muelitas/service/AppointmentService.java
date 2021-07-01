package com.example.muelitas.service;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.model.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface AppointmentService {
    ResponseDTO createAppointment(AppointmentDTO newAppointment);
    AppointmentDTO readAppointment(Long idAppointment);
    ResponseDTO updateAppointment(AppointmentDTO updatedAppointment);
    ResponseDTO deleteAppointment(Long idAppointment);
    List<PatientDTO> findAllPatientsByDate (LocalDateTime date);
    List<ProfessionalDTO> findAllProfessionalsWithMoreThanTwoAppointments();
    List<AppointmentDTO> findAllAppointmentsWithStateFinalizado();
    List<AppointmentDTO> findAllAppointmentsWithStatePendienteAndADay(LocalDateTime date);
    List<AppointmentDTO> findAllProfessionalAppointments(Long idProfessional);
    List<AppointmentDTO> findAllProfessionalAppointmentsWithStateReprogramado(Long idProfessional);
    List<AppointmentDTO> findAllAppointmentsWithStateReprogramado();
}
