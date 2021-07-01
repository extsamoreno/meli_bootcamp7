package com.meli.consultorio.services.appointment;

import com.meli.consultorio.models.dtos.AppointmentDTO;
import com.meli.consultorio.models.dtos.ScheduleDTO;

import java.util.Set;

public interface IAppointmentService {
    void createAppointment(AppointmentDTO appointmentDTO);
    void deleteAppointmentById(Long id);
    void updateAppointment(AppointmentDTO appointmentDTO);
    Set<AppointmentDTO> findAllAppointments();
    Set<AppointmentDTO> findAppointmentByDentistId(Long id);
    Set<AppointmentDTO> findAppointmentByPatientId(Long id);
    AppointmentDTO findAppointmentById(Long id);
}
