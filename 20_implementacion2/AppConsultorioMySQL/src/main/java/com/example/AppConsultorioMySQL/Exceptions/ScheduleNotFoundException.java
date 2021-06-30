package com.example.AppConsultorioMySQL.Exceptions;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class ScheduleNotFoundException extends ConsultoryException{
    public ScheduleNotFoundException(Optional<Schedule> scheduleId) {
        super("The schedule " + scheduleId + " does not exist", HttpStatus.BAD_REQUEST);
    }
}
