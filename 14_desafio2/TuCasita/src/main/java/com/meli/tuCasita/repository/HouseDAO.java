package com.meli.tuCasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tuCasita.exception.DistrictNotFoundException;
import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

@Repository
public class HouseDAO implements IHouseDAO {

    private String SCOPE;

    private Set<HouseDTO> houses;

    public HouseDAO() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(HouseDTO hus) throws HouseNotFoundException{

        houses.add(hus);
        return true;
    }

    @Override
    public HouseDTO findById(Long id) throws  HouseNotFoundException{
        return houses.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new HouseNotFoundException(id));
    }

    @Override
    public HouseDTO findByDistrict(DistrictDTO districtDTO) throws  DistrictNotFoundException{
        return houses.stream()
                .filter(house -> house.getDistrict().equals(districtDTO))
                .findFirst().orElseThrow(() -> new DistrictNotFoundException(districtDTO.getDistrictName()));
    }

    private void loadData() {
        Set<HouseDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/houses.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<HouseDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.houses = loadedData;
    }


}
