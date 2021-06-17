package com.meli.desafio2.service;

import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.PropertyDTO;

public interface PropertyService {
    void saveProperty(Property prop);
    PropertyDTO calculateMts2();
    PropertyDTO calculatePrice();
    PropertyDTO obtainMostGreaterEnvironment();
    PropertyDTO calculateEnvironmentMts2();
}
