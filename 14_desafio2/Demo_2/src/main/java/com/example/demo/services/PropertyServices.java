package com.example.demo.services;


import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.PropertyNotFoundException;
import com.example.demo.repository.IPropertyRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;

    /**
     *Calculates the square meters of a property by id
     * @param id
     * @return
     */
    @Override
    public PropertyDTO calculateSquareMeter(Integer id) throws PropertyNotFoundException {
        PropertyDTO propertyRepo = propertyRepository.findPropertyById(id);
        if (propertyRepo == null)
            throw  new PropertyNotFoundException(id);
        PropertyDTO property = modelMapper.map(propertyRepo, PropertyDTO.class);
        property.setSquareMeters(calculateSquadList(property.getListEnvironment()));
        return property;
    }

    /**
     *Calculates the square footage of a property and then the property price. The property is searched by its id
     * @param id
     * @return
     */
    @Override
    public PropertyDTO calculatePrice(Integer id) throws PropertyNotFoundException {
        PropertyDTO propertyRepo = propertyRepository.findPropertyById(id);
        if (propertyRepo == null)
            throw  new PropertyNotFoundException(id);
        PropertyDTO property = modelMapper.map(propertyRepo, PropertyDTO.class);
        property.setSquareMeters(calculateSquadList(property.getListEnvironment()));
        property.setPrice(property.getDistrict().getPrice() * property.getSquareMeters());
        return property;
    }

    /**
     *
     * Calculate the bigger property
     * @return
     */

    @Override
    public PropertyDTO calculateBigger() {
        HashMap<Integer, PropertyDTO> listProperty = propertyRepository.getAllProperty();
        return getBigger(listProperty);
    }

    /**
     *Calculate the square meters of each environment of a property. The property is searched by its id
     * @param id
     * @return
     */
    @Override
    public PropertyDTO calculateSquareMeterByEnvironment(Integer id) throws PropertyNotFoundException {
        PropertyDTO propertyRepo = propertyRepository.findPropertyById(id);
        if (propertyRepo == null)
            throw  new PropertyNotFoundException(id);

        PropertyDTO property = modelMapper.map(propertyRepo, PropertyDTO.class);
        calculaSquadMeter(property);
        return property;
    }

    /**
     * Add a new property. It valid if the district exist.
     * @param property
     * @throws DistrictNotFoundException
     */
    @Override
    public void addProperty(PropertyDTO property) throws DistrictNotFoundException {
        DistrictDTO district = propertyRepository.findDistrictByName(property.getDistrict().getName());
        if(district == null)
            throw new DistrictNotFoundException(property.getDistrict().getName());

        propertyRepository.addProperty(property);
    }

    /**
     *
     * Auxiliary method. Returns the sum of areas of a list of environment.
     * @param list
     * @return
     */

    private double calculateSquadList(List<EnvironmentDTO> list){
        AtomicReference<Double> acumulated = new AtomicReference<>(0.0);
        list.forEach(a-> acumulated.set((a.getLength() * a.getWidth()) + acumulated.get()));
        return acumulated.get();
    }

    /**
     * Auxiliary method. Return de bigger property from a list of property.
     * @param list
     * @return
     */
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


    /**
     * Find the square area of each environment.
     * @param property
     */
    private void calculaSquadMeter(PropertyDTO property){
        property.getListEnvironment().forEach(a-> a.setSquareMeter(a.getLength()*a.getWidth()));
    }
}
