package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import com.meli.AppConsultorioMySQL.models.DTO.AppointmentDTO;
import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;
import com.meli.AppConsultorioMySQL.models.DTO.PatientDTO;
import com.meli.AppConsultorioMySQL.models.DTO.ScheduleDTO;
import com.meli.AppConsultorioMySQL.models.Patient;
import com.meli.AppConsultorioMySQL.models.Schedule;
import com.meli.AppConsultorioMySQL.service.IAppointmentService;
import com.meli.AppConsultorioMySQL.service.IDentistService;
import com.meli.AppConsultorioMySQL.service.IPtientService;
import com.meli.AppConsultorioMySQL.service.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ConsultorController {

    private IPtientService iPtientService;
    private IDentistService iDentistService;
    private IAppointmentService iAppointmentService;
    private IScheduleService iScheduleService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Patient patient){
        iPtientService.createPatient(patient);
        return "Se creo el estudiante";
    }

    @GetMapping("/all_patients/{date}")
    public List<PatientDTO> getAllPatientsByDate(@PathVariable String date) throws ParseException {
        List<PatientDTO> response = iPtientService.getAllPatientsByDate(date);
        return response;
    }

    @GetMapping("/all_dentist/{date}")
    public List<DentistDTO> getDentistTwoApoointment(@PathVariable String date) throws ParseException {
        List<DentistDTO> response = iDentistService.getDentistTwoApoointment(date);
        return response;
    }

    @GetMapping("/appointment_finish")
    public List<AppointmentDTO> getAppointmentFinish() throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentFinish();
        return response;
    }

    @GetMapping("/appointment_pending_by_date/{date}")
    public List<AppointmentDTO> getAppointmentPendingByDate(@PathVariable String date) throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentPendingByDate(date);
        return response;
    }

    @GetMapping("/schedule_Dentist/{idDentist}")
    public List<ScheduleDTO> getScheduleByDentist(@PathVariable Long idDentist) throws ParseException {
        List<ScheduleDTO> response = iScheduleService.getScheduleByDentist(idDentist);
        return response;
    }

    @GetMapping("/appointment_reprogrammed/{idDentist}")
    public List<AppointmentDTO> getAppointmentsReprogrammed(@PathVariable Long idDentist) throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentsReprogrammed(idDentist);
        return response;
    }

    @GetMapping("/appointment_reprogrammed_all")
    public List<AppointmentDTO> getAppointmentsReprogrammed() throws ParseException {
        List<AppointmentDTO> response = iAppointmentService.getAppointmentsReprogrammedAllDentist();
        return response;
    }
}
