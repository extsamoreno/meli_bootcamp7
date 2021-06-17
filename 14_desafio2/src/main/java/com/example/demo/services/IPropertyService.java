package com.example.demo.services;

import com.example.demo.DTO.*;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface IPropertyService {
    public ResponseCalculateTotalMetersDTO getResponseCalculateTotalMetersDTO(int propertyId) throws Exception;
    public ResponseBiggerEnvironmentDTO getBiggerEnvironment(int propertyId) throws Exception;
    public ResponseTotalMetersByEnvironmentDTO getTotalMetersByEnvironment(int propertyId) throws FileNotFoundException;
    public ResponsePriceDTO getPrice(int propertyId) throws Exception;
    public void addProperty(PropertyDTO propertyDTO) throws Exception;
}
