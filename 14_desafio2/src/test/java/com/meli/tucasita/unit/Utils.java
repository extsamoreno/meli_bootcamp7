package com.meli.tucasita.unit;

import com.meli.tucasita.dto.EnvironmentDto;
import com.meli.tucasita.dto.PropertyDto;
import com.meli.tucasita.model.Property;

import java.util.*;

public class Utils {

  public static PropertyDto getPropertyDto(){
    EnvironmentDto environment1 = new EnvironmentDto("Living de prueba", 4.00, 3.00);
    EnvironmentDto environment2 = new EnvironmentDto("Dormitorio de prueba", 3.00, 3.00);
    List<EnvironmentDto> environments = Arrays.asList(environment1, environment2);
    return new PropertyDto(18, "Testing Property", 3, environments);
  }
}
