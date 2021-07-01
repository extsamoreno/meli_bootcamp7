package com.example.muelitas.service;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.model.Appointment;
import com.example.muelitas.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImple implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ResponseDTO createAppointment(AppointmentDTO newAppointment) {
        ResponseDTO response = new ResponseDTO();

        newAppointment.setPatient(modelMapper.map(newAppointment.getPatient(), PatientDTO.class));
        newAppointment.setProfessional(modelMapper.map(newAppointment.getProfessional(), ProfessionalDTO.class));

        appointmentRepository.save(modelMapper.map(newAppointment, Appointment.class));

        response.setMessage("A new appointment was created");
        response.setStatus(201);
        return response;
    }

    @Override
    public AppointmentDTO readAppointment(Long idAppointment) {
        AppointmentDTO responseAppointment;
        Optional<Appointment> dbAppointment;

        dbAppointment = appointmentRepository.findById(idAppointment);

        responseAppointment = modelMapper.map(dbAppointment.get(), AppointmentDTO.class);
        return responseAppointment;
    }

    @Override
    public ResponseDTO updateAppointment(AppointmentDTO updatedAppointment) {
        ResponseDTO response = new ResponseDTO();

        updatedAppointment.setPatient(modelMapper.map(updatedAppointment.getPatient(), PatientDTO.class));
        updatedAppointment.setProfessional(modelMapper.map(updatedAppointment.getProfessional(), ProfessionalDTO.class));

        appointmentRepository.save(modelMapper.map(updatedAppointment, Appointment.class));

        response.setMessage("An existent appointment was updated");
        response.setStatus(200);
        return response;
    }

    @Override
    public ResponseDTO deleteAppointment(Long idAppointment) {
        ResponseDTO response = new ResponseDTO();

        appointmentRepository.deleteById(idAppointment);

        response.setMessage("An appointment was deleted");
        response.setStatus(200);
        return response;
    }
}
