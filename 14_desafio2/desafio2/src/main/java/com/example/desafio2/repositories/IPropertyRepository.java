package com.example.desafio2.repositories;

import com.example.desafio2.models.PropertyDTO;

public interface IPropertyRepository {

    PropertyDTO getPropertyByName(String name);
}
