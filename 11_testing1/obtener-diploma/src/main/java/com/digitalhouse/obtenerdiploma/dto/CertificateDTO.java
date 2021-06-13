package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO {

  @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
  //@Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre del alumno debe comenzar con mayúscula.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
  @Size(min = 1, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
  private String studentName;

  @Size(min = 1, max = 100, message = "La longitud del mensaje debe ser entre 1 y 100 caracteres.")
  private String message;

  @NotNull(message = "La nota no puede estar vacía.")
  @Min(value = 0, message = "La nota debe ser mayor a 0")
  @Max(value = 10, message = "La nota debe ser menor a 10")
  private Double averageScore;

  @NotEmpty(message = "La lista no puede ser vacía.")
  private @Valid List<SubjectDTO> subjects;


}
