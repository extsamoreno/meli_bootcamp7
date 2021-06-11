package com.digitalhouse.obtenerdiploma.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SubjectDTO implements Serializable {

  @NotNull(message = "nombre no puede ser nullo")
  @NotEmpty(message = "nombre debe contener caracteres")
  @Size(max = 30, message = "El nombre debería tener menos de 30 caracteres")
  @Pattern(regexp = "^[A-Z].*" , message = "nombre debe comenzar con mayuscula")
  private String name;



  @DecimalMin(value = "0.0", message = "la nota debe ser mayor a 0.0")
  @DecimalMax(value = "10.0",message = "la nota debe ser menor a 10.0")
  @NotNull(message = "nota no puede ser vacia")
  private Double score;

}
