package com.dentists.appointments.service;

import com.dentists.appointments.model.Appointment;

import java.util.List;

public interface IAppoimentService {

    Appointment getById(Long id);

    List<Appointment> findAll();

    Appointment save(Appointment appointment);

    String update(Appointment appointment);

    String delete(Long id);
}
