package com.example.demo.repository;


import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

public interface IPropertyRepository {

    PropertyDTO findPropertyById(Integer id);

    HashMap<Integer, PropertyDTO> getAllProperty();

    void addProperty(@RequestBody PropertyDTO property);

    DistrictDTO findDistrictByName(String name);
}
