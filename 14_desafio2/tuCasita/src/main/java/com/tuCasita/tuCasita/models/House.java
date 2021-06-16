package com.tuCasita.tuCasita.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    @NotNull(message = "El nombre de la casa no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la casa debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "EL barrio no puede estar vacio")
    private District district;
    private ArrayList<Room> rooms;

}
