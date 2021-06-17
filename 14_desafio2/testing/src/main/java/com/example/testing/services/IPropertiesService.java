package com.example.testing.services;

import com.example.testing.dto.EnvironmentDTO;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;

import java.util.ArrayList;

public interface IPropertiesService {

    Double totalSquareMeters(int id);

    Double getPrice(int id);

    Environment getBiggestEnvironment(int id);

    ArrayList<EnvironmentDTO>  getEnvironments(int id);

    void createProperty(Property p);
}
