package spring3.demo.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring3.demo.Models.Entities.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDTO {
    int totalCalories;
    List<Ingredient> ingredients;
    Ingredient maxCaloriesIngredient;
}
