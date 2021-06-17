package com.example.demo.services;


import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPropertyServices {

    PropertyDTO calculateSquareMeter(Integer id);

    PropertyDTO calculatePrice(Integer id);

    PropertyDTO calculateBigger();

    PropertyDTO calculateSquareMeterByEnvironment(Integer id);

    void addProperty(@RequestBody PropertyDTO property) throws DistrictNotFoundException;

}
