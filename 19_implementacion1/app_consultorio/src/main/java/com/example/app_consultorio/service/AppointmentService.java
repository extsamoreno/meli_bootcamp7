package com.example.app_consultorio.service;

import com.example.app_consultorio.dto.AppointmentDTO;
import com.example.app_consultorio.dto.DentistDTO;
import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Appointment;
import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.model.Patient;
import com.example.app_consultorio.repository.IAppointmentRepository;
import com.example.app_consultorio.repository.IDentistRepository;
import com.example.app_consultorio.repository.IPatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService {

    IAppointmentRepository appointmentRepository;
    IDentistRepository dentistRepository;
    IPatientRepository patientRepository;
    ModelMapper mapper;

    @Override
    public void createAppointment(AppointmentDTO appointmentDTO) {

        Dentist dentist = dentistRepository.getById(appointmentDTO.getDen_id());
        Patient patient = patientRepository.getById(appointmentDTO.getPat_id());

        Appointment app = mapper.map(appointmentDTO, Appointment.class);

        app.setDentist(dentist);
        app.setPatient(patient);

        appointmentRepository.save(app);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    /*@Override
    public List<AppointmentDTO> findAllAppointments() {

        List<AppointmentDTO> listAppDTO = appointmentRepository.findAll(PageRequest.of(0, 10)).getContent().
                stream().map(e -> mapper.map(e, AppointmentDTO.class)).collect(Collectors.toList());

        return listAppDTO;
    }*/

    @Override
    public List<AppointmentDTO> findAllAppointments(){

        List<Appointment> listApp = appointmentRepository.findAll(PageRequest.of(0, 10)).getContent();
        List<AppointmentDTO> listAppDTO = new ArrayList<>();

        for (Appointment app: listApp) {

            AppointmentDTO appDTO = mapper.map(app, AppointmentDTO.class);
            appDTO.setDen_id(app.getDentist().getId());
            appDTO.setPat_id(app.getPatient().getId());

            listAppDTO.add(appDTO);
        }
        return listAppDTO;
    }

    @Override
    public Appointment findAppointmentById(Long id) {
        Optional<Appointment> item = appointmentRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByStatus(String status) {
        return appointmentRepository.findAppointmentByStatus(status).stream().map(e -> mapper.map(e, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByDateAndPendiente(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return appointmentRepository.findAppointmentByDateAndStatus(localDate, "pendiente").stream().map(e -> mapper.map(e, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByDentistId(Long id) {

        return appointmentRepository.findAppointmentByDentist_Id(id).stream().map(e -> mapper.map(e, AppointmentDTO.class)).collect(Collectors.toList());

    }
}
