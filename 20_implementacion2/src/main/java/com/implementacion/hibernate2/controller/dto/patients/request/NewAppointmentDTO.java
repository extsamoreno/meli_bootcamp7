package com.implementacion.hibernate2.controller.dto.patients.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.implementacion.hibernate2.model.entity.Patient;
import com.implementacion.hibernate2.model.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAppointmentDTO {
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Long patient_id;
    private Long schedule_id;
}
