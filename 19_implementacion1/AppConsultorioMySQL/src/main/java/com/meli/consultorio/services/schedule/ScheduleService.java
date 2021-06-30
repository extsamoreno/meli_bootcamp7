package com.meli.consultorio.services.schedule;

import com.meli.consultorio.controllers.DentistController;
import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.models.Schedule;
import com.meli.consultorio.models.dtos.ScheduleDTO;
import com.meli.consultorio.repositories.IDentistRepository;
import com.meli.consultorio.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    IScheduleRepository iScheduleRepository;
    IDentistRepository iDentistRepository;
    ModelMapper mapper;

    @Override
    public void createSchedule(ScheduleDTO scheduleDTO) {
        Optional<Dentist> item = iDentistRepository.findById(scheduleDTO.getDentist_id());

        if(item.isPresent()) {
            Schedule schedule = mapper.map(scheduleDTO, Schedule.class);
            schedule.setDentist(item.get());
            iScheduleRepository.saveAndFlush(schedule);
        } else {
            //Aca va la excepcion =D
        }
    }

    @Override
    public void deleteScheduleById(Long id) {

    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {

    }

    @Override
    public List<ScheduleDTO> findDentistScheduleByDentistId(Long id) {
        return null;
    }

    @Override
    public ScheduleDTO findScheduleById(Long id) {
        return null;
    }
}
