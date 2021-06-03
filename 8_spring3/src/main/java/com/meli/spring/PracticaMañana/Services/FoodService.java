package com.meli.spring.PracticaMañana.Services;

import com.meli.spring.PracticaMañana.Classes.Plato;
import com.meli.spring.PracticaMañana.Dto.PlatoDto;

import java.util.List;

public interface FoodService {
    PlatoDto transformPlate(Plato plato);
    List<PlatoDto> transformAllPlate(List<Plato> platoList);
}
