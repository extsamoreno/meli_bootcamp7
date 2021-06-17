package com.desafiotesting.desafiotesting.services;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;

public interface IPropertyService {
    public double totalSquareMeters(int id);
    public double getPriceProperty(int id);
    public void create(PropertyDTO propertyDTO);
}
