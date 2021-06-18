package meli.bootcamp.tucasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.model.Property;
import meli.bootcamp.tucasita.service.dto.DistrictDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class DistrictRepository implements IDistrictRepository{


    private String SCOPE;

    private Set<District> districs;


    public DistrictRepository() {
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
    public District save(District district) {
        Optional<District> result=
                districs.stream().filter(district1 -> district.getDistrict_name().equals(district.getDistrict_name())).findFirst();
        if (result.isPresent()){
            return result.get();
        }
        districs.add(district);
        this.saveData();
        return district;
    }


    private void loadData() {
        Set<District> loadedData = new HashSet<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/database/district.json");
            loadedData=objectMapper.readValue(file, new TypeReference<Set<District>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        this.districs = loadedData;

    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/database/district.json");
            objectMapper.writeValue(file, this.districs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

}
