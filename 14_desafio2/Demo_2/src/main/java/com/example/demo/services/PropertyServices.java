package com.example.demo.services;


import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PropertyServices implements IPropertyServices{

    @Autowired
    IPropertyRepository propertyRepository;

    @Override
    public PropertyDTO calculateSquareMeter(Integer id) {
        PropertyDTO property = propertyRepository.findPropertyById(id);
        property.setSquareMeters(calculateSquadList(property.getListEnvironment()));
        return property;
    }

    @Override
    public PropertyDTO calculatePrice(Integer id) {
        PropertyDTO property = propertyRepository.findPropertyById(id);
        property.setSquareMeters(calculateSquadList(property.getListEnvironment()));
        property.setPrice(property.getDistrict().getPrice() * property.getSquareMeters());
        return property;
    }

    @Override
    public PropertyDTO calculateBigger() {
        HashMap<Integer, PropertyDTO> listProperty = propertyRepository.getAllProperty();
        return getBigger(listProperty);
    }

    @Override
    public PropertyDTO calculateSquareMeterByEnvironment(Integer id) {
        PropertyDTO property = propertyRepository.findPropertyById(id);
        calculaSquadMeter(property);
        return property;
    }

    @Override
    public void addProperty(PropertyDTO property) throws DistrictNotFoundException {
        DistrictDTO district = propertyRepository.findDistrictByName(property.getDistrict().getName());
        if(district == null)
            throw new DistrictNotFoundException(property.getDistrict().getName());

        propertyRepository.addProperty(property);
    }

    private double calculateSquadList(List<EnvironmentDTO> list){
        AtomicReference<Double> acumulated = new AtomicReference<>(0.0);
        list.forEach(a-> acumulated.set((a.getLength() * a.getWidth()) + acumulated.get()));
        return acumulated.get();
    }

    private PropertyDTO getBigger(HashMap<Integer, PropertyDTO> list){
        PropertyDTO propertyBigger = new PropertyDTO();
        double count = 0.0;

        for (Map.Entry<Integer, PropertyDTO> property: list.entrySet()) {
            double totalArea = calculateSquadList(property.getValue().getListEnvironment());
            property.getValue().setSquareMeters(totalArea);

            if(totalArea > count){
                propertyBigger = property.getValue();
                propertyBigger.setSquareMeters(totalArea);
                count = totalArea;
            }

        }
            return propertyBigger;
    }

    private void calculaSquadMeter(PropertyDTO property){
        property.getListEnvironment().forEach(a-> a.setSquareMeter(a.getLength()*a.getWidth()));
        //return property;
    }
}
