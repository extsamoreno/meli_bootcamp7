package com.example.AppConsultorioMySQL.Exceptions;

import com.example.AppConsultorioMySQL.models.entities.Dentist;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class DentistNotFoundException extends ConsultoryException{
    public DentistNotFoundException(Optional<Dentist> dentistId) {
        super("The dentist " + dentistId + " does not exist", HttpStatus.BAD_REQUEST);
    }
}
