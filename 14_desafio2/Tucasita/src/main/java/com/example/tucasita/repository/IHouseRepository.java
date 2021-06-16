package com.example.tucasita.repository;

import com.example.tucasita.domain.House;

import java.util.List;
import java.util.Optional;

public interface IHouseRepository {
    void loadDatabase();

    Optional<House> findByName(String name);

    void save(House district);

    boolean deleteByName(String name);

    boolean existsByName(String name);

    List<House> findAll();
}

