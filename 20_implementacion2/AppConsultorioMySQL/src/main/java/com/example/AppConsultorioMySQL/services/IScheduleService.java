package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Schedule;

import java.util.List;

public interface IScheduleService {
    String createSchedule(Schedule patient);
    String updateSchedule(Schedule patient);
    String deleteSchedule(Long id);
    List<Schedule> findAllSchedules();
    Schedule findScheduleById(Long id);
}
