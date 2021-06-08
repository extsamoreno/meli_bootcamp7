package project.Service;

import project.Service.dto.DishRequestDTO;
import project.Service.dto.IngredientsResponseDTO;

import java.util.List;

public interface IDishService {

    float calculateCalories(DishRequestDTO dishDTO);

    List<IngredientsResponseDTO> calculateCaloriesPerIngredients(DishRequestDTO dishDTO);

    IngredientsResponseDTO ingredientsMostCalories(DishRequestDTO dishDTO);
}
