package com.example.tucasita.service;

import com.example.tucasita.model.EnvironmentDTO;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface PropertyService {
    ResponseDTO addOneProperty(PropertyDTO property);
    ResponseDTO calculatePropertyTotalSquareMeters(int idProperty);
    ResponseDTO calculatePropertyPrice(int idProperty);
    ResponseDTO getBiggestEnvironment(int idProperty);
    List<EnvironmentDTO> calculateEnvironmentsSquareMeters(int idProperty);
    //Set<PropertyDTO> getAllProperties();
}
