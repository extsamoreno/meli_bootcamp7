package com.example.AppConsultorioMySQL.Exceptions;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import com.example.AppConsultorioMySQL.models.entities.Turn;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class TurnNotFoundException extends ConsultoryException{
    public TurnNotFoundException(Optional<Turn> turnId) {
        super("The turn " + turnId + " does not exist", HttpStatus.BAD_REQUEST);
    }
}
