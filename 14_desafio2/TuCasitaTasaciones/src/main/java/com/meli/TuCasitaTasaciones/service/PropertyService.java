package com.meli.TuCasitaTasaciones.service;

import com.meli.TuCasitaTasaciones.mapper.EnvironmentMapper;
import com.meli.TuCasitaTasaciones.model.*;
import com.meli.TuCasitaTasaciones.repository.IPropertyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyDAO iPropertyDAO;

    @Override
    public double calculateArea(List<EnvironmentDTO> environmentDTOS) {
        return environmentDTOS.stream()
                .mapToDouble(environment -> environment.getLength() * environment.getWidth()).sum();
    }

    @Override
    public double calculatePrice(HouseDTO houseDTO) {
        String district = houseDTO.getDistrict();

        HashMap<String, Double> districtsList = iPropertyDAO.getDistrictList();

        double price = districtsList.get(district);

        return calculateArea(houseDTO.getEnvironments()) * price;
    }

    @Override
    public EnvironmentAreaResponseDTO environmentsBiggest(List<EnvironmentDTO> environmentDTOS) {
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
        String districtName = propertyDTO.getDistrict().getDistrictName();
//        if (iPropertyDAO.getDistrictList().get(districtName) != 0.0) {
//            System.out.println("Está mal");
//        } else {
            iPropertyDAO.addProperty(propertyDTO);
   //     }
    }

}
