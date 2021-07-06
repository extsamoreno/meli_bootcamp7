package com.consultoriomongo.demo.service;

import com.consultoriomongo.demo.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAllAppointments();

    List<Appointment> getAllAppointmentsByDoctor(String name);

    List<Appointment> getAppointmentByStatus(String status);
}
