package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import com.meli.AppConsultorioMySQL.models.DTO.AppointmentDTO;
import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;
import com.meli.AppConsultorioMySQL.repositories.IApoointmentRepository;
import com.meli.AppConsultorioMySQL.repositories.IDentistRepository;
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

    IApoointmentRepository iApoointmentRepository;

    @Override
    public List<AppointmentDTO> getAppointmentFinish() throws ParseException {
        List<Apoointment> apoointments = iApoointmentRepository.getAppointmentFinish();
        return apoointments.stream().map(apoointment -> mapper.map(apoointment, AppointmentDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<AppointmentDTO> getAppointmentPendingByDate(String date) throws ParseException {

        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Apoointment> apoointments = iApoointmentRepository.getAppointmentPendingByDate(date_convert);
        return apoointments.stream().map(apoointment -> mapper.map(apoointment, AppointmentDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<AppointmentDTO> getAppointmentsReprogrammed(Long idDentist) throws ParseException {

        List<Apoointment> apoointments = iApoointmentRepository.getAppointmentsReprogrammed(idDentist);
        return apoointments.stream().map(apoointment -> mapper.map(apoointment, AppointmentDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<AppointmentDTO> getAppointmentsReprogrammedAllDentist() throws ParseException {

        List<Apoointment> apoointments = iApoointmentRepository.getAppointmentsReprogrammedAllDentist();
        return apoointments.stream().map(apoointment -> mapper.map(apoointment, AppointmentDTO.class)).collect(Collectors.toList());

    }








}
