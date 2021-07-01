package com.meli.desafio2.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio2.DTOS.DistrictDTO;
import com.meli.desafio2.Exception.DistrictNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class DistrictRepository implements IDistrictRepository{

    List<DistrictDTO> district;
    private final String FILE_NAME;

    public DistrictRepository(){
        this.FILE_NAME = "district.json";
        this.district = loadFromDB();
    }

    private List<DistrictDTO> loadFromDB(){
        List<DistrictDTO> load = null;

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:" + FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var objectMapper= new ObjectMapper();

        try {
            load = objectMapper.readValue(file, new TypeReference<List<DistrictDTO>>(){});
            } catch (IOException e){
            e.printStackTrace();
        }

        return load;
    }

    @Override
    public DistrictDTO getDistrictByNameAndPrice(String nameDistrict, Double priceDistrict) throws DistrictNotFoundException {
        return this.district.stream()
                .filter(district -> district.getNameDistrict().equals(nameDistrict) && district.getPriceDistrict().equals(priceDistrict))
                .findFirst().orElseThrow(() -> new DistrictNotFoundException("The district with name: " + nameDistrict + " and price: " + priceDistrict + " doesn't belong to the database."));
    }
}




