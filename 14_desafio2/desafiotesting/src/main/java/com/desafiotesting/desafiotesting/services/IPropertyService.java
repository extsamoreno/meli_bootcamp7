package com.desafiotesting.desafiotesting.services;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;

import java.util.List;

public interface IPropertyService {
    public double totalSquareMeters(int id);
    public double getPriceProperty(int id);
    public EnviromentDTO getBiggerEnviroment(int id);
    public List<EnviromentWithSquareMetersDTO> getEnviromentsInfo(int id);
    public void create(PropertyDTO propertyDTO);
}
