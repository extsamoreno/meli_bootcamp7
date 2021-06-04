package project.Service.mapper;

import project.Service.dto.IngredientsRequestDTO;
import project.Service.dto.IngredientsResponse;

public class Mapper {


    public static IngredientsResponse toIngredient(IngredientsRequestDTO ingredient){
        return new IngredientsResponse(ingredient.getName(), ingredient.getGramms(), ingredient.getCalories());
    }

    public static IngredientsRequestDTO toDTO(IngredientsResponse ingredient){
        return new IngredientsRequestDTO(ingredient.getName(), ingredient.getGramms(), ingredient.getCalories(), ingredient.getCalories()* ingredient.getGramms());
    }
}
