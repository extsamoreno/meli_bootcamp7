package com.meli.tucasita.service;

import com.meli.tucasita.model.*;
import com.meli.tucasita.repository.DataRepository;
import com.meli.tucasita.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertyServiceImpl implements PropertyService {

  @Autowired
  DataRepository dataRepository;

  @Override
  public Map<Integer, Property> addNewProperty(Property property) {
    Map<Integer, Property> properties = dataRepository.findAllProperties();
    properties.put(property.getId(), property);
    return properties;
  }

  @Override
  public PropertyAreaDTO getPropertyArea(int id) {
    Property property = dataRepository.findPropertyById(id);
    double area = calculatePropertyArea(property);
    return new PropertyAreaDTO(property.getName(), area);
  }

  @Override
  public PropertyPriceDTO getPropertyPrice(int id) {
    Property property = dataRepository.findPropertyById(id);
    District district = dataRepository.findDistrictById(property.getDistrictId());
    double area = calculatePropertyArea(property);
    double price = area * district.getPrice();
    return new PropertyPriceDTO(property.getName(), price);
  }

  @Override
  public EnvironmentAreaDTO getBiggestEnvironment(int id) {
    return getPropertyEnvironments(id).get(0);
  }

  @Override
  public List<EnvironmentAreaDTO> getPropertyEnvironments(int id) {
    List<EnvironmentAreaDTO> environments = new ArrayList<>();
    Property property = dataRepository.findPropertyById(id);
    for (Environment e: property.getEnvironments()) {
      environments.add(new EnvironmentAreaDTO(e.getName(), e.getLength() * e.getWidth()));
    }

    // Ordena los ambientes por área en forma descendente
    Comparator<EnvironmentAreaDTO> environmentComparator = Comparator.comparing(EnvironmentAreaDTO::getArea);
    environments.sort(environmentComparator.reversed());
    return environments;
  }

  private double calculatePropertyArea(Property property) {
    double area = 0;
    for (Environment e: property.getEnvironments()) {
      area += e.getLength() * e.getWidth();
    }
    return area;
    }
  }

