package com.meli.TuCasitaTasaciones.repository;

import com.meli.TuCasitaTasaciones.model.District;
import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.model.PropertyDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PropertyDAO implements IPropertyDAO {

    private Set<PropertyDTO> properties = new HashSet<>();
    private HashMap<String, Double> districts = new HashMap<>();

    void loadData() {
        District district1 = new District("Palermo", 5000);
        District district2 = new District("Centro", 2000);
        District district3 = new District("Martires", 1000);

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

        PropertyDTO pro1 = new PropertyDTO("Casa 1", district1, environments1);

        PropertyDTO pro2 = new PropertyDTO("Casa 2", district2, environments2);
        PropertyDTO pro3 = new PropertyDTO("Casa 3", district3, environments3);

        this.properties.add(pro1);
        this.properties.add(pro2);
        this.properties.add(pro3);

        this.districts.put(district1.getDistrictName(), district1.getPrice());
        this.districts.put(district2.getDistrictName(), district2.getPrice());
        this.districts.put(district3.getDistrictName(), district3.getPrice());

    }

//    @Override
//    public Property getPropertyById(int idProperty) {
//
//        loadData();
//        return properties.stream()
//                .filter(stu -> stu.getPropertyName() == (idProperty))
//                .findFirst().orElse(new Property("Casa Nueva", null, null));
//    }

    @Override
    public PropertyDTO getPropertyById(int idProperty) {
        return null;
    }

    public Set<PropertyDTO> getPropertyList() {

        loadData();
        return properties;
    }
    public HashMap<String, Double> getDistrictList() {

        loadData();
        return districts;
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) {
        this.properties.add(propertyDTO);
    }
}
