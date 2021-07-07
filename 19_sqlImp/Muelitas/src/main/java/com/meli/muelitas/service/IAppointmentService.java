package com.meli.muelitas.service;

import com.meli.muelitas.dto.AppointmentDTO;
import com.meli.muelitas.dto.AppointmentInDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IAppointmentService {

    void createAppointment(AppointmentInDTO appointmentInDTO);

    void cancelAppointmentById(Long appointmentId);

    void endAppointmentById(Long appointmentId);

    void rescheduleAppointmentById(Long appointmentId, LocalDate newAppointmentDate, LocalTime newAppointmentTime);

    List<AppointmentDTO> getAppointmentByPatientNit(String patientNit);

    List<AppointmentDTO> getAppointmentListByDentistName(String dentistName);

    List<AppointmentDTO> getAppointmentListByDentistId(Long dentistId);

    List<AppointmentDTO> getAppointmentListByDate(LocalDate date);

    List<AppointmentDTO> getAppointmentListByMonth(int month);

    List<AppointmentDTO> getAppointmentListByStatus(String status);

    List<AppointmentDTO> getAppointmentListByStatusAndDate(String status, LocalDate date);

    List<AppointmentDTO> getAppointmentListRescheduledByDentistName(String dentistName);

    List<AppointmentDTO> getAppointmentListRescheduledByDentistId(Long dentistId);

    List<AppointmentDTO> getAppointmentListByDentistIdAndDateBetweenTime(Long dentistId, LocalDate appointmentDate, LocalTime toTime, LocalTime fromTime);

    List<AppointmentDTO> getAppointmentListByPatientNitAndDateAndStatusAndBetweenTime(String patientNit, LocalDate appointmentDate, LocalTime toTime, LocalTime fromTime);

}
