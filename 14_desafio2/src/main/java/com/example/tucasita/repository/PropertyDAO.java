package com.example.tucasita.repository;

import com.example.tucasita.model.Property;

public interface PropertyDAO {
    void create(Property property);
    Property findById(int idProperty);
}
