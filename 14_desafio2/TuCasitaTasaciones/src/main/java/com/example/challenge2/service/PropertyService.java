package com.example.challenge2.service;

import com.example.challenge2.dtos.EnvironmentDTO;
import com.example.challenge2.dtos.PriceDTO;
import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.dtos.TotalAreaDTO;
import com.example.challenge2.exceptions.NotFoundDistrictException;
import com.example.challenge2.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IPropertyService{
   @Autowired
    IDistrictRepository repository;

    @Override
    public TotalAreaDTO totalAreaDTO(PropertyDTO house){
        List<EnvironmentDTO>environment=house.getEnvironment();
        double total=0.0;
        for (int i = 0; i < environment.size(); i++) {
            double currentArea = environment.get(i).getLength()*environment.get(i).getWidth();
            total=total+currentArea;
        }
        TotalAreaDTO response = new TotalAreaDTO(house.getName(),total);
        return response;
    }

    @Override
    public Object getTotalM2(String propertyName) {
        return null;
    }

    @Override
    public TotalAreaDTO totalArea(PropertyDTO house) {
        return null;
    }

    @Override
    public PriceDTO price(PropertyDTO house) throws NotFoundDistrictException {
        List<EnvironmentDTO> environment=house.getEnvironment();
        String districtName = house.getDistrict();

        if(repository.getDistricts().get(districtName)==null){ throw new NotFoundDistrictException();}

        double districtPrice = repository.getDistricts().get(districtName).getPrice();
        double total=0.0;
        for (int i = 0; i < environment.size(); i++) {
            double currentArea = environment.get(i).getLength()*environment.get(i).getWidth();
            total=total+currentArea;
        }
        PriceDTO response = new PriceDTO(house.getName(),total*districtPrice);
        return response;
    }
}

