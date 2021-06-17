package com.meli.TuCasitaTasaciones.service;

import com.meli.TuCasitaTasaciones.mapper.EnvironmentMapper;
import com.meli.TuCasitaTasaciones.model.*;
import com.meli.TuCasitaTasaciones.repository.IPropertyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyDAO iPropertyDAO;

//    @Override
//    public Property getPropertyById(int idProperty) {
//        return iPropertyDAO.getPropertyById(idProperty);
//    }

    @Override
    public double calculateArea(List<EnvironmentDTO> environmentDTOS) {
        return environmentDTOS.stream()
                .mapToDouble(environment -> environment.getLength() * environment.getWidth()).sum();
    }

    @Override
    public double calculatePrice(HouseDTO houseDTO) {
        String district = houseDTO.getDistrict();
        double price = iPropertyDAO.getDistrictList().get(district);

        return calculateArea(houseDTO.getEnvironments()) * price;
    }

    @Override
    public EnvironmentAreaResponseDTO environmentsBigger(List<EnvironmentDTO> environmentDTOS) {
        Optional<EnvironmentDTO> bigger = environmentDTOS.stream()
                .max(Comparator.comparing(o -> o.getWidth() * o.getLength()));

        return EnvironmentMapper.ToEnvironmentAreaResponseDTO(bigger.get());
    }

    @Override
    public List<EnvironmentAreaResponseDTO> environmentArea(List<EnvironmentDTO> environmentDTOS) {

        return environmentDTOS.stream().map(EnvironmentMapper::ToEnvironmentAreaResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) {
        iPropertyDAO.addProperty(propertyDTO);
    }

//
//    @Override
//    public double getAreaProperty(int idProperty) {
//        Property p = getPropertyById(idProperty);
//        return calculateAreaCambiar(p);
//    }
//
//    @Override
//    public double getPriceProperty(int idProperty) {
//        Property p = getPropertyById(idProperty);
//        return calculateTotalPrice(p);
//    }
//
//    @Override
//    public double getAreaBigger() {
////        iPropertyDAO.getPropertyList().stream()
////                .max(Comparator.comparing(this::calculateArea)).get();
//
//        return 00;
//    }
//
//    private double obtainPrice(Property p) {
//        return p.getDistrict().getPrice();
//    }
//
//    private double calculateAreaCambiar(Property p) {
//        return p.getEnvironments().stream()
//                .mapToDouble(value -> value.getLength() * value.getWidth()).sum();
//    }
//
//    private double calculateTotalPrice(Property p) {
//        return calculateAreaCambiar(p) * obtainPrice(p);
//    }
}
