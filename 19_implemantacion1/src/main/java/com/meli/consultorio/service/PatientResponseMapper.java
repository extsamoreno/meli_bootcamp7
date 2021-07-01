package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.PatientResponse;
import com.meli.consultorio.model.Patient;

public class PatientResponseMapper {
    public static PatientResponse toResponse(Patient patient){
        return new PatientResponse(patient.getPat_id(),patient.getPat_obra_social());
    }
}
