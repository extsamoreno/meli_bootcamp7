package com.example.desafio2.repositories;

import com.example.desafio2.models.PropertyDTO;

import java.io.FileNotFoundException;

public interface IPropertyRepository {

    PropertyDTO getPropertyById(int id) throws FileNotFoundException;
}
