package com.meli.TuCasitaTasaciones.repository;

import com.meli.TuCasitaTasaciones.model.DistrictDTO;
import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.model.PropertyDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PropertyDAO implements IPropertyDAO {

    private Set<PropertyDTO> properties = new HashSet<>();
    private HashMap<String, Double> districts = new HashMap<>();

    PropertyDAO() {//void loadData() {
        DistrictDTO districtDTO1 = new DistrictDTO("Palermo", 5000);
        DistrictDTO districtDTO2 = new DistrictDTO("Centro", 2000);
        DistrictDTO districtDTO3 = new DistrictDTO("Martires", 1000);

        EnvironmentDTO environmentDTO1 = new EnvironmentDTO("Room1", 18, 18);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO("Room2", 10, 12);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO("kitchen", 15, 20);
        EnvironmentDTO environmentDTO4 = new EnvironmentDTO("Toilet", 11, 5);
        EnvironmentDTO environmentDTO5 = new EnvironmentDTO("Hall", 20, 20);

        List<EnvironmentDTO> environments1 = new ArrayList<>();
        environments1.add(environmentDTO1);
        environments1.add(environmentDTO2);
        environments1.add(environmentDTO3);
        environments1.add(environmentDTO4);
        environments1.add(environmentDTO5);

        List<EnvironmentDTO> environments2 = new ArrayList<>();
        environments2.add(environmentDTO1);
        environments2.add(environmentDTO3);
        environments2.add(environmentDTO4);

        List<EnvironmentDTO> environments3 = new ArrayList<>();
        environments3.add(environmentDTO2);
        environments3.add(environmentDTO4);

        PropertyDTO pro1 = new PropertyDTO("Casa 1", districtDTO1, environments1);

        PropertyDTO pro2 = new PropertyDTO("Casa 2", districtDTO2, environments2);
        PropertyDTO pro3 = new PropertyDTO("Casa 3", districtDTO3, environments3);

        this.properties.add(pro1);
        this.properties.add(pro2);
        this.properties.add(pro3);

        this.districts.put(districtDTO1.getDistrictName(), districtDTO1.getPrice());
        this.districts.put(districtDTO2.getDistrictName(), districtDTO2.getPrice());
        this.districts.put(districtDTO3.getDistrictName(), districtDTO3.getPrice());
    }

    @Override
    public PropertyDTO getPropertyById(int idProperty) {
        return null;
    }

    public Set<PropertyDTO> getPropertyList() {
        return this.properties;
    }
    public HashMap<String, Double> getDistrictList() {
        return this.districts;
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) {
        this.districts.put(propertyDTO.getDistrict().getDistrictName(),
                propertyDTO.getDistrict().getPrice());
        this.properties.add(propertyDTO);
    }
}
