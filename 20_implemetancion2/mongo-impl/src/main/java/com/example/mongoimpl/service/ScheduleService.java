package com.example.mongoimpl.service;

import com.example.mongoimpl.dto.ScheduleDoctorDTO;
import com.example.mongoimpl.model.Schedule;
import com.example.mongoimpl.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<ScheduleDoctorDTO> findSchedulesByDoctor(String lastName) {
        List<Schedule> schedule = scheduleRepository.findSchedulesByDoctor(lastName);
        return schedule.stream().map(s ->
                new ScheduleDoctorDTO(s.getId(), s.getPatient(), s.getDate(), s.getStatus()))
                .collect(Collectors.toList());
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesByStatus(String status) {
        return scheduleRepository.findSchedulesByStatus(status);
    }
}