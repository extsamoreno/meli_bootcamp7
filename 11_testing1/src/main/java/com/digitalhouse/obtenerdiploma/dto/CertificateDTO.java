package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO extends StudentDTO {

  @NotBlank(message = "El nombre del alumno no puede estar vacío.")
  @Pattern(regexp="^[A-Z].*",message="El nombre de la materia debe comenzar con mayúscula")
  @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
  private String studentName;

  @NotBlank(message = "El mensaje no puede estar vacío.")
  private String message;

  @NotBlank(message = "El promedio no puede estar vacío.")
  private Double averageScore;

  @NotEmpty(message = "La lista no puede ser vacía.")
  private List<SubjectDTO> subjects;
}
