package com.example.challenge2.models;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor
@Data
public class District {

    @NotEmpty(message = "El nombre del barrio no puede ser vacío.")
    @Size(max = 45, message = "El largo del barrio no puede exceder los 45 caracteres")
    private String name;

    public District(String las_condes, double v) {

    }

    public long getPrice() {
        return 0;
    }
}
