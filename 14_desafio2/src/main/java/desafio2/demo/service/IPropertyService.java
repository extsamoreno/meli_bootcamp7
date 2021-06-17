package desafio2.demo.service;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.PropertyDTO;

public interface IPropertyService {
    double getPropertyM2(PropertyDTO property) throws DistrictNotFoundException;
}
