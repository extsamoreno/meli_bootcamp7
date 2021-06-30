package com.example.practica_1_integration.services;

import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.repositories.IConsultingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultingService implements IConsultingService {

    private final IConsultingRepository iConsultingRepository;

    @Override
    public void createAppointment(Appointment appointment) {
        iConsultingRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        iConsultingRepository.delete(appointment);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return iConsultingRepository.findAll();
    }

    @Override
    public Optional<Appointment> findAppointmentById(Long id) {
        return iConsultingRepository.findById(id);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        if(!iConsultingRepository.existsById(appointment.getId())) {
            /**
             throw new Exception
             * **/
        }
        iConsultingRepository.save(appointment);
    }
}
