package desafio2.demo.service;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;
import desafio2.demo.model.EnvironmentDTO;
import desafio2.demo.model.PropertyDTO;
import desafio2.demo.repository.IPropertyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService implements IPropertyService{
    IPropertyRepository iPropertyRepository;

    public PropertyService(IPropertyRepository iPropertyRepository) {
        this.iPropertyRepository = iPropertyRepository;
    }

    @Override
    public double getPropertyM2(PropertyDTO property) throws DistrictNotFoundException {
        iPropertyRepository.validateDistrict(property.getDistrict());
        return property.getEnvironments().stream()
                .map(this::getEnvironmentM2)
                .mapToDouble(e -> e)
                .sum();
    };

    private double getEnvironmentM2(EnvironmentDTO environment){
        return environment.getLength() * environment.getWidth();
    }
}
