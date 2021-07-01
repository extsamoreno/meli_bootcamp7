package com.example.muelitas.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cancellationDate;
    private String status;
    private ProfessionalDTO professional;
    private PatientDTO patient;
}
