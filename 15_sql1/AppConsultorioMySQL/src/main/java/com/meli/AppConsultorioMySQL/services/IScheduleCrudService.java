package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.dtos.DentistDto;
import com.meli.AppConsultorioMySQL.dtos.ScheduleDto;
import com.meli.AppConsultorioMySQL.repositories.entities.ScheduleEntity;

public interface IScheduleCrudService {
    String addOne(ScheduleEntity schedule);

    ScheduleDto getById(Long id);
}
