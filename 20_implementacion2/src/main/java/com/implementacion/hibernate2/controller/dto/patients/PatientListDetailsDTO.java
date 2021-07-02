package com.implementacion.hibernate2.controller.dto.patients;

import com.implementacion.hibernate2.controller.dto.patients.PatientDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientListDetailsDTO {

    private String date;
    private List<PatientDetailsDTO> patients;

}
