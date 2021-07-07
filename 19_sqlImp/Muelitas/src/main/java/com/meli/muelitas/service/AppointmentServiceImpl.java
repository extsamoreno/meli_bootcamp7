package com.meli.muelitas.service;

import com.meli.muelitas.dto.*;
import com.meli.muelitas.exception.AppointmentNotBeTodayException;
import com.meli.muelitas.exception.AppointmentNotExistsException;
import com.meli.muelitas.exception.DentistNotAvailableException;
import com.meli.muelitas.exception.PatientHaveOtherAppointment;
import com.meli.muelitas.mapper.MapStructConverter;
import com.meli.muelitas.model.Appointment;
import com.meli.muelitas.repository.IAppointmentRepository;
import com.meli.muelitas.util.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;

    @Autowired
    IDentistService dentistService;

    @Autowired
    IPatientService patientService;

    @Autowired
    IDentistAvailabilityService dentistAvailabilityService;

    @Override
    public void createAppointment(AppointmentInDTO appointmentInDTO) {
        AppointmentDTO appointmentDTO = validationsNewAppointment(appointmentInDTO);
        appointmentDTO.setStatus(AppointmentStatus.PENDIENTE.name());
        appointmentRepository.save(MapStructConverter.MAPPER.appointmentDTOToAppointment(appointmentDTO));
    }

    @Override
    public List<AppointmentDTO> getAppointmentByPatientNit(String patientNit) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findByPatientNitOrderByAppointmentDateDesc(patientNit));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByDentistName(String dentistName) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByDentistNameLikeOrderByAppointmentDateDesc(dentistName));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByDentistId(Long dentistId) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByDentistIdOrderByAppointmentDateDesc(dentistId));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByDate(LocalDate date) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByAppointmentDateOrderByAppointmentDateAsc(date));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByMonth(int month) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByAppointmentDate_MonthOrderByAppointmentDateAsc(month));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByStatus(String status) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByStatusOrderByAppointmentDateDesc(status));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByStatusAndDate(String status, LocalDate date) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByStatusAndAppointmentDateOrderByAppointmentDateDesc(status, date));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListRescheduledByDentistName(String dentistName) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByDentistNameAndAppointmentCancelledNotNullOrderByAppointmentDateDesc(dentistName));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListRescheduledByDentistId(Long dentistId) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(appointmentRepository.findAllByDentistIdAndAppointmentCancelledNotNullOrderByAppointmentDateDesc(dentistId));
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByDentistIdAndDateBetweenTime(Long dentistId, LocalDate appointmentDate, LocalTime toTime, LocalTime fromTime) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(
                appointmentRepository.findAllByDentistIdAndAppointmentDateAndAppointmentTimeIsBetween(dentistId, appointmentDate, toTime, fromTime)
        );
    }

    @Override
    public List<AppointmentDTO> getAppointmentListByPatientNitAndDateAndStatusAndBetweenTime(String patientNit, LocalDate appointmentDate, LocalTime toTime, LocalTime fromTime) {
        return MapStructConverter.MAPPER.appointmentListToAppointmentDTOList(
                appointmentRepository
                        .findAllByPatientNitAndAppointmentDateAndStatusAndAppointmentTimeIsBetween(patientNit, appointmentDate, AppointmentStatus.PENDIENTE.name(), toTime, fromTime)
        );
    }

    @Override
    public void cancelAppointmentById(Long appointmentId) {
        updateAppointmentStatus(appointmentId, AppointmentStatus.CANCELADO.name());
    }

    @Override
    public void endAppointmentById(Long appointmentId) {
        updateAppointmentStatus(appointmentId, AppointmentStatus.FINALIZADO.name());
    }

    @Override
    @Transactional
    public void rescheduleAppointmentById(Long appointmentId, LocalDate newAppointmentDate, LocalTime newAppointmentTime) {
        updateAppointmentStatus(appointmentId, AppointmentStatus.REPROGRAMADO.name());
        Appointment appointment = appointmentRepository.getById(appointmentId);
        AppointmentInDTO appointmentInDTO = new AppointmentInDTO(appointment.getPatient().getId(), appointment.getDentist().getId(), newAppointmentDate, newAppointmentTime);
        validationsNewAppointment(appointmentInDTO);
        Appointment appointmentRescheduled = new Appointment(null,
                appointment.getPatient(),
                appointment.getDentist(),
                newAppointmentDate,
                newAppointmentTime,
                AppointmentStatus.PENDIENTE.name(),
                appointment
        );
        appointmentRepository.save(appointmentRescheduled);
    }

    private void updateAppointmentStatus(Long appointmentId, String status) {
        Appointment appointment = existsAppointment(appointmentId);
        if (appointment.getStatus().compareTo(AppointmentStatus.FINALIZADO.name()) != 0) {
            appointment.setStatus(status);
            appointmentRepository.save(appointment);
        }
    }

    private Appointment existsAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotExistsException(appointmentId));
    }

    private boolean checkAppointmentTimeWithDentistAvailability(LocalTime appointmentTime, DentistAvailabilityDTO dentistAvailabilityDTO) {
        return ((appointmentTime.isAfter(dentistAvailabilityDTO.getDayStart()) || appointmentTime.equals(dentistAvailabilityDTO.getDayStart()))
                &&
                appointmentTime.isBefore(dentistAvailabilityDTO.getBreakStart().minus(30, ChronoUnit.MINUTES)))
                ||
                ((appointmentTime.isAfter(dentistAvailabilityDTO.getBreakEnd()) || appointmentTime.equals(dentistAvailabilityDTO.getBreakEnd()))
                        &&
                        appointmentTime.isBefore(dentistAvailabilityDTO.getDayEnd().minus(30, ChronoUnit.MINUTES)));
    }

    private boolean checkDentistHaveOtherAppointment(Long dentistId, LocalDate appointmentDate, LocalTime appointmentTime) {
        List<AppointmentDTO> appointmentDTOList = getAppointmentListByDentistIdAndDateBetweenTime(dentistId, appointmentDate, appointmentTime.minusMinutes(30), appointmentTime.plusMinutes(30));
        return appointmentDTOList.size() > 0;
    }

    private boolean checkPatientHaveOtherAppointment(String patientNit, LocalDate appointmentDate, LocalTime appointmentTime) {
        List<AppointmentDTO> appointmentDTOList = getAppointmentListByPatientNitAndDateAndStatusAndBetweenTime(patientNit, appointmentDate, appointmentTime.minusMinutes(30), appointmentTime.plusMinutes(30));
        return appointmentDTOList.size() > 0;
    }

    private AppointmentDTO validationsNewAppointment(AppointmentInDTO appointmentInDTO) {
        AppointmentDTO appointmentDTO = MapStructConverter.MAPPER.appointmentInDTOToAppointmentDTO(appointmentInDTO);
        Long dentistId = appointmentInDTO.getPatientId();
        LocalTime appointmentTime = appointmentInDTO.getAppointmentTime();
        String dayOfWeek = appointmentDTO.getAppointmentDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        //TODO: Check date after today
        LocalDate today = LocalDate.now();
        if (today.isEqual(appointmentDTO.getAppointmentDate())) throw new AppointmentNotBeTodayException();
        //TODO:check exists patient
        PatientDTO patientDTO = patientService.getPatientById(dentistId);
        appointmentDTO.setPatientDTO(patientDTO);
        //TODO:check exists dentist
        DentistDTO dentistDTO = dentistService.getDentistById(dentistId);
        appointmentDTO.setDentistDTO(dentistDTO);
        //TODO:check dentist availability
        DentistAvailabilityDTO dentistAvailabilityDTO = dentistAvailabilityService.getAllByDayOfWeekAndDentistIsActiveAndDentistId(dayOfWeek, dentistId);
        boolean dentistHasAvailability = checkAppointmentTimeWithDentistAvailability(appointmentTime, dentistAvailabilityDTO);
        if (!dentistHasAvailability) throw new DentistNotAvailableException(dentistId);
        //TODO:check dentist doesn't have other appointment at the same time
        boolean dentistHasAppointments = checkDentistHaveOtherAppointment(dentistId, appointmentInDTO.getAppointmentDate(), appointmentTime);
        if (dentistHasAppointments) throw new DentistNotAvailableException(dentistId);
        //TODO:check patient doesn't have other appointment
        boolean patientHasAppointment = checkPatientHaveOtherAppointment(patientDTO.getNit(), appointmentDTO.getAppointmentDate(), appointmentTime);
        if (patientHasAppointment) throw new PatientHaveOtherAppointment(patientDTO.getName());
        return appointmentDTO;
    }

}
