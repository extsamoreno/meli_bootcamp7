package com.example.demo.services;

import com.example.demo.exceptions.AppoimentNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.model.enums.StateAppoiment;
import com.example.demo.repositories.IAppoimentRepository;
import com.example.demo.services.dtos.AppointmentDTO;
import com.example.demo.services.mappers.AppointmentMapper;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Functions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<AppointmentDTO> appoimentPendingByDate(Date date) {
        return appoimentRepository.findByDateBetweenAndState(Functions.atStartOfDay(date),Functions.atEndOfDay(date),StateAppoiment.Pendiente)
                .stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String reprogrametAppointment(Appointment appointment, Long idPastAppointment) throws AppoimentNotFoundException {
        Appointment appointment1= appoimentRepository.findById(idPastAppointment).orElseThrow(() -> new AppoimentNotFoundException(idPastAppointment));
        Appointment saveAppointment= appoimentRepository.save(appointment);
        appointment1.setNewAppointmentId(saveAppointment.getId());
        appointment1.setState(StateAppoiment.Reprogramado);
        appoimentRepository.save(appointment1);
        return "La cita se ha Reprogramado Satisfactoriamente";
    }

    @Override
    public List<AppointmentDTO> getReprogrametAppointmentByDoctorId(Long idDentist) {
        return appoimentRepository.findNewRescheduleAppointmentById(StateAppoiment.Reprogramado,idDentist)
                .stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getReprogrametAppointment() {
        return appoimentRepository.findNewRescheduleAppointmentById(StateAppoiment.Reprogramado)
                .stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }
}
