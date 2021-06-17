package com.example.demo.services;

import com.example.demo.DTO.ResponseBiggerEnvironmentDTO;
import com.example.demo.DTO.ResponseCalculateTotalMetersDTO;
import com.example.demo.DTO.ResponsePriceDTO;
import com.example.demo.DTO.ResponseTotalMetersByEnvironmentDTO;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface IPropertyService {
    public ResponseCalculateTotalMetersDTO getResponseCalculateTotalMetersDTO(int propertyId) throws Exception;
    public ResponseBiggerEnvironmentDTO getBiggerEnvironment(int propertyId) throws Exception;
    public ResponseTotalMetersByEnvironmentDTO getTotalMetersByEnvironment(int propertyId) throws FileNotFoundException;
    public ResponsePriceDTO getPrice(int propertyId) throws Exception;
}
