package com.meli.tucasita.utils;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.model.Property;

import java.util.*;

public class Utils {

  public static PropertyDto getPropertyDto(){
    EnvironmentDto environment1 = new EnvironmentDto("Living de prueba", 4.00, 3.00);
    EnvironmentDto environment2 = new EnvironmentDto("Dormitorio de prueba", 3.00, 3.00);
    List<EnvironmentDto> environments = Arrays.asList(environment1, environment2);
    return new PropertyDto(18, "Testing Property", 18, environments);
  }

  public static DistrictDto getDistrictDto(){
    return new DistrictDto(18, "Testing District", 1000.0);
  }

  public static EnvironmentAreaDto calculateBiggestEnvironment (PropertyDto propertyDto) {
    double area = 0.00;
    double maxArea = 0.00;
    String maxEnvironment = "";
    for (EnvironmentDto e: propertyDto.getEnvironments()) {
      area = e.getLength() * e.getWidth();
      if (area > maxArea) {
        maxArea = area;
        maxEnvironment = e.getName();
      }
    }
    return new EnvironmentAreaDto(maxEnvironment, maxArea);
  }

  public static double calculateArea(PropertyDto propertyDto) {
    double area = 0.00;
    for (EnvironmentDto e: propertyDto.getEnvironments()) {
      area += e.getLength() * e.getWidth();
    }
    return area;
  }
}
