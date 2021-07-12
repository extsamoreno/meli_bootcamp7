package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleRequestDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleResponseDTO;

import java.util.List;

public interface IScheduleService {

    String addSchedule(ScheduleRequestDTO scheduleDTO);

    ScheduleResponseDTO retrieveSchedule(Long id);

    String updateSchedule(ScheduleResponseDTO scheduleResponseDTO);

    String deleteSchedule(Long id);

    List<ScheduleDTO> getScheduleByDentist( Long idDentist);
}
