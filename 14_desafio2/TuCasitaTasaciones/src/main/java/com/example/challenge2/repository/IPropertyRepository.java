package com.example.challenge2.repository;

import com.example.challenge2.models.Property;
import javax.el.PropertyNotFoundException;

public interface IPropertyRepository {
    public Property getPropertyByName(String name) throws PropertyNotFoundException;
}