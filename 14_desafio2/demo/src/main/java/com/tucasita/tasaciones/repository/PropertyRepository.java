package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.DTO.DistrictDTO;
import com.tucasita.tasaciones.DTO.EnvironmentDTO;
import com.tucasita.tasaciones.DTO.PropertyDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PropertyRepository implements IPropertyRepository  {

    private HashMap<Integer, PropertyDTO> propertyBD;
    private HashMap<String, DistrictDTO> districtBD;

    public PropertyRepository() {
        this.propertyBD = RepositoryData.loadProperty();
        this.districtBD = RepositoryData.loadDistrict();
    }

    @Override
    public PropertyDTO findPropertyById(Integer id) {
        return this.propertyBD.get(id.intValue());
    }
}
