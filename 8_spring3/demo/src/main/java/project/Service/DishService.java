package project.Service;

import project.Repository.IIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Service.dto.DishRequestDTO;
import project.Service.dto.IngredientsRequestDTO;
import project.Service.dto.IngredientsResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    IIngredientsRepository ingridientsRepository;

    @Override
    public float calculateCalories(DishRequestDTO dishDTO) {
        float totalCalories = 0;
        if (dishDTO.getIngridients().size() > 0) {
            for (IngredientsRequestDTO ing_req : dishDTO.getIngridients()) {
                totalCalories += ingridientsRepository.findIngridientsCaloriesByName(ing_req.getName()).getCalories();
            }
        }
        return totalCalories;
    }

    @Override
    public List<IngredientsResponseDTO> calculateCaloriesPerIngredients(DishRequestDTO dishDTO) {
        List<IngredientsResponseDTO> ingredients = new ArrayList<>();
        if (dishDTO.getIngridients().size() > 0) {
            for (IngredientsRequestDTO ing_req : dishDTO.getIngridients()) {
                IngredientsResponseDTO aux = ingridientsRepository.findIngridientsCaloriesByName(ing_req.getName());
                aux.setGramms(ing_req.getGramms());
                ingredients.add(aux);
            }
        }
        return ingredients;
    }

    @Override
    public IngredientsResponseDTO ingredientsMostCalories(DishRequestDTO dishDTO) {
        IngredientsResponseDTO ingredient = null;
        float max_calories = 0;
        if (dishDTO.getIngridients().size() > 0) {
            for (IngredientsRequestDTO ing_req : dishDTO.getIngridients()) {
                IngredientsResponseDTO aux = ingridientsRepository.findIngridientsCaloriesByName(ing_req.getName());
                if (aux.getCalories() > max_calories) {
                    ingredient = aux;
                    max_calories = aux.getCalories();
                    ingredient.setGramms(ing_req.getGramms());
                }
            }
        }
        return ingredient;
    }
}
