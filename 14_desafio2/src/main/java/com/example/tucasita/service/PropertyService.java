package com.example.tucasita.service;

import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PropertyService {
    ResponseDTO addOneProperty(PropertyDTO property);
    ResponseDTO calculatePropertyTotalSquareMeters(int idProperty);
    ResponseDTO calculatePropertyPrice(int idProperty);
    Set<PropertyDTO> getAllProperties();
}
