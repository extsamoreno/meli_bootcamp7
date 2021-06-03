package com.example.demo.calculadoraDeCalorias.repositories;

import com.models.CaloriesDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface iCaloriesRepository {

    CaloriesDTO findCaloriesByFood(String food);
}