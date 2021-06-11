package com.example.diplomatesting.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SubjectDTO {

  @NotEmpty(message = "El nombre de la mateeria no debe ser vacío.")
  @Size(max=30, message = "La longitud del nombre de la materia no debe exceder los 30 caracteres.")
  @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "El nombre de la materia debe empezar con mayúscula.")
  private String name;

  @NotNull(message = "La nota no puede ser vacía.")
  @Min(value = 0, message = "La mínima es 0.0")
  @Max(value = 10, message = "La nota máxima es 10.0")
  private Integer score;

}
