package com.obtenerdiploma.validaciones.Model;

import lombok.*;


import javax.validation.constraints.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30,message = "El nombre de la materia no puede superer los 30 caracteres")
    private String nombre;


    @NotNull(message = "La nota no puede estar vacia")
    @Min(value=(long)0,message = "La mínima nota es 0.0")
    @Max(value=(long)10, message = "La máxima nota es 10")
    private double nota;


}
