package com.example.tucasita.repository;

import com.example.tucasita.model.DistrictDTO;

import java.util.Set;

public interface DistrictRepository {
    Set<DistrictDTO> findAll();
}
