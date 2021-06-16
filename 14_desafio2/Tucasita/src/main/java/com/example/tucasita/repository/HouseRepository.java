package com.example.tucasita.repository;

import com.example.tucasita.domain.District;
import com.example.tucasita.domain.House;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HouseRepository implements IHouseRepository {
    List<House> listOfHouse = new ArrayList<>();

    @Override
    public void loadDatabase() {
        // fill with data
    }

    @Override
    public Optional<House> findByName(String name) {
        return listOfHouse.stream().filter(district -> district.getName() == name).findFirst();
    }

    @Override
    public void save(House house) {
        listOfHouse.add(house);
    }

    @Override
    public boolean deleteByName(String name) {
        if (existsByName(name)) return listOfHouse.remove(findByName(name));
        else return false;
    }

    @Override
    public boolean existsByName(String name) {
        return this.findByName(name).isPresent();
    }
}
