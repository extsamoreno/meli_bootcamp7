package com.example.demo.services;

import com.example.demo.model.Appointment;
import com.example.demo.services.dtos.AppointmentDTO;

import java.util.Date;
import java.util.List;

public interface IAppoimentService {

    List<AppointmentDTO> getAppoimentsByDate(Date date);

    String addApoiment(Appointment appointment);

    List<AppointmentDTO> getFinalizedAppointment();

    List<AppointmentDTO> AppoimentPendingByDate(Date date);
}
