package project.Service;

import project.Service.dto.DishRequestDTO;
import project.Service.dto.IngredientsRequestDTO;
import project.Service.dto.IngredientsResponse;

import java.util.List;

public interface IDishService {

    float calculateCalories(DishRequestDTO dishDTO);

    List<IngredientsRequestDTO> calculateCaloriesPerIngredients(DishRequestDTO dishDTO);

    IngredientsRequestDTO ingredientsMostCalories(DishRequestDTO dishDTO);
}
