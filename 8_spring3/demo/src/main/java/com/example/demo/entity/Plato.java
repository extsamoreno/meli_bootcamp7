package com.example.demo.entity;

import com.example.demo.service.dto.IngredienteDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class Plato {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
}
