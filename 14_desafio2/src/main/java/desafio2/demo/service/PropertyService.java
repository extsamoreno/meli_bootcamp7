package desafio2.demo.service;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.EnvironmentAreaDTO;
import desafio2.demo.model.EnvironmentDTO;
import desafio2.demo.model.PropertyDTO;
import desafio2.demo.repository.IPropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    }

    @Override
    public double getPropertyPrice(PropertyDTO property) throws DistrictNotFoundException {
        iPropertyRepository.validateDistrict(property.getDistrict());
        return property.getEnvironments().stream()
                .map(this::getEnvironmentM2)
                .map(area -> area * property.getDistrict().getPrice())
                .mapToDouble(e -> e)
                .sum();
    }

    @Override
    public EnvironmentDTO getBiggestEnvironment(PropertyDTO property) throws DistrictNotFoundException {
        iPropertyRepository.validateDistrict(property.getDistrict());
        return property.getEnvironments().stream()
                .max((a,b)-> (int) (getEnvironmentM2(a) - getEnvironmentM2(b))).get();
    }

    @Override
    public List<EnvironmentAreaDTO>  getEnvironmentsArea(PropertyDTO property) throws DistrictNotFoundException {
        iPropertyRepository.validateDistrict(property.getDistrict());
        return property.getEnvironments().stream()
                .map(e -> new EnvironmentAreaDTO(e,getEnvironmentM2(e)))
                .collect(Collectors.toList());
    }

    private double getEnvironmentM2(EnvironmentDTO environment){
        return environment.getLength() * environment.getWidth();
    }
}
