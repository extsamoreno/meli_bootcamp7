package com.example.tucasita.repository;

import com.example.tucasita.domain.District;
import com.example.tucasita.domain.House;

import java.util.Optional;

public interface IHouseRepository {
    void loadDatabase();

    Optional<House> findByName(String name);

    void save(House district);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}

