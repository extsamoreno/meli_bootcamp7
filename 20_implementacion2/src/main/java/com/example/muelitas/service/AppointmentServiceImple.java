package com.example.muelitas.service;

import com.example.muelitas.domain.Appointment;
import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImple implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AppointmentDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentResponse = new ArrayList<>();

        for (int i = 0; i < appointments.size(); i++) {
            AppointmentDTO appointmentDTO = modelMapper.map(appointments.get(i), AppointmentDTO.class);
            appointmentResponse.add(appointmentDTO);
        }

        return appointmentResponse;
    }

    @Override
    public List<AppointmentDTO> findAllByDoctor(String idDoctor) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctor_Id(idDoctor);
        List<AppointmentDTO> appointmentResponse = new ArrayList<>();

        for (int i = 0; i < appointments.size(); i++) {
            AppointmentDTO appointmentDTO = modelMapper.map(appointments.get(i), AppointmentDTO.class);
            appointmentResponse.add(appointmentDTO);
        }

        return appointmentResponse;
    }

    @Override
    public List<AppointmentDTO> findAllCancelled() {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByStatusEqualsCancelled();
        List<AppointmentDTO> appointmentResponse = new ArrayList<>();

        for (int i = 0; i < appointments.size(); i++) {
            AppointmentDTO appointmentDTO = modelMapper.map(appointments.get(i), AppointmentDTO.class);
            appointmentResponse.add(appointmentDTO);
        }

        return appointmentResponse;
    }

    @Override
    public List<AppointmentDTO> findAllActive() {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByStatusEqualsActive();
        List<AppointmentDTO> appointmentResponse = new ArrayList<>();

        for (int i = 0; i < appointments.size(); i++) {
            AppointmentDTO appointmentDTO = modelMapper.map(appointments.get(i), AppointmentDTO.class);
            appointmentResponse.add(appointmentDTO);
        }

        return appointmentResponse;
    }
}
