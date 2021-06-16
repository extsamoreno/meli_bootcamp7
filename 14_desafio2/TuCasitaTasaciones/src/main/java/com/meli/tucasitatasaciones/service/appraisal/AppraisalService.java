package com.meli.tucasitatasaciones.service.appraisal;

import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.ResponseDTO;
import com.meli.tucasitatasaciones.model.Environment;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppraisalService implements IAppraisalService {
    @Autowired
    IPropertyRepository iPropertyRepository;

    @Override
    public Double getPropertyTotalSquareMeters(Integer propertyId) {
        Property property = iPropertyRepository.findPropertyById(propertyId);
        Double totalSquareMeters = this.calculateTotalSquareMeters(property.getEnvironments());
        return totalSquareMeters;
    }

    private Double calculateTotalSquareMeters(List<Environment> environments) {
        return environments.stream().mapToDouble(this::calculateSquareMeters).sum();
    }

    private double calculateSquareMeters(Environment environment) {
        return environment.getWidth() * environment.getLength();
    }

    @Override
    public Double getPropertyValue(Integer propertyId) {
        return null;
    }

    @Override
    public EnvironmentDTO getBiggerEnvironment(Integer propertyId) {
        return null;
    }

    @Override
    public List<EnvironmentDTO> getEnvironmentsSquareMeters(Integer propertyId) {
        return null;
    }
}
