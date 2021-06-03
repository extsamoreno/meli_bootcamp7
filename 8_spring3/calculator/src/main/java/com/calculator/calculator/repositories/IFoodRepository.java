package com.calculator.calculator.repositories;

import com.calculator.calculator.dtos.FoodDTO;
import org.springframework.stereotype.Repository;

public interface IFoodRepository {
    FoodDTO foodByName(String name);
}
