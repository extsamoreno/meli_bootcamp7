package com.example.CalCalculator.project.Repository;

import com.example.CalCalculator.project.Service.dto.FoodDTO;

public interface IFoodRepository {

    public FoodDTO getByName(String name);

}
