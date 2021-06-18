package com.example.tucasita.repository;

import com.example.tucasita.dto.DistrictDTO;

import java.util.Set;

public interface DistrictRepository {
    Set<DistrictDTO> findAll();
}
