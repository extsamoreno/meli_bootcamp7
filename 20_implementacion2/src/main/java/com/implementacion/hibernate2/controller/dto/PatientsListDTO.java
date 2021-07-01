package com.implementacion.hibernate2.controller.dto;

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
