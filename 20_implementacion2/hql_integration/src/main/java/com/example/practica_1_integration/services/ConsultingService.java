package com.example.practica_1_integration.services;

import com.example.practica_1_integration.dtos.AppointmentDTO;
import com.example.practica_1_integration.dtos.ProfessionalDTO;
import com.example.practica_1_integration.dtos.ProfessionalPatientDTO;
import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.repositories.IConsultingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConsultingService implements IConsultingService {

    private final IConsultingRepository iConsultingRepository;

    @Autowired
    ModelMapper modelMapper;

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
    @Override
    public List<ProfessionalPatientDTO> findPatientForDay(LocalDateTime date) {
        return iConsultingRepository.findPatientsOfProfessionalByDate(date).stream().map(
                s -> new ProfessionalPatientDTO(s.getProfessional().getName(), s.getProfessional().getSurname(),
                s.getPatient().getName(), s.getPatient().getSurname())).collect(Collectors.toList());
    }

    @Override
    public List<ProfessionalDTO> findProfessionalWithMoreThan2AppointmentsForDay(LocalDateTime date) {
        return iConsultingRepository.findProfessionalsByDateAndMoreThanTwoAppointments(date).stream().map(prof ->
                new ProfessionalDTO(prof.getId(), prof.getName(), prof.getSurname(), prof.getEnrollment()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findFinishedAppointments() {
        return iConsultingRepository.findFinishedAppointments().stream().map(app ->
                new AppointmentDTO(app.getId(), app.getProfessional(),
                        app.getPatient(), app.getDate(), app.getState()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findPendingAppointmentByDate(LocalDateTime date) {
        return iConsultingRepository.findPendingAppointmentByDate(date).stream().map(app ->
                new AppointmentDTO(app.getId(), app.getProfessional(),
                        app.getPatient(), app.getDate(), app.getState()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByProfessional(int id) {
        return iConsultingRepository.findAppointmentsByProfessional((long) id).stream()
                .filter(app -> !app.getState().equals("Finalizado"))
                .map(app -> new AppointmentDTO(app.getId(), app.getProfessional(),
                        app.getPatient(), app.getDate(), app.getState()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findDelayedAppointmentsByProfessional(int id) {
        return iConsultingRepository.findDelayedAppointmentsByProfessional((long) id).stream()
                .map(app -> new AppointmentDTO(app.getId(), app.getProfessional(),
                        app.getPatient(), app.getDate(), app.getState()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findDelayedAppointments() {
        return iConsultingRepository.findDelayedAppointments().stream()
                .map(app -> new AppointmentDTO(app.getId(), app.getProfessional(),
                        app.getPatient(), app.getDate(), app.getState()))
                .collect(Collectors.toList());
    }
}
