package com.example.tucasita.repository;

import com.example.tucasita.domain.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepository implements IDistrictRepository {
    /**
     * used as database in memory
     */
    List<District> listOfDistrict = new ArrayList<>();

    /**
     * load default data
     */
    @Override
    public void loadDatabase() {
        listOfDistrict.add(new District("Barrio 1", 1000));
        listOfDistrict.add(new District("Barrio 2", 1200));
        listOfDistrict.add(new District("Barrio 3", 1500));
        listOfDistrict.add(new District("Barrio 4", 2000));
        listOfDistrict.add(new District("Barrio 5", 2500));
    }

    /**
     * returns an optional of a district, searching by name
     *
     * @param name
     * @return
     */
    @Override
    public Optional<District> findByName(String name) {
        return listOfDistrict.stream().filter(district -> district.getName().equals(name)).findFirst();
    }

    /**
     * persist a new district
     *
     * @param district
     */
    @Override
    public void save(District district) {
        listOfDistrict.add(district);
    }

    /**
     * removes a district by name
     *
     * @param name
     * @return
     */
    @Override
    public boolean deleteByName(String name) {
        if (existsByName(name)) return listOfDistrict.remove(findByName(name));
        else return false;
    }

    /**
     * checks if exists a district with the same name (name as identifier)
     *
     * @param name
     * @return
     */
    @Override
    public boolean existsByName(String name) {
        return this.findByName(name).isPresent();
    }

    /**
     * returns all the districts
     *
     * @return
     */
    @Override
    public List<District> findAll() {
        return listOfDistrict;
    }

}
