package com.meli.tucasita.repository;

import com.meli.tucasita.dto.DistrictDto;
import com.meli.tucasita.dto.PropertyDto;

import java.util.*;

public interface PropertyRepository {
  Map<Integer, PropertyDto> findAllProperties();
  Map<Integer, DistrictDto> findAllDistricts();
  PropertyDto findPropertyById(int id);
  DistrictDto findDistrictById(int id);
}
