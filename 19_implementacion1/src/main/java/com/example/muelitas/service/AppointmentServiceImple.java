package com.example.muelitas.service;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.model.Appointment;
import com.example.muelitas.model.Patient;
import com.example.muelitas.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<PatientDTO> findAllPatientsByDate(LocalDateTime date) {
        LocalDateTime dateStart = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 00, 00, 00);
        LocalDateTime dateEnd = dateStart.plusDays(1);

        List responsePatients = new ArrayList<>();
        List patients = appointmentRepository.findAllPatientsByDate(dateStart, dateEnd);

        for (int i = 0; i < patients.size(); i++) {
            responsePatients.add(patients.get(i));
        }

        return responsePatients;
    }


}
