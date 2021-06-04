package com.calculadora.calculadoracalorias.repository;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class IngredienteRepository {
    private String name;
    private Integer calories;
}
