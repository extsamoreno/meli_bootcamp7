package com.tuCasita.api.service.implementation;

import com.tuCasita.api.dto.*;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import com.tuCasita.api.repository.contract.IPropertyRepository;
import com.tuCasita.api.service.contract.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public PropertyWithTotalSquareMetersDTO getTotalSquareMeters(PropertyDTO dto) throws DistrictNameNotFoundException {
        checkValidDistrict(dto.getDistrict().getName());

        var totalMeters = calculateTotalSquareMetersByProperty(dto.getEnvironments());

        return new PropertyWithTotalSquareMetersDTO(
                dto.getName(),
                dto.getDistrict(),
                dto.getEnvironments(),
                totalMeters
        );
    }

    @Override
    public PropertyWithTotalValueDTO getTotalValue(PropertyDTO dto) throws DistrictNameNotFoundException {
        checkValidDistrict(dto.getDistrict().getName());

        var totalMeters = calculateTotalSquareMetersByProperty(dto.getEnvironments());
        var totalValue = calculateTotalValue(dto.getDistrict().getPrice(), totalMeters);

        return new PropertyWithTotalValueDTO(
                dto.getName(),
                dto.getDistrict(),
                dto.getEnvironments(),
                totalValue
        );
    }

    @Override
    public PropertyWithBiggestEnvironmentDTO calculateBiggestEnvironment(PropertyDTO dto) throws DistrictNameNotFoundException {
        checkValidDistrict(dto.getDistrict().getName());
        
        var biggestEnvironment = getBiggestEnvironment(dto.getEnvironments());
        
        return new PropertyWithBiggestEnvironmentDTO(
                dto.getName(),
                dto.getDistrict(),
                dto.getEnvironments(),
                biggestEnvironment
        );
    }

    @Override
    public PropertyWithTotalSquareMetersByEnvironmentDTO getTotalSquareMetersByEnvironment(PropertyDTO dto) throws DistrictNameNotFoundException {
        checkValidDistrict(dto.getDistrict().getName());

        ArrayList<EnvironmentWithTotalSquareMetersDTO> environments = new ArrayList<>();

        for(var environment : dto.getEnvironments()){
            environments.add(
                    new EnvironmentWithTotalSquareMetersDTO(
                            environment.getName(),
                            environment.getWidth(),
                            environment.getLength(),
                            calculateTotalSquareMetersByEnvironment(environment)
                    )
            );
        }

        return new PropertyWithTotalSquareMetersByEnvironmentDTO(
                dto.getName(),
                dto.getDistrict(),
                environments
        );
    }

    private EnvironmentWithTotalSquareMetersDTO getBiggestEnvironment(ArrayList<EnvironmentDTO> environments) {
        double max = 0;
        EnvironmentDTO maxEnvironment = new EnvironmentDTO();

        for (EnvironmentDTO actualEnvironment : environments) {
            double totalArea = calculateTotalSquareMetersByEnvironment(actualEnvironment);
            if (totalArea > max) {
                max = totalArea;
                maxEnvironment = actualEnvironment;
            }
        }

        return new EnvironmentWithTotalSquareMetersDTO(
                maxEnvironment.getName(),
                maxEnvironment.getWidth(),
                maxEnvironment.getLength(),
                max
        );
    }

    private void checkValidDistrict(String districtName) throws DistrictNameNotFoundException {
        var districtNames = iPropertyRepository.getAllDistrictNames();
        if (!districtNames.contains(districtName))
            throw new DistrictNameNotFoundException(districtName);
    }

    private double calculateTotalSquareMetersByEnvironment(EnvironmentDTO actualEnvironment) {
        return actualEnvironment.getLength() * actualEnvironment.getWidth();
    }

    private double calculateTotalValue(Double price, double totalMeters) {
        return totalMeters*price;
    }

    private double calculateTotalSquareMetersByProperty(ArrayList<EnvironmentDTO> environments) {
        double total = 0;
        for(var env : environments){
            total += env.getLength()*env.getWidth();
        }
        return total;
    }
}

