package com.meli.consultorio.services.appointment;

import com.meli.consultorio.exceptions.AppointmentNotFoundException;
import com.meli.consultorio.exceptions.DentistNotFoundException;
import com.meli.consultorio.exceptions.PatientNotFoundException;
import com.meli.consultorio.models.Appointment;
import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.models.Patient;
import com.meli.consultorio.models.Schedule;
import com.meli.consultorio.models.dtos.AppointmentDTO;
import com.meli.consultorio.repositories.IAppointmentRepository;
import com.meli.consultorio.repositories.IDentistRepository;
import com.meli.consultorio.repositories.IPatientRepository;
import com.meli.consultorio.repositories.IScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService {

    IAppointmentRepository iAppointmentRepository;
    IDentistRepository iDentistRepository;
    IPatientRepository iPatientRepository;
    IScheduleRepository iScheduleRepository;
    ModelMapper mapper;

    @Override
    public void createAppointment(AppointmentDTO appointmentDTO) {
        Optional<Dentist> dentist = iDentistRepository.findById(appointmentDTO.getDentistId());
        Optional<Patient> patient = iPatientRepository.findById(appointmentDTO.getPatientId());

        if(dentist.isEmpty()) {
            throw new DentistNotFoundException(appointmentDTO.getDentistId());
        }

        if(patient.isEmpty()) {
            throw new PatientNotFoundException(appointmentDTO.getPatientId());
        }



        Appointment appointment = mapper.map(appointmentDTO, Appointment.class);
        appointment.setDentist(dentist.get());
        appointment.setPatient(patient.get());
        iAppointmentRepository.saveAndFlush(appointment);
    }

    private boolean availableSlot(Long id) {
        Set<Schedule> schedules = iScheduleRepository.findSchedulesByDentistId(id);
        schedules.stream().map()
        for (Schedule s : schedules) {
            if(s.getScheduleFrom() < )
        }
        return false;
    }

    @Override
    public void deleteAppointmentById(Long id) {
        if(iAppointmentRepository.findById(id).isEmpty()) {
            throw new AppointmentNotFoundException(id);
        }

        iAppointmentRepository.deleteById(id);
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        if(iAppointmentRepository.findById(appointmentDTO.getId()).isEmpty()) {
            throw new AppointmentNotFoundException(appointmentDTO.getId());
        }

        iAppointmentRepository.save(mapper.map(appointmentDTO, Appointment.class));
    }

    @Override
    public Set<AppointmentDTO> findAllAppointments() {
        return iAppointmentRepository.findAll().stream().map(a -> mapper.map(a, AppointmentDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<AppointmentDTO> findAppointmentByDentistId(Long id) {
        if(iDentistRepository.findById(id).isEmpty()) {
            throw new DentistNotFoundException(id);
        }

        return iAppointmentRepository.findAppointmentsByDentistId(id).stream().map(appointment -> mapper.map(appointment,AppointmentDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<AppointmentDTO> findAppointmentByPatientId(Long id) {
        if(iPatientRepository.findById(id).isEmpty()) {
            throw new PatientNotFoundException(id);
        }

        return iAppointmentRepository.findAppointmentsByPatientId(id).stream().map(appointment -> mapper.map(appointment,AppointmentDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public AppointmentDTO findAppointmentById(Long id) {
        Appointment appointment = iAppointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
        return mapper.map(appointment, AppointmentDTO.class);
    }

    //Listar todos los pacientes de un día de todos los dentistas.
    //Listar todos los dentistas que tengan más de dos turnos en una fecha
    //Listar todos los turnos con estado finalizado
    //Listar todos los turnos con estado pendiente de un día
    //Listar la agenda de un dentista
    //Listar todos los turnos que fueron reprogramados de un dentista (extra)
}
