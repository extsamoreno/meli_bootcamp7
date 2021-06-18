package com.example.demo.service.dto;

import com.example.demo.models.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@Valid
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío")
    @Pattern(regexp = "^[A-Z]{1}.[^A-Z]*$", message = "El nombre de la propiedad debe comenzar con mayúscula y el resto en minúscula")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String prop_name;
    private String distric_name;
    @Valid
    private ArrayList<Environment> environmentArrayList;
}
