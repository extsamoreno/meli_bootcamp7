package com.example.AppConsultorioMySQL.Exceptions;

import com.example.AppConsultorioMySQL.models.entities.Patient;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class PatientNotFoundException extends ConsultoryException{
    public PatientNotFoundException(Optional<Patient> patientId) {
        super("The patient " + patientId + " does not exist", HttpStatus.BAD_REQUEST);
    }
}
