package com.meli.TuCasitaTasaciones.repository;

import com.meli.TuCasitaTasaciones.model.District;
import com.meli.TuCasitaTasaciones.model.Environment;
import com.meli.TuCasitaTasaciones.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PropertyDAO implements IPropertyDAO {

    private Set<Property> properties = new HashSet<>();
    private Set<District> districts = new HashSet<>();

    void loadData() {
        District district1 = new District("Palermo", 5000);
        District district2 = new District("Centro", 2000);
        District district3 = new District("Martires", 1000);

        Environment environment1 = new Environment("Room1", 18, 18);
        Environment environment2 = new Environment("Room2", 10, 12);
        Environment environment3 = new Environment("kitchen", 15, 20);
        Environment environment4 = new Environment("Toilet", 11, 5);
        Environment environment5 = new Environment("Hall", 20, 20);

        List<Environment> environments1 = new ArrayList<>();
        environments1.add(environment1);
        environments1.add(environment2);
        environments1.add(environment3);
        environments1.add(environment4);
        environments1.add(environment5);

        List<Environment> environments2 = new ArrayList<>();
        environments2.add(environment1);
        environments2.add(environment3);
        environments2.add(environment4);

        List<Environment> environments3 = new ArrayList<>();
        environments3.add(environment2);
        environments3.add(environment4);

        Property pro1 = new Property(1, district1, environments1);

        Property pro2 = new Property(2, district2, environments2);
        Property pro3 = new Property(3, district3, environments3);

        this.properties.add(pro1);
        this.properties.add(pro2);
        this.properties.add(pro3);

        this.districts.add(district1);
        this.districts.add(district2);
        this.districts.add(district3);
    }

    @Override
    public Property getPropertyById(int idProperty) {

        loadData();
        return properties.stream()
                .filter(stu -> stu.getIdProperty() == (idProperty))
                .findFirst().orElse(new Property(idProperty, null, null));
    }

    public Set<Property> getPropertyList() {

        loadData();
        return properties;
    }
    public Set<District> getDistrictList() {

        loadData();
        return districts;
    }
}
