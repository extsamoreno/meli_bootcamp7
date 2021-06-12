package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

  @NotNull( message = "El nombre del alumno no puede estar vacío.")
  @Pattern(regexp = "^[A-Z].*",  message ="El nombre de la materia debe comenzar con mayúscula." )
  @Size(max = 30, min = 1 )
  private String name;

  @NotNull( message = "La nota no puede estar vacía.")
  @Min(value = 0, message = "La mínima nota es 0.0.")
  @Max(value = 10, message = "La máxima nota es 10.0.")
  private Integer score;


}