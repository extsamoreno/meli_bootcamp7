package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import com.example.AppConsultorioMySQL.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{
    IScheduleRepository scheduleRepository;

    @Override
    public String addSchedule(Schedule schedule) {
        return null;
    }

    @Override
    public String updateSchedule(Schedule schedule) {
        return null;
    }

    @Override
    public String deleteSchedule(Schedule schedule) {
        return null;
    }
}
