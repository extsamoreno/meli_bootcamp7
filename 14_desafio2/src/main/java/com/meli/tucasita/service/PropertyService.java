package com.meli.tucasita.service;

import com.meli.tucasita.dto.*;


import java.util.List;
import java.util.Map;


public interface PropertyService {
  Map<Integer, PropertyDto> addNewProperty (PropertyDto propertyDto);
  Map<Integer, DistrictDto> addNewDistrict (DistrictDto districtDto);
  Double getPropertyArea(int id);
  PropertyPriceDto getPropertyPrice(int id);
  EnvironmentAreaDto getBiggestEnvironment(int id);
  List<EnvironmentAreaDto> getPropertyEnvironments(int id);
}
