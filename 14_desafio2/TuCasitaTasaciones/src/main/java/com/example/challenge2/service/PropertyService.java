package com.example.challenge2.service;

import com.example.challenge2.dtos.BiggestEnvironmentDTO;
import com.example.challenge2.dtos.EnvironmentDTO;
import com.example.challenge2.dtos.PriceDTO;
import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.dtos.TotalAreaDTO;
import com.example.challenge2.exceptions.NotFoundDistrictException;
import com.example.challenge2.repository.IDistrictRepository;
import com.example.challenge2.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class PropertyService implements IPropertyService{
   @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IPropertyRepository iPropertyRepository;


    @Override
    public TotalAreaDTO totalAreaDTO(PropertyDTO house){
        List<EnvironmentDTO>environment=house.getEnvironmentDTO();
        double total=0.0;
        for (int i = 0; i < environment.size(); i++) {
            double currentArea = environment.get(i).getLength()*environment.get(i).getWidth();
            total=total+currentArea;
        }
        TotalAreaDTO response = new TotalAreaDTO(house.getName(),total);
        return response;
    }

    @Override
    public TotalAreaDTO totalArea(PropertyDTO house) {
        return null;
    }

    @Override
    public PriceDTO price(PropertyDTO house) throws NotFoundDistrictException {
        List<EnvironmentDTO> environment=house.getEnvironmentDTO();
        String districtName = house.getDistrict();

        IDistrictRepository repository;
        if(IDistrictRepository.getDistrictDTO().get(districtName)==null){ throw new NotFoundDistrictException();}

        double districtPrice = iDistrictRepository.getDistricts().get(districtName).getPrice();
        double total=0.0;
        for (int i = 0; i < environment.size(); i++) {
            double currentArea = environment.get(i).getLength()*environment.get(i).getWidth();
            total=total+currentArea;
        }
        PriceDTO response = new PriceDTO(house.getName(),total*districtPrice);
        return response;  
    }

    @Override
    public EnvironmentDTO BiggestEnvironment;

    @GetMapping("/biggestEnvironment/{id}")
    public ResponseEntity<EnvironmentDTO> getBiggestEnvironment(@PathVariable int id) {
        return new ResponseEntity<>(propertyService.getBiggestEnvironment(id), HttpStatus.OK) ;
    }

    @GetMapping("/environment/{id}")
    public ResponseEntity<List<EnvironmentDT0>> getPropertyEnvironment(@PathVariable int id) {

        return new ResponseEntity<>(propertyService.getPropertyEnvironment(id), HttpStatus.OK) ;
    }

    public void priceDTO(PropertyDTO house) {
    }

    public void environmentsAreaDTO(PropertyDTO house) {
    }
}

