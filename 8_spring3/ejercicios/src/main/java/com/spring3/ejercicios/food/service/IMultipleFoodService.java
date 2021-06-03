package com.spring3.ejercicios.food.service;

import java.util.List;

public interface IMultipleFoodService {

    List<FoodResponseDTO> multipleResponseFoodDTO(List<FoodDTO> listFoodDTO);

}
