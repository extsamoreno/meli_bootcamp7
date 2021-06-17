package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class House {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío")
    @Pattern(regexp = "^[A-Z]{1}.[^A-Z]*$", message = "El nombre de la propiedad debe comenzar con mayúscula y el resto en minúscula")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String prop_name;
    private String distric_name;
    @Valid
    private ArrayList<Environment> environmentArrayList;
}

