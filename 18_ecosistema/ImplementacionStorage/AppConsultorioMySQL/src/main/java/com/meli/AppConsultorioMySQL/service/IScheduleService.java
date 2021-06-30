package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.ScheduleDTO;

import java.util.List;

public interface IScheduleService {
    List<ScheduleDTO> getScheduleByDentist( Long idDentist);
}
