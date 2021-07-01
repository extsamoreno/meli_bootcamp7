package com.example.muelitas.service;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ResponseDTO;
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
}
