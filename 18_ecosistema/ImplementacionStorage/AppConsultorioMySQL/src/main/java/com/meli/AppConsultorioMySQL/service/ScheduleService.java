package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.AppointmentDTO;
import com.meli.AppConsultorioMySQL.models.DTO.ScheduleDTO;
import com.meli.AppConsultorioMySQL.models.Patient;
import com.meli.AppConsultorioMySQL.models.Schedule;
import com.meli.AppConsultorioMySQL.repositories.IPatientRepository;
import com.meli.AppConsultorioMySQL.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{

    @Autowired
    ModelMapper mapper;

    IScheduleRepository iScheduleRepository;

    @Override
    public List<ScheduleDTO> getScheduleByDentist( Long idDentist) {
        List<Schedule> schedules = iScheduleRepository.getScheduleByDentist(idDentist);
        return schedules.stream().map(schedule -> mapper.map(schedule, ScheduleDTO.class)).collect(Collectors.toList());

    }

}
