package com.desafio2.testing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadModel {

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    private String prop_name;
    @Valid private BarrioModel district;
    @Valid private ArrayList<AmbienteModel> ambientes;
    private int cantAmbientes;



}
