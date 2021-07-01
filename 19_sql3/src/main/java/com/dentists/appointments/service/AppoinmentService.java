package com.dentists.appointments.service;

import com.dentists.appointments.model.DTO.AppDTOByDate;
import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.DTO.AppReproRequests;
import com.dentists.appointments.model.DTO.DentistCountDates;
import com.dentists.appointments.model.Patient;
import com.dentists.appointments.model.Status;
import com.dentists.appointments.model.mapper.AppMapper;
import com.dentists.appointments.repository.IAppoimentRepository;
import com.dentists.appointments.repository.IDentistRepository;
import com.dentists.appointments.repository.IPantientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppoinmentService implements  IAppoimentService{

    IAppoimentRepository iAppoimentRepository;

    IDentistRepository iDentistRepository;

    IPantientRepository iPantientRepository;

    ModelMapper mapper;

    @Override
    public Appointment getById(Long id) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return null;
    }

    @Override
    public Appointment save(Appointment appointment) {
            return iAppoimentRepository.save(appointment);
    }

    @Override
    public String update(Appointment appointment) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public List<AppDTOByDate> findAllByDate(String localDate) {
        List<Appointment> appointments = iAppoimentRepository.findAppointmentBydate(checkDate(localDate));
        return appointments.stream().map((appointment -> AppMapper.toAppDTOByDate(appointment))).collect(Collectors.toList());
    }

    @Override
    public List<DentistCountDates> findDentistsByMore2App(String date) {
        return iDentistRepository.findDentistWithMoreThat2App(checkDate(date));
    }



    @Override
    public void reprogramar(AppReproRequests appRequest) {

        Patient patient = iPantientRepository.findByDni(appRequest.getPatDni());
        Appointment appointment = iAppoimentRepository.findFirstByDateEqualsAndAndPatient(appRequest.getDate(), patient);

        Appointment app = new Appointment();
        app.setDate(appRequest.getNewDate());
        app.setTime(appRequest.getNewTime());
        app.setDentist(iDentistRepository.findFirstByName(appRequest.getDentName()));
        app.setPatient(patient);
        app.setStatus(Status.PENDENT);
        iAppoimentRepository.save(app);

        Appointment newApoiment = iAppoimentRepository.findFirstByDateEqualsAndAndPatient(app.getDate(), patient);
        appointment.setReProgram(newApoiment);
        editStatusApp(appointment, Status.REPROGRAM);
    }

    @Override
    public void editStatusApp(Appointment app, Status status) {
        app.setStatus(status);
        iAppoimentRepository.save(app);
    }

    private LocalDate checkDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        return LocalDate.parse(date,formatter);
    }
}
