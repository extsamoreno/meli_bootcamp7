package com.implementacion.hibernate2.controller.dto.patients;

import com.implementacion.hibernate2.controller.dto.patients.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientsListDTO {

    private List<PatientDTO> patients;

}
