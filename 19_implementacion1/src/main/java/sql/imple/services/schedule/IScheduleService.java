package sql.imple.services.schedule;

import sql.imple.models.dto.ScheduleDTO;

import java.util.List;

public interface IScheduleService {
    void createSchedule(ScheduleDTO scheduleDTO);

    void deleteScheduleById(Long id);

    void updateSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleDTO> findAllSchedules();

    ScheduleDTO findScheduleById(Long id);
}
