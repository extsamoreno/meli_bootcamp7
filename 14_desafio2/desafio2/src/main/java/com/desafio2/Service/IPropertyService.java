package com.desafio2.Service;

import com.desafio2.DTO.EnvironmentDTO;
import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;

import java.awt.*;
import java.util.List;

public interface IPropertyService {
    double getTotalSquareMeters(String name);
    double getRoomSquareMeters(Environment environment);
    double getPropertyPrice(String name);
    Environment getBiggestEnvironment(String name);
    List<EnvironmentDTO> getEnvironmentListWithSquareMeters(String name);
}
