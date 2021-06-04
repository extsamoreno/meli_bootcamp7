package com.example.projectspring3.controller.repository;

import com.example.projectspring3.controller.service.CaloriesDTO;
import com.example.projectspring3.controller.service.CaloriesResponse;

import java.util.List;

public interface IFoodService {
     public void saveDish(Dish dish);
     public int getCalDish(Dish dish);
     public Dish getDishByName(String name);
     public List<CaloriesResponse> getCalIngredients(Dish dish);
     public CaloriesDTO getMaxIngredients(Dish dish);
}
