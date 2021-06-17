package com.meli.tucasita.repository;

import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Property;

import java.util.*;

public interface DataRepository {
  Map<Integer, Property> findAllProperties();
  Map<Integer, District> findAllDistricts();
  Property findPropertyById(int id);
  District findDistrictById(int id);
}
