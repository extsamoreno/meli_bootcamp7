package com.example.Challenge2.Repositories;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.DistrictDTO;
import com.example.Challenge2.Services.DTOs.PropertyDTO;

import java.util.List;

public interface IDataRepository {

    public District getDistrictById(Long id) throws DistrictNotFoundException;
    public List<District> getAllDistricts();

    public Property getPropertyById(Long id) throws PropertyNotFoundException;
    public List<Property> getAllProperties();
}
