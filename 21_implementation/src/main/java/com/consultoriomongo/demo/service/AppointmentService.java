package com.consultoriomongo.demo.service;

import com.consultoriomongo.demo.model.Appointment;
import com.consultoriomongo.demo.repository.IAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService{

    IAppointmentRepository repository;

    @Override
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    @Override
    public List<Appointment> getAllAppointmentsByDoctor(String name) {
        return repository.findAppointmentByDoctorName(name);
    }

    @Override
    public List<Appointment> getAppointmentByStatus(String status) {
        return repository.findAppointmentByStatus(status);
    }


}