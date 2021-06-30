package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import com.example.AppConsultorioMySQL.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{
    IScheduleRepository scheduleRepository;

    @Override
    public String createSchedule(Schedule patient) {
        return null;
    }

    @Override
    public String updateSchedule(Schedule patient) {
        return null;
    }

    @Override
    public String deleteSchedule(Long id) {
        return null;
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return null;
    }

    @Override
    public Schedule findScheduleById(Long id) {
        return null;
    }
}
