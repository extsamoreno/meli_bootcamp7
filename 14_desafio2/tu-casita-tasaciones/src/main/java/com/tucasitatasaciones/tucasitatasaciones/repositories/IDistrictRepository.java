package com.tucasitatasaciones.tucasitatasaciones.repositories;

import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.District;

import java.util.HashMap;
import java.util.List;

public interface IDistrictRepository {
    HashMap<Integer, District> findAll();
}
