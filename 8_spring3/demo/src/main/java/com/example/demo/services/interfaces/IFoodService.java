package com.example.demo.services.interfaces;

import com.example.demo.DTO.FoodDTO;
import com.example.demo.DTO.ResponseFoodDTO;

import java.util.List;

public interface IFoodService {

    ResponseFoodDTO getCalories(FoodDTO foodDTO);
    List<ResponseFoodDTO> getPlatesCalories(FoodDTO[] foodDTO);
}