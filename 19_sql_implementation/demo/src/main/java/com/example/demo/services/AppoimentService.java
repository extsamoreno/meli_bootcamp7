package com.example.demo.services;

import com.example.demo.model.Appointment;
import com.example.demo.model.enums.StateAppoiment;
import com.example.demo.repositories.IAppoimentRepository;
import com.example.demo.services.dtos.AppointmentDTO;
import com.example.demo.services.mappers.AppointmentMapper;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Functions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppoimentService implements IAppoimentService{

    IAppoimentRepository appoimentRepository;

    @Override
    public List<AppointmentDTO> getAppoimentsByDate(Date date) {
        return appoimentRepository.findByDateBetween(Functions.atStartOfDay(date),Functions.atEndOfDay(date))
                .stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public String addApoiment(Appointment appointment) {
        appoimentRepository.save(appointment);
        return Constants.SAVE_SUCCESS;
    }

    @Override
    public List<AppointmentDTO> getFinalizedAppointment() {
        return appoimentRepository.findByState(StateAppoiment.Finalizado)
                .stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> AppoimentPendingByDate(Date date) {
        return appoimentRepository.findByDateBetweenAndState(Functions.atStartOfDay(date),Functions.atEndOfDay(date),StateAppoiment.Pendiente)
                .stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }
}
