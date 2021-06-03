package com.meli.spring.Repositories;

import com.meli.spring.Classes.Ingrediente;
import com.meli.spring.Dto.IngredienteDto;

public interface FoodRepository {
    IngredienteDto findCalorias(Ingrediente ingrediente);
}
