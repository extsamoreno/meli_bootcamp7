package com.meli.spring.PracticaMañana.Repositories;

import com.meli.spring.PracticaMañana.Classes.Ingrediente;
import com.meli.spring.PracticaMañana.Dto.IngredienteDto;

public interface FoodRepository {
    IngredienteDto findCalorias(Ingrediente ingrediente);
}
