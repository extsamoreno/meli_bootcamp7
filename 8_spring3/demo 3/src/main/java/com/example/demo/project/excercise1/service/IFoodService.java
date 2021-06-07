package com.example.demo.project.excercise1.service;


import com.example.demo.project.excercise1.repository.entities.Plato;
import com.example.demo.project.excercise1.repository.entities.Platos;
import com.example.demo.project.excercise1.service.dto.PlatoDTO;
import com.example.demo.project.excercise1.service.dto.PlatosDTO;

public interface IFoodService {

    PlatosDTO getAllPlatosCalorias(Platos platos);

    PlatoDTO getPlatoCalorias(Plato plato);

}
