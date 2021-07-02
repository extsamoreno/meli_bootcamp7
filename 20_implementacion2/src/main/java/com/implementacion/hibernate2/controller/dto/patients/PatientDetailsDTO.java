package com.implementacion.hibernate2.controller.dto.patients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailsDTO {
    private String patient_name;
    private String dentist_name;
    private String status_appointment;
}
