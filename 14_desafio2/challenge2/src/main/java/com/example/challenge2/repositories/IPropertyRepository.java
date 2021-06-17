package com.example.challenge2.repositories;

import com.example.challenge2.models.Property;

import java.util.Set;

public interface IPropertyRepository {

    Set<Property> findAll();

}
