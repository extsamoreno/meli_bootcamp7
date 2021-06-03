package com.example.spring3.services.interfaces;

import com.example.spring3.dtos.FoodDTO;
import com.example.spring3.dtos.ResponseFoodDTO;

import java.util.List;

public interface IFoodService {

    ResponseFoodDTO getCalories(FoodDTO foodDTO);
    List<ResponseFoodDTO> getPlatesCalories(FoodDTO[] foodDTO);
}
