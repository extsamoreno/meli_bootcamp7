package com.meli.Muelitas.service;


import com.meli.Muelitas.model.DTO.AppointmentDTO;

import java.text.ParseException;
import java.util.List;

public interface IAppointmentService {
    List<AppointmentDTO> getAppointmentFinish() throws ParseException;
    List<AppointmentDTO> getAppointmentPendingByDate(String date) throws ParseException;
    List<AppointmentDTO> getAppointmentsReprogrammed(Long idDentist) throws ParseException;
    List<AppointmentDTO> getAppointmentsReprogrammedAllDentist() throws ParseException;
}
