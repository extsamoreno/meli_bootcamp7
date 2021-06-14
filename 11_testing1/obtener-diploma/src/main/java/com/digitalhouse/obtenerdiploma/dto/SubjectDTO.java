package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class SubjectDTO {
  @NotEmpty(message = "El nombre de la materia no puede estar vacío")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
  private String name;
  @NotNull(message = "La nota no puede estar vacía")
  @Min(value = (long)0.0, message = "La mínima nota es 0.0")
  @Max(value = (long)10.0, message = "La máxima nota es 10.0")
  private Double score;
}
