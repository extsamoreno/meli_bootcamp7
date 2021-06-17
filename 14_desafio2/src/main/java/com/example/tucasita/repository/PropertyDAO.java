package com.example.tucasita.repository;

import com.example.tucasita.model.PropertyDTO;

public interface PropertyDAO {
    void create(PropertyDTO property);
    boolean delete(int idProperty);
    PropertyDTO findById(int idProperty);
}
