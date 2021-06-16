package com.example.tucasita.repository;

import com.example.tucasita.domain.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepository implements IDistrictRepository {

    List<District> listOfDistrict = new ArrayList<>();

    @Override
    public void loadDatabase() {
        listOfDistrict.add(new District("Barrio 1", 1000));
        listOfDistrict.add(new District("Barrio 2", 1200));
        listOfDistrict.add(new District("Barrio 3", 1500));
        listOfDistrict.add(new District("Barrio 4", 2000));
        listOfDistrict.add(new District("Barrio 5", 2500));
    }

    @Override
    public Optional<District> findByName(String name) {
        return listOfDistrict.stream().filter(district -> district.getName() == name).findFirst();
    }

    @Override
    public void save(District district) {
        listOfDistrict.add(district);
    }

    @Override
    public boolean deleteByName(String name) {
        if (existsByName(name)) return listOfDistrict.remove(findByName(name));
        else return false;
    }

    @Override
    public boolean existsByName(String name) {
        return this.findByName(name).isPresent();
    }

}
