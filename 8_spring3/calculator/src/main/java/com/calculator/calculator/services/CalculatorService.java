package com.calculator.calculator.services;

import com.calculator.calculator.dtos.IngredientDTO;
import com.calculator.calculator.dtos.PlateDTO;
import com.calculator.calculator.repositories.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CalculatorService implements ICalculatorService {

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public List<PlateDTO> calculateCaloriesByPlate(List<PlateDTO> plateDTOs) {
        List<PlateDTO> results = new ArrayList<>();
        for (PlateDTO plate :
                plateDTOs) {
            results.add(calculateCaloriesByPlate(plate));
        }
        return results;
    }

    @Override
    public PlateDTO calculateCaloriesByPlate(PlateDTO plateDTO) {
        PlateDTO plateDTO1 = new PlateDTO();
        List<IngredientDTO> ingredientDTOList = calculateCaloriesByIngredient(plateDTO);

        int calories = 0;

        for (IngredientDTO ingredient:
             ingredientDTOList) {
            calories += ingredient.getCalories();
        }

        plateDTO1.setName(plateDTO.getName());
        plateDTO1.setIngredientDTOList(ingredientDTOList);
        plateDTO1.setCalories(calories);

        return plateDTO1;
    }

    @Override
    public List<IngredientDTO> calculateCaloriesByIngredient(PlateDTO plateDTO) {
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();

        for (IngredientDTO ingredient:
             plateDTO.getIngredientDTOList()) {
            var temp = foodRepository.foodByName(ingredient.getName());
            int calories = ingredient.getWeight() * temp.getCalories();

            ingredientDTOList.add(new IngredientDTO(ingredient.getName(), ingredient.getWeight(), calories));
        }
        return ingredientDTOList;
    }

    @Override
    public IngredientDTO calculateIngredientWithMoreCalories(PlateDTO plateDTO) {
        IngredientDTO ingredientDTO = null;

        List<IngredientDTO> ingredientDTOList = calculateCaloriesByIngredient(plateDTO);

        for (IngredientDTO ingredient :
                ingredientDTOList) {
            ingredientDTO = Objects.isNull(ingredientDTO) || ingredient.getCalories() > ingredientDTO.getCalories()
                    ? ingredient : ingredientDTO;
        }
        return ingredientDTO;
    }
}
