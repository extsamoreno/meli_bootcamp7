package com.implementacion.hibernate2.model.service.appointments;

import com.implementacion.hibernate2.controller.dto.appointments.AppointmentDTO;
import com.implementacion.hibernate2.controller.dto.patients.request.NewAppointmentDTO;

import java.util.List;

public interface IAppointmentService {

    List<AppointmentDTO> listAllAppointmentsByStatus(String status);

    List<AppointmentDTO> listAllAppointmentsByStatusAndDate( String status, String date);

    void insertNewAppointment(NewAppointmentDTO newAppointmentDTO);

}
