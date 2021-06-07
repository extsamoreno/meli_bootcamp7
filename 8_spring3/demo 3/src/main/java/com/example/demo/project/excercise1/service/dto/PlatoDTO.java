package com.example.demo.project.excercise1.service.dto;

import com.example.demo.project.excercise1.repository.entities.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {

    private String name;
    private List<Ingrediente> ingredientes;
    private Ingrediente theMostCaloric;
    private int calorias;


}
