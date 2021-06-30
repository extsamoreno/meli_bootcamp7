package com.meli.consultorio.services.schedule;

import com.meli.consultorio.models.dtos.ScheduleDTO;
import java.util.List;

public interface IScheduleService {
    void createSchedule(ScheduleDTO scheduleDTO);
    void deleteScheduleById(Long id);
    void updateSchedule(ScheduleDTO scheduleDTO);
    List<ScheduleDTO> findDentistScheduleByDentistId(Long id);
    ScheduleDTO findScheduleById(Long id);
}
