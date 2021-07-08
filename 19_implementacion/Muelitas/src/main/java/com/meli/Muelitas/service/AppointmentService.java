package com.meli.Muelitas.service;

import com.meli.Muelitas.model.Appointment;
import com.meli.Muelitas.model.DTO.AppointmentDTO;
import com.meli.Muelitas.repositories.IAppointmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService{


    @Autowired
    ModelMapper mapper;

    IAppointmentRepository iAppointmentRepository;

    @Override
    public List<AppointmentDTO> getAppointmentFinish() throws ParseException {
        List<Appointment> appointments = iAppointmentRepository.getAppointmentFinish();
        return appointments.stream().map(appointment -> mapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentPendingByDate(String date) throws ParseException {

        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Appointment> appointments = iAppointmentRepository.getAppointmentPendingByDate(date_convert);
        return appointments.stream().map(appointment -> mapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<AppointmentDTO> getAppointmentsReprogrammed(Long idDentist) throws ParseException {
        List<Appointment> appointments = iAppointmentRepository.getAppointmentsReprogrammedByProf(idDentist);
        return appointments.stream().map(appointment -> mapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsReprogrammedAllDentist() throws ParseException {

        List<Appointment> appointments = iAppointmentRepository.getAppointmentsReprogrammed();
        return appointments.stream().map(appointment -> mapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());

    }








}
