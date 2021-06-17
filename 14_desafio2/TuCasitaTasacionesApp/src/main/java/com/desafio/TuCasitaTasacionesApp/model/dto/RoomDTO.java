package com.desafio.TuCasitaTasacionesApp.model.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Valid
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    @NotNull
    @Pattern(message = "El nombre de la habitacion debe comenzar con mayuscula", regexp = "^[A-Z].*[a-z]$")
    @Size(min = 1, max = 30, message = "El nombre de la habitacion debe tener 30 caracteres maximo")
    private String name;

    @NotNull
    @Max(value = 10, message = "El ancho maximo es 25m")
    @Min(value = 0, message = "El ancho minimo es 0m")
    private Double width;

    @NotNull
    @Max(value = 10, message = "El largo maximo es 33m")
    @Min(value = 0, message = "El largo minimo es 0m")
    private Double lenght;
}
