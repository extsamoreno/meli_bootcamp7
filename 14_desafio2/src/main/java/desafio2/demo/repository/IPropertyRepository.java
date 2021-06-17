package desafio2.demo.repository;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;

public interface IPropertyRepository {
    void validateDistrict(DistrictDTO district) throws DistrictNotFoundException;
}
