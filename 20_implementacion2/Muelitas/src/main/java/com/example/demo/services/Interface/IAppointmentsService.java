package com.example.demo.services.Interface;

import com.example.demo.model.Appointment;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IAppointmentsService {
    void createAppointment(Appointment appointment);

    List<Appointment>   listAppointment();

    List<Map<String, Object>> listDentistAppointments ();

    List<Map<String, Object>>listsStatusFinish ();

    List<Map<String, Object>> listsStatusPending(Date fecha);

    List<Map<String, Object>> listsAgenda( Integer dentista);


    List<Map<String, Object>> listsresheduleDentist( Integer dentista);

    List<Map<String, Object>> listsreshedule( );
}
