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

  @Override
  public Map<Integer, PropertyDto> addNewProperty(PropertyDto propertyDto) {

    Map<Integer, PropertyDto> propertiesDto = propertyRepository.findAllProperties();
    propertiesDto.put(propertyDto.getId(), propertyDto);
    return propertiesDto;
  }

  @Override
  public Map<Integer, DistrictDto> addNewDistrict(DistrictDto districtDto) {
    Map<Integer, DistrictDto> districtsDto = propertyRepository.findAllDistricts();
    districtsDto.put(districtDto.getId(), districtDto);
    return districtsDto;
  }

  @Override
  public PropertyAreaDto getPropertyArea(int id) {
    var propertyDto = propertyRepository.findPropertyById(id);
    return new PropertyAreaDto(propertyDto.getName(), calculatePropertyArea(propertyDto)) ;
  }

  @Override
  public PropertyPriceDto getPropertyPrice(int id) {
    var propertyDto = propertyRepository.findPropertyById(id);
    var districtDto = propertyRepository.findDistrictById(propertyDto.getDistrictId());
    double area = calculatePropertyArea(propertyDto);
    double price = area * districtDto.getPrice();
    return new PropertyPriceDto(propertyDto.getName(), price);
  }

  @Override
  public EnvironmentAreaDto getBiggestEnvironment(int id) {
    return getPropertyEnvironments(id).get(0);
  }

  @Override
  public List<EnvironmentAreaDto> getPropertyEnvironments(int id) {
    List<EnvironmentAreaDto> environments = new ArrayList<>();
    var propertyDto = propertyRepository.findPropertyById(id);
    for (EnvironmentDto e: propertyDto.getEnvironments()) {
      environments.add(new EnvironmentAreaDto(e.getName(), e.getLength() * e.getWidth()));
    }

    // Ordena los ambientes por área en forma descendente
    Comparator<EnvironmentAreaDto> environmentComparator = Comparator.comparing(EnvironmentAreaDto::getArea);
    environments.sort(environmentComparator.reversed());
    return environments;
  }

  private double calculatePropertyArea(PropertyDto propertyDto) {
    double area = 0;
    for (EnvironmentDto e: propertyDto.getEnvironments()) {
      area += e.getLength() * e.getWidth();
    }
    return area;
    }
  }

