package com.example.demo.service;

import com.example.demo.dto.DentistDTO;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.entity.Schedule;
import com.example.demo.repository.IDentistRepository;
import com.example.demo.repository.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {

    IDentistRepository dentistRepository;
    IScheduleRepository scheduleRepository;

    @Override
    public String addDentist(Dentist dentist) {
        dentistRepository.save(dentist);
        return "Se insertó correctamente el dentista " + dentist.getName();
    }

    @Override
    public DentistDTO retrieveDentist(Long id) {

        Optional<Dentist> item = dentistRepository.findById(id);

        if (item.isEmpty()){
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGÚN DENTISTA");
        }

        Dentist dentist = item.get();

        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setId(dentist.getId());
        dentistDTO.setEnrollment(dentist.getEnrollment());
        dentistDTO.setName(dentist.getName());

        Set<ScheduleDTO> scheduleDTOS = new HashSet<>();

        Collection<Schedule> schedules = scheduleRepository.getSchedulesByDentistId(id);
        schedules.forEach(schedule -> scheduleDTOS.add(mapFromSchedule(schedule)));

        dentistDTO.setSchedules(scheduleDTOS);

        return dentistDTO;
    }

    private ScheduleDTO mapFromSchedule(Schedule schedule){

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setDentistId(schedule.getDentist().getId());
        scheduleDTO.setDate(schedule.getDate());

        return scheduleDTO;
    }

    @Override
    public String updateDentist(Dentist dentist) {
        Optional<Dentist> item = dentistRepository.findById(dentist.getId());

        if (item.isEmpty()){
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGÚN DENTISTA");
        }

        dentistRepository.save(dentist);
        return "Se actualizó correctamente el dentista " + dentist.getName();
    }

    @Override
    public String deleteDentist(Long id) {
        Optional<Dentist> item = dentistRepository.findById(id);

        if (item.isEmpty()){
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGÚN DENTISTA");
        }

        dentistRepository.deleteById(id);
        return "Se eliminó correctamente el dentista con el ID " + id;
    }

}