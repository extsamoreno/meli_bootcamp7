package com.example.CalCalculator.project.Service;

import com.example.CalCalculator.project.Entities.Dish;
import com.example.CalCalculator.project.Service.dto.DishDTO;
import org.springframework.stereotype.Service;

@Service
public interface IFoodService {

    public DishDTO getDishData(Dish dish);

}
