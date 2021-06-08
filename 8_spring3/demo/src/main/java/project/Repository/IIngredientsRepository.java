package project.Repository;

import project.Service.dto.IngredientsResponseDTO;

public interface IIngredientsRepository {

    IngredientsResponseDTO findIngridientsCaloriesByName(String Name);
}
