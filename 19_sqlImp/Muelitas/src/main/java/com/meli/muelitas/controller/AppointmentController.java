package com.meli.muelitas.controller;

import com.meli.muelitas.dto.AppointmentDTO;
import com.meli.muelitas.dto.AppointmentInDTO;
import com.meli.muelitas.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping("/newAppointment")
    ResponseEntity<Void> addNewAppointment(@RequestBody @Valid AppointmentInDTO appointmentInDTO) {
        appointmentService.createAppointment(appointmentInDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listByPatientNit/{patientNit}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByPatientNit(@PathVariable String patientNit) {
        return new ResponseEntity<>(appointmentService.getAppointmentByPatientNit(patientNit), HttpStatus.OK);
    }

    @GetMapping("/listByDentistId/{dentistId}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByDentistId(@PathVariable Long dentistId) {
        return new ResponseEntity<>(appointmentService.getAppointmentListByDentistId(dentistId), HttpStatus.OK);
    }

    @GetMapping("/listByDentistName/{dentistName}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByDentistName(@PathVariable String dentistName) {
        return new ResponseEntity<>(appointmentService.getAppointmentListByDentistName(dentistName), HttpStatus.OK);
    }

    @GetMapping("/listByDate/{date}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(appointmentService.getAppointmentListByDate(date), HttpStatus.OK);
    }

    @GetMapping("/listByMonth/{month}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByMonth(@PathVariable int month) {
        return new ResponseEntity<>(appointmentService.getAppointmentListByMonth(month), HttpStatus.OK);
    }

    @GetMapping("/listByStatus/{status}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByStatus(@PathVariable String status) {
        return new ResponseEntity<>(appointmentService.getAppointmentListByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/listByStatusAndDate/{status}/{date}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListByStatusAndDate(@PathVariable String status, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(appointmentService.getAppointmentListByStatusAndDate(status, date), HttpStatus.OK);
    }

    @GetMapping("/listRescheduledByDentistName/{dentistName}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListRescheduledByDentistName(@PathVariable String dentistName) {
        return new ResponseEntity<>(appointmentService.getAppointmentListRescheduledByDentistName(dentistName), HttpStatus.OK);
    }

    @GetMapping("/listRescheduledByDentistId/{dentistId}")
    @ResponseBody
    ResponseEntity<List<AppointmentDTO>> getAppointmentListRescheduledByDentistId(@PathVariable Long dentistId) {
        return new ResponseEntity<>(appointmentService.getAppointmentListRescheduledByDentistId(dentistId), HttpStatus.OK);
    }

    @GetMapping("/cancelAppointment/{appointmentId}")
    @ResponseBody
    ResponseEntity<Void> cancelAppointmentById(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointmentById(appointmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/endAppointment/{appointmentId}")
    ResponseEntity<Void> endAppointmentById(@PathVariable Long appointmentId) {
        appointmentService.endAppointmentById(appointmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/rescheduledAppointment/{appointmentId}/{newDate}/{newTime}")
    ResponseEntity<Void> rescheduledAppointmentById(@PathVariable Long appointmentId, @PathVariable LocalDate newDate, @PathVariable LocalTime newTime) {
        appointmentService.rescheduleAppointmentById(appointmentId, newDate, newTime);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
