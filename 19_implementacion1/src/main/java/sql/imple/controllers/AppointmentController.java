package sql.imple.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sql.imple.models.dto.AppointmentDTO;
import sql.imple.services.appointment.IAppointmentService;

import java.util.List;

@RestController
@RequestMapping("appointment")
@AllArgsConstructor
public class AppointmentController {


    IAppointmentService iAppointmentService;

    @PostMapping("/create")
    public String createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        iAppointmentService.createAppointment(appointmentDTO);
        return "Appointment created correctly";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        iAppointmentService.deleteAppointmentById(id);
        return "Appointment deleted correctly";
    }

    @PutMapping("/update")
    public String updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        iAppointmentService.updateAppointment(appointmentDTO);
        return "Appointment updated correctly";
    }

    @GetMapping("/getAll")
    public List<AppointmentDTO> getAllAppointment() {
        return iAppointmentService.findAllAppointments();
    }

    @GetMapping("/getDentist/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id) {
        return iAppointmentService.findAppointmentById(id);
    }


}
