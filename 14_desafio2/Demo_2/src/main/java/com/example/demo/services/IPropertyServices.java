package com.example.demo.services;


import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.PropertyNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPropertyServices {

    PropertyDTO calculateSquareMeter(Integer id) throws PropertyNotFoundException;

    PropertyDTO calculatePrice(Integer id) throws PropertyNotFoundException;

    PropertyDTO calculateBigger();

    PropertyDTO calculateSquareMeterByEnvironment(Integer id) throws PropertyNotFoundException;

    void addProperty(@RequestBody PropertyDTO property) throws DistrictNotFoundException;

}
