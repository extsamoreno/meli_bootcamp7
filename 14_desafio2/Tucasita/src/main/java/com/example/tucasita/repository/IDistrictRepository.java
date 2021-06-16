package com.example.tucasita.repository;

import com.example.tucasita.domain.District;

import java.util.List;
import java.util.Optional;

public interface IDistrictRepository {
    void loadDatabase();

    Optional<District> findByName(String name);

    void save(District district);

    boolean deleteByName(String name);

    boolean existsByName(String name);

    List<District> findAll();
}
