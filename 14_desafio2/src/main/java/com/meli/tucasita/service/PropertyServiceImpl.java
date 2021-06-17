package com.meli.tucasita.service;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.model.*;
import com.meli.tucasita.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertyServiceImpl implements PropertyService {

  @Autowired
  private PropertyRepository propertyRepository;

  private final ModelMapper mapper = new ModelMapper();

  @Override
  public Map<Integer, PropertyDto> addNewProperty(PropertyDto propertyDto) {
    Map<Integer, Property> properties = propertyRepository.findAllProperties();
    Map<Integer, PropertyDto> propertiesDto = new HashMap<>();
    properties.forEach((k, v) -> propertiesDto.put(k, mapper.map(v, PropertyDto.class)));
    propertiesDto.put(propertyDto.getId(), propertyDto);
    properties.put(propertyDto.getId(), mapper.map(propertyDto, Property.class));
    return propertiesDto;
  }

  @Override
  public Map<Integer, DistrictDto> addNewDistrict(DistrictDto districtDto) {
    Map<Integer, District> districts = propertyRepository.findAllDistricts();
    Map<Integer, DistrictDto> districtsDto = new HashMap<>();
    districts.forEach((k, v) -> districtsDto.put(k, mapper.map(v, DistrictDto.class)));
    districtsDto.put(districtDto.getId(), districtDto);
    districts.put(districtDto.getId(), mapper.map(districtDto, District.class));
    return districtsDto;
  }

  @Override
  public Double getPropertyArea(int id) {
    var property = propertyRepository.findPropertyById(id);
    Double area = calculatePropertyArea(property);
    return area;
  }

  @Override
  public PropertyPriceDto getPropertyPrice(int id) {
    var property = propertyRepository.findPropertyById(id);
    var district = propertyRepository.findDistrictById(property.getDistrictId());
    double area = calculatePropertyArea(property);
    double price = area * district.getPrice();
    return new PropertyPriceDto(property.getName(), price);
  }

  @Override
  public EnvironmentAreaDto getBiggestEnvironment(int id) {
    return getPropertyEnvironments(id).get(0);
  }

  @Override
  public List<EnvironmentAreaDto> getPropertyEnvironments(int id) {
    List<EnvironmentAreaDto> environments = new ArrayList<>();
    var property = propertyRepository.findPropertyById(id);
    for (EnvironmentDto e: property.getEnvironments()) {
      environments.add(new EnvironmentAreaDto(e.getName(), e.getLength() * e.getWidth()));
    }

    // Ordena los ambientes por área en forma descendente
    Comparator<EnvironmentAreaDto> environmentComparator = Comparator.comparing(EnvironmentAreaDto::getArea);
    environments.sort(environmentComparator.reversed());
    return environments;
  }

  private double calculatePropertyArea(Property property) {
    double area = 0;
    for (EnvironmentDto e: property.getEnvironments()) {
      area += e.getLength() * e.getWidth();
    }
    return area;
    }
  }

