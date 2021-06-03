package com.calorias.calorias.repositories;
import lombok.Data;
import java.util.List;


@Data
public class Plato {
    String nombre;
    List<Ingrediente> ingredientes;
}
