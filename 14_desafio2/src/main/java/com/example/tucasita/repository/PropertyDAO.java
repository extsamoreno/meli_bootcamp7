package com.example.tucasita.repository;

import com.example.tucasita.model.PropertyDTO;

public interface PropertyDAO {
    void create(PropertyDTO property);
    PropertyDTO findById(int idProperty);
}
