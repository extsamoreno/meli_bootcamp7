package com.meli.tu_casita.repository;

import com.meli.tu_casita.model.District;

import java.util.List;
import java.util.Optional;

public interface IDistrictDAO {
    void save(District district);

    Optional<District> findById(int id);

    Optional<District> findByName(String name);

    List<District> getDistrictList();

}
