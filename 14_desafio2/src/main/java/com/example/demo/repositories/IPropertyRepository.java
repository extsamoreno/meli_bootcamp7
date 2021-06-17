package com.example.demo.repositories;

import com.example.demo.DTO.ResponseCalculateTotalMetersDTO;
import com.example.demo.entities.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropertyRepository {

    public List<Property> loadProperties();

    public void saveDistrict();

    public Property getPropertyById(int id);

    public void addProperty(Property property);


}
