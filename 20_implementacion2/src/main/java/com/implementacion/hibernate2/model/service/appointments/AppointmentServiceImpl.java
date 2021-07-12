package com.implementacion.hibernate2.model.service.appointments;

import com.implementacion.hibernate2.controller.dto.appointments.AppointmentDTO;
import com.implementacion.hibernate2.controller.dto.patients.request.NewAppointmentDTO;
import com.implementacion.hibernate2.model.entity.Appointment;
import com.implementacion.hibernate2.model.entity.Patient;
import com.implementacion.hibernate2.model.entity.Schedule;
import com.implementacion.hibernate2.model.repository.AppointmentRepository;
import com.implementacion.hibernate2.model.repository.DentistRepository;
import com.implementacion.hibernate2.model.repository.PatientRepository;
import com.implementacion.hibernate2.model.repository.ScheduleRepository;
import com.implementacion.hibernate2.model.service.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements IAppointmentService{


    private final AppointmentRepository appointmentRepository;
    private final ModelMapper mapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper mapper){
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AppointmentDTO> listAllAppointmentsByStatus(String status) {
        List<Appointment> appointmentList = appointmentRepository.findAllByStatus(status);
        List<AppointmentDTO> appointmentDTOList = appointmentList.stream()
                .map( a -> new AppointmentDTO(a.getId(),a.getStatus(),a.getDate(),a.getPatient().getName(),a.getSchedule().getDentist().getName()) )
                .collect(Collectors.toList());
        return appointmentDTOList;
    }

    @Override
    public List<AppointmentDTO> listAllAppointmentsByStatusAndDate(String status, String sDate) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate date = LocalDate.parse(sDate, formatter);
        Date actualDate = Utils.convertDate(sDate);
        List<Appointment> appointmentList = appointmentRepository.findAllByStatusAndDate(status, actualDate);
        List<AppointmentDTO> appointmentDTOList = appointmentList.stream()
                .map( a -> new AppointmentDTO(a.getId(),a.getStatus(),a.getDate(),a.getPatient().getName(),a.getSchedule().getDentist().getName()) )
                .collect(Collectors.toList());
        return appointmentDTOList;
    }

    @Override
    @Transactional
    public void insertNewAppointment(NewAppointmentDTO newAppointmentDTO) {
        Patient currentPatient = patientRepository.getById(newAppointmentDTO.getPatient_id());
        Schedule currentSchedule = scheduleRepository.getById(newAppointmentDTO.getSchedule_id());

        Appointment appointment= mapper.map(newAppointmentDTO, Appointment.class);
        appointment.setPatient(currentPatient);
        appointment.setSchedule(currentSchedule);
        appointmentRepository.save(appointment);
    }


}
