package com.dentists.appointments.service;

import com.dentists.appointments.model.DTO.*;
import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.Dentist;
import com.dentists.appointments.model.Patient;
import com.dentists.appointments.model.Status;
import com.dentists.appointments.model.mapper.AppMapper;
import com.dentists.appointments.repository.IAppoimentRepository;
import com.dentists.appointments.repository.IDentistRepository;
import com.dentists.appointments.repository.IPantientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppoinmentService implements  IAppoimentService{

    IAppoimentRepository iAppoimentRepository;

    IDentistRepository iDentistRepository;

    IPantientRepository iPantientRepository;

    ModelMapper mapper;

    @Override
    public Appointment getById(Long id) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return iAppoimentRepository.findAll();
    }

    @Override
    public Appointment save(Appointment appointment) {
            return iAppoimentRepository.save(appointment);
    }

    @Override
    public String update(Appointment appointment) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public List<AppDTOByDate> findAllByDate(String localDate) {
        List<Appointment> appointments = iAppoimentRepository.findAppointmentByDate(checkDate(localDate));
        return appointments.stream().map((appointment -> AppMapper.toAppDTOByDate(appointment))).collect(Collectors.toList());
    }

    @Override
    public List<DentistCountDates> findDentistsByMore2App(String date) {
        return iDentistRepository.findDentistWithMoreThat2App(checkDate(date));
    }

    @Override
    public void reprogramar(AppReproRequests appRequest) {

        Patient patient = iPantientRepository.findFirstByDni(appRequest.getPatDni());
        Appointment appointment = iAppoimentRepository.findFirstByDateEqualsAndAndPatient(appRequest.getDate(), patient);

        Appointment app = new Appointment();
        app.setDate(appRequest.getNewDate());
        app.setTime(appRequest.getNewTime());
        app.setDentist(iDentistRepository.findFirstByName(appRequest.getDentName()));
        app.setPatient(patient);
        app.setStatus(Status.PENDENT);
        iAppoimentRepository.save(app);

        Appointment newApoiment = iAppoimentRepository.findFirstByDateEqualsAndAndPatient(app.getDate(), patient);
        appointment.setReProgram(newApoiment);
        editStatusApp(appointment, Status.REPROGRAM);
    }

    @Override
    public void editStatusApp(Appointment app, Status status) {
        app.setStatus(status);
        iAppoimentRepository.save(app);
    }


    private LocalDate checkDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        return LocalDate.parse(date,formatter);
    }

    @Override
    public void editApp(AppEditStatusDateRequest app) {
        Patient patient = iPantientRepository.findFirstByDni(app.getPatDni());
        Appointment appointment = iAppoimentRepository.findFirstByDateEqualsAndAndPatient(app.getDate(), patient);
        editStatusApp(appointment, app.getStatus());
    }

    @Override
    public List<AppointmentDTO> findAllStatus(Status status) {
        return mapperByListClass(iAppoimentRepository.findByStatus(status), new AppointmentDTO());
    }

    @Override
    public List<AppointmentDTO> findAllAppByStatusAndDate(String status, String date) {
        Status statusFormatter = Status.valueOf(status.toUpperCase(Locale.ROOT));
        List app = iAppoimentRepository.findByStatusAndAndDate(statusFormatter, checkDate(date));
        return mapperByListClass(app, new AppointmentDTO());

    }

    @Override
    public DentistAppDTO findDentistAppByName(String name) {
        Dentist dentist = iDentistRepository.findFirstByName(name);
        List<Appointment> appointments = iAppoimentRepository.findByDentist(dentist);
        List apps = mapperByListClass(appointments,
                new AppointmentDTOWithOutDentist());
        return new DentistAppDTO(mapper.map(dentist, DentistDTO.class), apps);
    }

    private <T> List mapperByListClass(List list, T t){
        return (List) list.stream().map(obj -> mapper.map(obj, t.getClass())).collect(Collectors.toList());
    }

    @Override
    public DentistAppDTO findDentistsByStatusApp(String name, Status status) {
        Dentist dentist = iDentistRepository.findFirstByName(name);
        List<Appointment> apps = iAppoimentRepository.findByDentistAndStatus(dentist,status);
        List appsDTO = mapperByListClass(apps, new AppointmentDTOWithOutDentist());
        return new DentistAppDTO(mapper.map(dentist, DentistDTO.class), appsDTO);
    }


}
