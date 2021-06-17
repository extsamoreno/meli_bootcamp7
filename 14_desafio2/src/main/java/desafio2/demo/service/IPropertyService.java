package desafio2.demo.service;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.EnvironmentAreaDTO;
import desafio2.demo.model.EnvironmentDTO;
import desafio2.demo.model.PropertyDTO;

import java.util.List;

public interface IPropertyService {
    double getPropertyM2(PropertyDTO property) throws DistrictNotFoundException;
    double getPropertyPrice(PropertyDTO property) throws DistrictNotFoundException;
    EnvironmentDTO getBiggestEnvironment(PropertyDTO property) throws DistrictNotFoundException;
    List<EnvironmentAreaDTO> getEnvironmentsArea(PropertyDTO property) throws DistrictNotFoundException;
}
