package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.ScheduleNotFoundException;
import com.example.AppConsultorioMySQL.dtos.ScheduleDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService {
    String createSchedule(ScheduleDTO patient);
    String updateSchedule(ScheduleDTO patient) throws ScheduleNotFoundException;
    String deleteSchedule(Long id) throws ScheduleNotFoundException;
    List<ScheduleDTO> findAllSchedules();
    ScheduleDTO findScheduleById(Long id) throws ScheduleNotFoundException;

    List<ScheduleDTO> listScheduleByDentist (@PathVariable LocalDate date, @PathVariable Long dentist_id);
}
