package com.example.demo.dto;

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

  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la materia comenzar con mayúscula.")
  @NotNull(message="El nombre de la materia no puede estar vacío.")
  private String name;

  @NotNull(message="La nota no puede estar vacía.")
  @DecimalMax("10.0") @DecimalMin("0.0")
  //@DecimalMax("0.0",message="La mínima nota es 0.0.")
  //@DecimalMax("10.00",message="La máxima nota es 10.0.")
  private Integer score;



}
