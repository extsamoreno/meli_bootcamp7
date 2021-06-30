package com.dentists.appointments.service;

import com.dentists.appointments.model.DTO.AppDTOByDate;
import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.DTO.DentistCountDates;

import java.util.List;

public interface IAppoimentService {

    Appointment getById(Long id);

    List<Appointment> findAll();

    Appointment save(Appointment appointment);

    String update(Appointment appointment);

    String delete(Long id);

    List<AppDTOByDate> findAllByDate(String localDate);

    List<DentistCountDates> findDentistsByMore2App(String date);
}
