package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.ScheduleNotFoundException;
import com.example.AppConsultorioMySQL.dtos.DentistDTO;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;
import com.example.AppConsultorioMySQL.dtos.ScheduleDTO;
import com.example.AppConsultorioMySQL.dtos.TurnDTO;
import com.example.AppConsultorioMySQL.models.entities.Dentist;
import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.models.entities.Schedule;
import com.example.AppConsultorioMySQL.models.entities.Turn;
import com.example.AppConsultorioMySQL.repositories.IDentistRepository;
import com.example.AppConsultorioMySQL.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{
    IScheduleRepository scheduleRepository;
    IDentistRepository dentistRepository;
    ModelMapper mapper;

    @Override
    public String createSchedule(ScheduleDTO scheduleDTO) {
        Optional<Dentist> item = dentistRepository.findById(scheduleDTO.getDentistId());

        if(item.isPresent()) {
            Schedule schedule = mapper.map(scheduleDTO, Schedule.class);
            schedule.setDentist(item.get());
            scheduleRepository.save(schedule);

            return "Se creó la agenda correctamente";
        } else {
            return "El dentista ingresado no se encuentra";
        }
    }

    @Override
    public String updateSchedule(ScheduleDTO scheduleDTO) throws ScheduleNotFoundException {
        Optional<Schedule> item = scheduleRepository.findById(scheduleDTO.getId());

        if (item == null){
            throw new ScheduleNotFoundException(item);
        }

        scheduleRepository.save(mapper.map(scheduleDTO, Schedule.class));
        return "Se Actualizó correctamente la agenda";
    }

    @Override
    public String deleteSchedule(Long id) throws ScheduleNotFoundException {
        Optional<Schedule> item = scheduleRepository.findById(id);

        if (item == null){
            throw new ScheduleNotFoundException(item);
        }

        scheduleRepository.deleteById(id);

        return "Se eliminó correctamente la agenda " + id;
    }

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules.stream().map(schedule -> mapper.map(schedule, ScheduleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO findScheduleById(Long id) throws ScheduleNotFoundException {
        Optional<Schedule> item = scheduleRepository.findById(id);

        if (item == null){
            throw new ScheduleNotFoundException(item);
        }

        return item.map(schedule -> mapper.map(schedule, ScheduleDTO.class)).orElse(null);
    }

    @Override
    public List<ScheduleDTO> listScheduleByDentist(LocalDate date, Long dentist_id) {
        List<Schedule> item = scheduleRepository.listScheduleByDentist(date, dentist_id);
        return item.stream().map(schedule -> mapper.map(schedule,ScheduleDTO.class)).collect(Collectors.toList());
    }
}
