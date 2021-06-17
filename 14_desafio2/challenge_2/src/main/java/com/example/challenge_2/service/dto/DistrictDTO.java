package com.example.challenge_2.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DistrictDTO {
    @NotBlank(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 30 caracteres.")
    private String name;

    //@NotNull
    //@Positive
    //@Max(4000)
    //private double price;
}
