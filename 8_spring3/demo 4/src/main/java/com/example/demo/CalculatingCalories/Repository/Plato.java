package com.example.demo.CalculatingCalories.Repository;

import lombok.Data;
import java.util.List;


@Data
public class Plato {
    String nombre;
    List<Ingrediente> ingredientes;
}
