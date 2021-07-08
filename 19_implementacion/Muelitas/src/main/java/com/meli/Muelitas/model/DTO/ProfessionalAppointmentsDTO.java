package com.meli.Muelitas.model.DTO;

import com.meli.Muelitas.model.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProfessionalAppointmentsDTO {
    private String dni;
    private String firstName;
    private String lastname;
    private Set<AppointmentDTO> appointments;

}
