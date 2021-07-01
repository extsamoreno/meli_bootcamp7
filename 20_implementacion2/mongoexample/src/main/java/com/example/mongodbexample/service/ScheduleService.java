package com.example.mongodbexample.service;

import com.example.mongodbexample.domain.Schedule;
import com.example.mongodbexample.dto.ScheduleDoctorDto;
import com.example.mongodbexample.repository.ScheduleRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ScheduleDoctorDto> findSchedulesByDoctor(String lastName) {
        List<Schedule> schedule = scheduleRepository.findSchedulesByDoctor(lastName);
        List<ScheduleDoctorDto> listScheduleDoctorDto = new ArrayList<>();
        schedule.stream().forEach(s -> listScheduleDoctorDto.add(
                new ScheduleDoctorDto(s.getId(), s.getPatient(), s.getDate(), s.getStatus())
        ));
        return listScheduleDoctorDto;
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesByStatus(String status) {
        return scheduleRepository.findSchedulesByStatus(status);
    }
}
