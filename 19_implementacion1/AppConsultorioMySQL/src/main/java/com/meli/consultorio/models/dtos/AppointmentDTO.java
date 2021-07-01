package com.meli.consultorio.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    @JsonFormat(pattern="dd-MM-yyyy hh:mm:ss")
    private Date appointmentDate;
    private String state;
    private Long nextAppointment;
    private Long dentistId;
    private Long patientId;
}
