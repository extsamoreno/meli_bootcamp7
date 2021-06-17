package com.example.Challenge2.Services;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.*;

import java.util.List;

public interface IDistrictService {


    public Boolean storeDistrict(DistrictDTO district);

    public List<District> getall();
}
