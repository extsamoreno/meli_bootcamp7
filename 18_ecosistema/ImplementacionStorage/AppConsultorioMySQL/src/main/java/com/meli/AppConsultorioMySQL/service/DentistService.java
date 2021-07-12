package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import com.meli.AppConsultorioMySQL.models.DTO.*;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;
import com.meli.AppConsultorioMySQL.models.Schedule;
import com.meli.AppConsultorioMySQL.repositories.IApoointmentRepository;
import com.meli.AppConsultorioMySQL.repositories.IDentistRepository;
import com.meli.AppConsultorioMySQL.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{
    @Autowired
    ModelMapper mapper;

    IDentistRepository iDentistRepository;
    IScheduleRepository iScheduleRepository;
    IApoointmentRepository iApoointmentRepository;


    @Override
    public String addDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
        return "Se insertó correctamente el dentista " + dentist.getName();
    }

    @Override
    public DentistFullDTO retrieveDentist(Long id) {

        Optional<Dentist> item = iDentistRepository.findById(id);

        if (item.isEmpty()){
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGÚN DENTISTA");
        }

        Dentist dentist = item.get();

        DentistFullDTO dentistFullDTO = new DentistFullDTO();
        dentistFullDTO.setDni(dentist.getDni());
        dentistFullDTO.setName(dentist.getName());
        dentistFullDTO.setLastname(dentist.getLastname());

        Set<ScheduleDTO> scheduleDTOS = new HashSet<>();

        Collection<Schedule> schedules = iScheduleRepository.getSchedulesByDentistId(id);
        schedules.forEach(schedule -> scheduleDTOS.add(mapFromSchedule(schedule)));

        dentistFullDTO.setSchedules(scheduleDTOS);

        return dentistFullDTO;
    }

    private ScheduleDTO mapFromSchedule(Schedule schedule){

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setDate_finish(schedule.getDate_finish());
        scheduleDTO.setDate_init(schedule.getDate_init());
        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();
        Collection<Apoointment> apoointments = iApoointmentRepository.getAppointmentBySchedule(schedule.getId());
        apoointments.forEach(apoointment -> appointmentDTOS.add(mapFromApoointment(apoointment)));
        scheduleDTO.setApoointment(appointmentDTOS);
        return scheduleDTO;
    }

    private AppointmentDTO mapFromApoointment(Apoointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDate(appointment.getDate());
        appointmentDTO.setDurations(appointment.getDurations());
        appointmentDTO.setStatus(appointment.getStatus());
        return appointmentDTO;
    }

    @Override
    public String updateDentist(Dentist dentist) {
        Optional<Dentist> item = iDentistRepository.findById(dentist.getId());

        if (item.isEmpty()){
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGÚN DENTISTA");
        }

        iDentistRepository.save(dentist);
        return "Se actualizó correctamente el dentista " + dentist.getName();
    }

    @Override
    public String deleteDentist(Long id) {
        Optional<Dentist> item = iDentistRepository.findById(id);

        if (item.isEmpty()){
            throw new NoSuchElementException("EL ID INGRESADO NO CORRESPONDE CON NINGÚN DENTISTA");
        }

        iDentistRepository.deleteById(id);
        return "Se eliminó correctamente el dentista con el ID " + id;
    }

    @Override
    public List<DentistDTO> getDentistTwoApoointment(String date) throws ParseException {

        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Dentist> dentistList = iDentistRepository.getDentistTwoApoointment(date_convert);
        return dentistList.stream().map(dentist -> mapper.map(dentist, DentistDTO.class)).collect(Collectors.toList());

    }

}
