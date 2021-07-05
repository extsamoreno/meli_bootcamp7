package com.muelitas.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.muelitas.demo.models.Turn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    @Min(value = 0, message = "El id debe ser mayor a 0.")
    private Long id;

    @JsonProperty("first_name")
    @NotBlank(message = "El nombre no puede estar vacio.")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres.")
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank(message = "El apellido no puede estar vacio.")
    @Size(min = 4, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres.")
    private String lastName;

    @Min(value = 1, message = "El dni debe ser mayor a 0")
    private int dni;

    @JsonProperty("low_date")
    private LocalDateTime lowDate;
}
