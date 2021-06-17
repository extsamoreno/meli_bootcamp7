package com.meli.tucasita.service.mapper;

import com.meli.tucasita.model.Property;
import com.meli.tucasita.service.dto.PropertyAreaDTO;

public class PropertyMapper {
  public static PropertyAreaDTO toPropertyAreaDTO (Property prop) {
    return new PropertyAreaDTO();
  }
}
