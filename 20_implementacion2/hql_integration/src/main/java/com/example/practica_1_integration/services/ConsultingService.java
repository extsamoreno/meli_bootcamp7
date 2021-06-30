package com.example.practica_1_integration.services;

import com.example.practica_1_integration.dtos.ProfessionalDTO;
import com.example.practica_1_integration.dtos.ProfessionalPatientDTO;
import com.example.practica_1_integration.dtos.TestDTO;
import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.models.Professional;
import com.example.practica_1_integration.repositories.IConsultingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
/*
    @Override
    public List<ProfessionalPatientDTO> findPatientForDay(LocalDateTime date) {
        List<Object[]> list = iConsultingRepository.findPatientsOfProfessionalByDate(date);
        List<ProfessionalPatientDTO>  result = new ArrayList<>();
        for(Object[] obj : list) {
            result.add(new ProfessionalPatientDTO(
                    obj[0].toString(), obj[1].toString(), obj[2].toString(), obj[3].toString()));
        }
        return result;
    }
*/
    @Override
    public List<Professional> findPatientForDay(LocalDateTime date) {
        return iConsultingRepository.findPatientsOfProfessionalByDate(date);
    }

    @Override
    public List<ProfessionalDTO> findProfessionalWithMoreThan2AppointmentsForDay(LocalDateTime date) {
        List<Object[]> list = iConsultingRepository.findProfessionalsByDateAndMoreThanTwoAppointments(date);
        List<ProfessionalDTO>  result = new ArrayList<>();
        for(Object[] obj : list) {
            result.add(new ProfessionalDTO(obj[0].toString(), obj[1].toString()));
        }
        return result;
    }
}
