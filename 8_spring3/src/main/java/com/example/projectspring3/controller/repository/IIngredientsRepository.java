package com.example.projectspring3.controller.repository;


import com.example.projectspring3.controller.service.CaloriesDTO;

import java.util.List;

public interface IIngredientsRepository {
    public CaloriesDTO findCaloriesByName(String nombre);

}
