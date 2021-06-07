package com.example.demo.project.excercise1.repository;

import com.example.demo.project.excercise1.repository.entities.Ingrediente;

public interface IFoodRepository {

    Ingrediente getById(String id);
}
