package com.example.demo.repository;


import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.PropertyDTO;
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

    @Override
    public HashMap<Integer, PropertyDTO> getAllProperty() {
        return this.propertyBD;
    }

    @Override
    public void addProperty(PropertyDTO property) {
        this.propertyBD.put(property.getId(),property);
    }

    @Override
    public DistrictDTO findDistrictByName(String name) {
        return districtBD.get(name);
    }
}
