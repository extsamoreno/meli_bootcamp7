package com.implementacion.hibernate2.controller.dto.appointments;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.implementacion.hibernate2.model.entity.Patient;
import com.implementacion.hibernate2.model.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    private Long id;
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    //private Long schedule_id;
    private String patient_name;
    private String dentist_name;
    //private Long patient_id;

}
