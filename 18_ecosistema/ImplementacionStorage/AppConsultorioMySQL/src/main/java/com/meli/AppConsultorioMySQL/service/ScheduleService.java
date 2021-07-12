package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import com.meli.AppConsultorioMySQL.models.DTO.AppointmentDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleRequestDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleResponseDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;
import com.meli.AppConsultorioMySQL.models.Schedule;
import com.meli.AppConsultorioMySQL.repositories.IDentistRepository;
import com.meli.AppConsultorioMySQL.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{

    @Autowired
    ModelMapper mapper;

    IScheduleRepository iScheduleRepository;
    IDentistRepository iDentistRepository;

    @Override
    public String addSchedule(ScheduleRequestDTO scheduleDTO) {

        Dentist dentist = iDentistRepository.getById(scheduleDTO.getDentist().getId());

        Schedule schedule = new Schedule();
        schedule.setDentist(dentist);
        schedule.setDate_finish(scheduleDTO.getDate_finish());
        schedule.setDate_init(scheduleDTO.getDate_init());
        iScheduleRepository.save(schedule);

        return "Se agregó correctamente la agenda del dentista " + schedule.getDentist().getName();
    }

    @Override
    public ScheduleResponseDTO retrieveSchedule(Long id) {

        Optional<Schedule> item = iScheduleRepository.findById(id);

        if (item.isEmpty()) {
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGUNA AGENDA");
        }

        Schedule schedule = item.get();

        ScheduleResponseDTO scheduleResponseDTO = new ScheduleResponseDTO();
        scheduleResponseDTO.setId(schedule.getId());
        scheduleResponseDTO.setDentist(schedule.getDentist());
        scheduleResponseDTO.setDate_finish(schedule.getDate_finish());
        scheduleResponseDTO.setDate_init(schedule.getDate_init());

        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();
        schedule.getApoointment().forEach(apoointment -> appointmentDTOS.add(mapFromAppointment(apoointment)));
        scheduleResponseDTO.setApoointment(appointmentDTOS);

        return scheduleResponseDTO;
    }

    private AppointmentDTO mapFromAppointment(Apoointment apoointment){

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDurations(apoointment.getDurations());
        appointmentDTO.setStatus(apoointment.getStatus());
        appointmentDTO.setDate(apoointment.getDate());

        return appointmentDTO;
    }


    @Override
    public String updateSchedule(ScheduleResponseDTO scheduleResponseDTO) {

        Optional<Dentist> optionalDentist = iDentistRepository.findById(scheduleResponseDTO.getDentist().getId());

        if (optionalDentist.isEmpty()) {
            throw new NoSuchElementException("NO EXISTE NINGÚN DENTISTA CON ESE ID");
        }

        Optional<Schedule> item = iScheduleRepository.findById(scheduleResponseDTO.getId());

        if (item.isEmpty()) {
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGUNA AGENDA");
        }

        Schedule schedule = new Schedule();
        schedule.setId(scheduleResponseDTO.getId());
        schedule.setDentist(optionalDentist.get());
        schedule.setDate_init(scheduleResponseDTO.getDate_init());
        schedule.setDate_finish(scheduleResponseDTO.getDate_finish());

        iScheduleRepository.save(schedule);
        return "Se actualizó correctamente la agenda del dentista " + schedule.getDentist().getName();
    }

    @Override
    public String deleteSchedule(Long id) {

        Optional<Schedule> item = iScheduleRepository.findById(id);

        if (item.isEmpty()) {
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGUNA AGENDA");
        }

        iScheduleRepository.deleteById(id);
        return "Se eliminó correctamente la agenda con el ID " + id;
    }


    @Override
    public List<ScheduleDTO> getScheduleByDentist( Long idDentist) {
        List<Schedule> schedules = iScheduleRepository.getScheduleByDentist(idDentist);
        return schedules.stream().map(schedule -> mapper.map(schedule, ScheduleDTO.class)).collect(Collectors.toList());

    }

}
