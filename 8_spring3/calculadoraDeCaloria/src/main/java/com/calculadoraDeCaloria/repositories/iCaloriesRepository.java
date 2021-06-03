package com.calculadoraDeCaloria.repositories;

import com.models.CaloriesDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface iCaloriesRepository {

    CaloriesDTO findCaloriesByFood(String food);
}
