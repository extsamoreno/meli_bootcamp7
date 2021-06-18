package com.example.tucasita.service;

import com.example.tucasita.dto.EnvironmentDTO;
import com.example.tucasita.dto.PropertyDTO;
import com.example.tucasita.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
    ResponseDTO addOneProperty(PropertyDTO propertyDTO);
    ResponseDTO calculatePropertyTotalSquareMeters(int idProperty);
    ResponseDTO calculatePropertyPrice(int idProperty);
    ResponseDTO getBiggestEnvironment(int idProperty);
    List<EnvironmentDTO> calculateEnvironmentsSquareMeters(int idProperty);
}
