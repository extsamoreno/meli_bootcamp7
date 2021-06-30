package com.example.demo.service;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.entity.Schedule;

public interface IScheduleService {

    String addSchedule(ScheduleDTO scheduleDTO);

    ScheduleDTO retrieveSchedule(Long id);

    String updateSchedule(ScheduleDTO scheduleDTO);

    String deleteSchedule(Long id);

}
