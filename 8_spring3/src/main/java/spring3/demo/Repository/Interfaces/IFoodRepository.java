package spring3.demo.Repository.Interfaces;

import spring3.demo.Models.Entities.Ingredient;

public interface IFoodRepository {
    Ingredient getIngredientByName(String name);
}
