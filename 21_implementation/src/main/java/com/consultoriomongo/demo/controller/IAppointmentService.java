package com.consultoriomongo.demo.controller;

import com.consultoriomongo.demo.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAllAppointments();
}
