package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Schedule;

public interface IScheduleService {
    String addSchedule(Schedule schedule);
    String updateSchedule(Schedule schedule);
    String deleteSchedule(Schedule schedule);
}
