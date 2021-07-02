package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.dtos.DentistDto;
import com.meli.AppConsultorioMySQL.dtos.ScheduleDto;
import com.meli.AppConsultorioMySQL.repositories.IScheduleRepository;
import com.meli.AppConsultorioMySQL.repositories.entities.ScheduleEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleCrudService implements IScheduleCrudService{

    private ModelMapper mapper;

    private IScheduleRepository scheduleRepository;
    @Override
    public String addOne(ScheduleEntity schedule) {
        scheduleRepository.save(schedule);
        return "schedule added successfully";
    }

    @Override
    public ScheduleDto getById(Long id) {
        return mapper.map(scheduleRepository.findById(id).get(), ScheduleDto.class);
    }
}
