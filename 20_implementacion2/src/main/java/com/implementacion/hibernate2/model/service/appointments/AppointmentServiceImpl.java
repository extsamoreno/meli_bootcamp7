package com.implementacion.hibernate2.model.service.appointments;

import com.implementacion.hibernate2.controller.dto.appointments.AppointmentDTO;
import com.implementacion.hibernate2.model.entity.Appointment;
import com.implementacion.hibernate2.model.repository.AppointmentRepository;
import com.implementacion.hibernate2.model.repository.DentistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements IAppointmentService{


    private final AppointmentRepository appointmentRepository;
    private final ModelMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper mapper){
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AppointmentDTO> listAllAppointmentsByStatus(String status) {
        List<Appointment> appointmentList = appointmentRepository.findAllByStatus(status);
        List<AppointmentDTO> appointmentDTOList = appointmentList.stream()
                .map( a -> new AppointmentDTO(a.getId(),a.getStatus(),a.getDate(),a.getPatient().getName(),a.getSchedule().getDentist().getName()) )
                .collect(Collectors.toList());
        return appointmentDTOList;
    }
}
