package com.desafiotesting.desafiotesting.repositories;
import com.desafiotesting.desafiotesting.models.Property;

public interface IPropertyRepository {
    public void save(Property property);
    public Property findById(int id);
}
