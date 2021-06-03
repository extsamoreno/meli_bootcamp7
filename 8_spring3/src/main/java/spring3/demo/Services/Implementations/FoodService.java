package spring3.demo.Services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring3.demo.Models.DTOs.FoodDTO;
import spring3.demo.Models.DTOs.FoodResponseDTO;
import spring3.demo.Models.DTOs.IngredientDTO;
import spring3.demo.Models.Entities.Ingredient;
import spring3.demo.Repository.Interfaces.IFoodRepository;
import spring3.demo.Services.Interfaces.IFoodService;

import java.util.ArrayList;

@Service
public class FoodService implements IFoodService {
    IFoodRepository iFoodRepository;

    @Autowired
    public FoodService(IFoodRepository iFoodRepository) {
        this.iFoodRepository = iFoodRepository;
    }

    @Override
    public FoodResponseDTO getFoodCalories(FoodDTO foodDTO) {
        FoodResponseDTO foodResponseDTO = new FoodResponseDTO(0, null, new Ingredient("",0));
        Ingredient ingredient = null;
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        for (IngredientDTO ingredientDTO: foodDTO.getIngredientDTOS()
             ) {
            ingredient = iFoodRepository.getIngredientByName(ingredientDTO.getName());
            ingredient.setCalories(ingredient.getCalories()* ingredientDTO.getWeight());
            foodResponseDTO.setTotalCalories(foodResponseDTO.getTotalCalories() + ingredient.getCalories());
            ingredients.add(ingredient);
            if (ingredient.getCalories() > foodResponseDTO.getMaxCaloriesIngredient().getCalories()){
                foodResponseDTO.setMaxCaloriesIngredient(ingredient);
            }
        }
        foodResponseDTO.setIngredients(ingredients);
        return foodResponseDTO;
    }
}
