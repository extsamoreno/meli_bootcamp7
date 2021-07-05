package com.muelitas.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muelitas.demo.models.Dentist;
import com.muelitas.demo.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnDTO {

    @Min(value = 0, message = "El id de turno debe ser mayor a 0.")
    private Long id;

    @JsonProperty("patient_id")
    @Min(value = 0, message = "El id del paciente debe ser mayor a 0.")
    private Long patientId;

    @JsonProperty("dentist_id")
    @Min(value = 0, message = "El id del dentista debe ser mayor a 0.")
    private Long dentistId;

    @JsonProperty("start_date")
    @NotNull(message = "La fecha de inicio del turno no puede estar vacia.")
    private LocalDateTime startDate;

    @JsonProperty("end_date")
    private LocalDateTime endDate;

    private Long statusId;

    @JsonProperty("reprogrammed_id")
    private Long reprogrammedId;


}
