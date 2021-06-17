package com.meli.tucasita.service;

import com.meli.tucasita.model.Property;
import com.meli.tucasita.service.dto.*;

import java.util.List;
import java.util.Map;


public interface PropertyService {
  Map<Integer, Property> addNewProperty (Property property);
  PropertyAreaDTO getPropertyArea(int id);
  PropertyPriceDTO getPropertyPrice(int id);
  EnvironmentAreaDTO getBiggestEnvironment(int id);
  List<EnvironmentAreaDTO> getPropertyEnvironments(int id);
}
