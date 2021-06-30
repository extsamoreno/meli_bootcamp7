package com.example.demo.service;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.entity.Schedule;
import com.example.demo.repository.IDentistRepository;
import com.example.demo.repository.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    IScheduleRepository scheduleRepository;
    IDentistRepository dentistRepository;

    @Override
    public String addSchedule(ScheduleDTO scheduleDTO) {

        Dentist dentist = dentistRepository.getById(scheduleDTO.getDentistId());

        Schedule schedule = new Schedule();
        schedule.setDentist(dentist);
        schedule.setDate(scheduleDTO.getDate());

        scheduleRepository.save(schedule);

        return "Se agregó correctamente la agenda del dentista " + schedule.getDentist().getName();
    }

    @Override
    public ScheduleDTO retrieveSchedule(Long id) {

        Optional<Schedule> item = scheduleRepository.findById(id);

        if (item.isEmpty()) {
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGUNA AGENDA");
        }

        Schedule schedule = item.get();

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setDate(schedule.getDate());
        scheduleDTO.setDentistId(schedule.getDentist().getId());

        return scheduleDTO;
    }

    @Override
    public String updateSchedule(ScheduleDTO scheduleDTO) {

        Optional<Dentist> optionalDentist = dentistRepository.findById(scheduleDTO.getDentistId());

        if (optionalDentist.isEmpty()) {
            throw new NoSuchElementException("NO EXISTE NINGÚN DENTISTA CON ESE ID");
        }

        Optional<Schedule> item = scheduleRepository.findById(scheduleDTO.getId());

        if (item.isEmpty()) {
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGUNA AGENDA");
        }

        Schedule schedule = new Schedule();
        schedule.setId(scheduleDTO.getId());
        schedule.setDentist(optionalDentist.get());
        schedule.setDate(scheduleDTO.getDate());

        scheduleRepository.save(schedule);
        return "Se actualizó correctamente la agenda del dentista " + schedule.getDentist().getName();
    }

    @Override
    public String deleteSchedule(Long id) {

        Optional<Schedule> item = scheduleRepository.findById(id);

        if (item.isEmpty()) {
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGUNA AGENDA");
        }

        scheduleRepository.deleteById(id);
        return "Se eliminó correctamente la agenda con el ID " + id;
    }


}