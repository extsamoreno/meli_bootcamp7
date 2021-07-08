package com.meli.Muelitas.controller;

import com.meli.Muelitas.model.DTO.AppointmentDTO;
import com.meli.Muelitas.service.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@AllArgsConstructor
public class AppointmentController {

    private IAppointmentService iAppointmentService;

    @GetMapping("/finished")
    public List<AppointmentDTO> getAppointmentFinish() throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentFinish();
        return response;
    }

    @GetMapping("/pending-by-date/{date}")
    public List<AppointmentDTO> getAppointmentPendingByDate(@PathVariable String date) throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentPendingByDate(date);
        return response;
    }

    @GetMapping("/reprogrammed-by-dentist/{idDentist}")
    public List<AppointmentDTO> getAppointmentsReprogrammed(@PathVariable Long idDentist) throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentsReprogrammed(idDentist);
        return response;
    }

    @GetMapping("/reprogrammed")
    public List<AppointmentDTO> getAppointmentsReprogrammed() throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentsReprogrammedAllDentist();
        return response;
    }
}
