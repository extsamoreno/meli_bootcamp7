package com.calculadora.calculadoracalorias.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class PlatoRepositoryImple implements PlatoRepository {
    HashMap<String, Integer> ingredientes = new HashMap<>();

    public void obtenerIngredientes(){
        ingredientes.put("Ajo",20);
        ingredientes.put("Aceituna",30);
        ingredientes.put("Cebolla", 100);
    }
}
