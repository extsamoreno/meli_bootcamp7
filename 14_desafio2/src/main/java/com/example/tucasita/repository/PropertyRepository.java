package com.example.tucasita.repository;

import com.example.tucasita.model.PropertyDTO;

import java.util.Set;

public interface PropertyRepository {
    Set<PropertyDTO> findAll();
}
