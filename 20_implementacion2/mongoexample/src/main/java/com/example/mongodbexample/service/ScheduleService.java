package com.example.mongodbexample.service;

import com.example.mongodbexample.domain.Schedule;
import com.example.mongodbexample.repository.ScheduleRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> findSchedulesByDoctor(String doctor) {
        return scheduleRepository.findSchedulesByDoctor(doctor);
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

}
