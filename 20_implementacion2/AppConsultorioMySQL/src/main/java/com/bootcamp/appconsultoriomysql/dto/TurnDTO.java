package com.bootcamp.appconsultoriomysql.dto;

import com.bootcamp.appconsultoriomysql.model.TurnStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurnDTO {
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private TurnStatus status;
    private PatientDTO patient;
    private ProfessionalDTO professional;
}
