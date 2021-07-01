package com.example.mongodbexample.service;

import com.example.mongodbexample.domain.Schedule;
import com.example.mongodbexample.dto.ScheduleDoctorDto;
import com.example.mongodbexample.repository.ScheduleRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<ScheduleDoctorDto> findSchedulesByDoctor(String lastName) {
        List<Schedule> schedule = scheduleRepository.findSchedulesByDoctor(lastName);
        return schedule.stream().map(s ->
                new ScheduleDoctorDto(s.getId(), s.getPatient(), s.getDate(), s.getStatus()))
                .collect(Collectors.toList());
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesByStatus(String status) {
        return scheduleRepository.findSchedulesByStatus(status);
    }
}
