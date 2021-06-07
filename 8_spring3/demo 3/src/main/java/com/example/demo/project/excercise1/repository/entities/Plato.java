package com.example.demo.project.excercise1.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private int id;
    private String name;
    private List<Ingrediente> ingredientes;


    public Plato(String name, List<Ingrediente> ingredientes){
        this.name = name;
        this.ingredientes = ingredientes;
    }
}
