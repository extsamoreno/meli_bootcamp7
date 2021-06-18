package com.meli.TuCasitaTasaciones.service;

import com.meli.TuCasitaTasaciones.exception.DistrictRepeatedException;
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
    public double calculateArea(EnvironmentListDTO environmentDTOS) {
        return environmentDTOS.getEnvironments().stream()
                .mapToDouble(environment -> environment.getLength() * environment.getWidth()).sum();
    }

    @Override
    public double calculatePrice(HouseDTO houseDTO) {
        String district = houseDTO.getDistrict();

        HashMap<String, Double> districtsList = iPropertyDAO.getDistrictList();

        double price = districtsList.get(district);
        EnvironmentListDTO e = (new EnvironmentListDTO());
        e.setEnvironments(houseDTO.getEnvironments());
        return calculateArea(e) * price;
    }

    @Override
    public EnvironmentAreaResponseDTO environmentsBiggest(EnvironmentListDTO environmentDTOS) {
        Optional<EnvironmentDTO> bigger = environmentDTOS.getEnvironments().stream()
                .max(Comparator.comparing(o -> o.getWidth() * o.getLength()));

        return EnvironmentMapper.ToEnvironmentAreaResponseDTO(bigger.get());
    }

    @Override
    public List<EnvironmentAreaResponseDTO> environmentArea(EnvironmentListDTO environmentDTOS) {

        return environmentDTOS.getEnvironments().stream().map(EnvironmentMapper::ToEnvironmentAreaResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) throws DistrictRepeatedException {
        String districtName = propertyDTO.getDistrict().getDistrictName();
        HashMap<String, Double> hm = iPropertyDAO.getDistrictList();
        if (hm.containsKey(districtName)) {
            throw new DistrictRepeatedException(districtName);
        } else {
            iPropertyDAO.addProperty(propertyDTO);
            hm = iPropertyDAO.getDistrictList();
        }
    }

}
