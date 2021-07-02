package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.dtos.AppointmentDto;
import com.meli.AppConsultorioMySQL.repositories.entities.AppointmentEntity;
import com.meli.AppConsultorioMySQL.repositories.entities.DentistEntity;
import com.meli.AppConsultorioMySQL.repositories.entities.ScheduleEntity;

import java.util.List;

public interface IAppointmentCrudService {
    String addOne(AppointmentEntity appointment);

    AppointmentDto getById(Long id);

    List<AppointmentDto> getByDay(int day, int month, int year);
}
