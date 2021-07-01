package com.meli.consultorio.services.schedule;

import com.meli.consultorio.exceptions.DentistNotFoundException;
import com.meli.consultorio.exceptions.ScheduleNotFoundException;
import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.models.Schedule;
import com.meli.consultorio.models.dtos.ScheduleDTO;
import com.meli.consultorio.repositories.IDentistRepository;
import com.meli.consultorio.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    IScheduleRepository iScheduleRepository;
    IDentistRepository iDentistRepository;
    ModelMapper mapper;

    @Override
    public void createSchedule(ScheduleDTO scheduleDTO) {
        Optional<Dentist> item = iDentistRepository.findById(scheduleDTO.getDentistId());

        if(item.isEmpty()) {
            throw new DentistNotFoundException(scheduleDTO.getDentistId());
        }

        Schedule schedule = mapper.map(scheduleDTO, Schedule.class);
        schedule.setDentist(item.get());
        iScheduleRepository.saveAndFlush(schedule);
    }

    @Override
    public void deleteScheduleById(Long id) {
        if(iScheduleRepository.findById(id).isEmpty()) {
            throw new ScheduleNotFoundException(id);
        }

        iScheduleRepository.deleteById(id);
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        if(iScheduleRepository.findById(scheduleDTO.getId()).isEmpty()) {
            throw new ScheduleNotFoundException(scheduleDTO.getId());
        }

        iScheduleRepository.save(mapper.map(scheduleDTO,Schedule.class));
    }

    @Override
    public Set<ScheduleDTO> findAllSchedules() {
        return iScheduleRepository.findAll().stream().map(s -> mapper.map(s,ScheduleDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<ScheduleDTO> findDentistScheduleByDentistId(Long id) {
        if(iDentistRepository.findById(id).isEmpty()) {
            throw new DentistNotFoundException(id);
        }

        return iScheduleRepository.findSchedulesByDentistId(id).stream().map(s -> mapper.map(s,ScheduleDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public ScheduleDTO findScheduleById(Long id) {
        Schedule schedule = iScheduleRepository.findById(id).orElseThrow(() -> new ScheduleNotFoundException(id));
        return mapper.map(schedule, ScheduleDTO.class);
    }
}
