package project.Repository;

import project.Service.dto.IngredientsResponse;

public interface IIngredientsRepository {

    IngredientsResponse findIngridientsCaloriesByName(String Name);
}
