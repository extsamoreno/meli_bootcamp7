package com.meli.spring.Services;

import com.meli.spring.Classes.Plato;
import com.meli.spring.Dto.PlatoDto;

import java.util.List;

public interface FoodService {
    PlatoDto transformPlate(Plato plato);
    List<PlatoDto> transformAllPlate(List<Plato> platoList);
}
