package com.example.DesafioTasaciones.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data@AllArgsConstructor@NoArgsConstructor
public class District {
    private String name;
    private Double price;

}
