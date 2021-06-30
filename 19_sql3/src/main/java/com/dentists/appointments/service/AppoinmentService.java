package com.dentists.appointments.service;

import com.dentists.appointments.model.DTO.AppDTOByDate;
import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.mapper.AppMapper;
import com.dentists.appointments.repository.IAppoimentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppoinmentService implements  IAppoimentService{

    IAppoimentRepository iAppoimentRepository;

    ModelMapper mapper;

    @Override
    public Appointment getById(Long id) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return null;
    }

    @Override
    public Appointment save(Appointment appointment) {
        if (appointment.getOldAppId() == null){
            appointment.setOldAppId(0L);
        }
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        List<Appointment> appointments = iAppoimentRepository.findAppointmentBydate(LocalDate.parse(localDate,formatter));
        return appointments.stream().map((appointment -> AppMapper.toAppDTOByDate(appointment))).collect(Collectors.toList());
    }
}
