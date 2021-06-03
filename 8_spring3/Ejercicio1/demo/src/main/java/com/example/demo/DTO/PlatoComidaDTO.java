package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoComidaDTO {

    private String nombre;
    private List<IngredienteDTO> listaIngredientes;
    private Integer caloriaTotales;
    private IngredienteDTO ingredienteDTOMasCalorifico;


}
