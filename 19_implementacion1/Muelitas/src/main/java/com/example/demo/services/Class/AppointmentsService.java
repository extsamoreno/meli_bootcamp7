package com.example.demo.services.Class;

import com.example.demo.model.Appointment;
import com.example.demo.model.Boss;
import com.example.demo.repositories.IAppointmentRepository;
import com.example.demo.repositories.IBossesRepository;
import com.example.demo.services.Interface.IAppointmentsService;
import com.example.demo.services.Interface.IBossesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AppointmentsService implements IAppointmentsService {

    IAppointmentRepository iAppointmentRepository;

    @Override
    public void createAppointment(Appointment appointment){
        iAppointmentRepository.save(appointment);
    }
}
