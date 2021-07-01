package com.meli.consultorio.services.schedule;

import com.meli.consultorio.models.dtos.ScheduleDTO;
import java.util.Set;

public interface IScheduleService {
    void createSchedule(ScheduleDTO scheduleDTO);
    void deleteScheduleById(Long id);
    void updateSchedule(ScheduleDTO scheduleDTO);
    Set<ScheduleDTO> findAllSchedules();
    Set<ScheduleDTO> findDentistScheduleByDentistId(Long id);
    ScheduleDTO findScheduleById(Long id);
}
