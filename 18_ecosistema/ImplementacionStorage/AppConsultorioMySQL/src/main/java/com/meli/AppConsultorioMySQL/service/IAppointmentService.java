package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.AppointmentDTO;

import java.text.ParseException;
import java.util.List;

public interface IAppointmentService {
    List<AppointmentDTO> getAppointmentFinish() throws ParseException;
    List<AppointmentDTO> getAppointmentPendingByDate(String date) throws ParseException;
}
