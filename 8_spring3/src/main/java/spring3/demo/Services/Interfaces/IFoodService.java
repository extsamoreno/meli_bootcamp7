package spring3.demo.Services.Interfaces;

import spring3.demo.Models.DTOs.FoodDTO;
import spring3.demo.Models.DTOs.FoodResponseDTO;

public interface IFoodService {
    FoodResponseDTO getFoodCalories(FoodDTO foodDTO);
}
