package com.example.desafio2.repositories;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class NeighborhoodRepository implements INeighborhoodRepository {
    private Map<Integer, NeighborhoodDTO> neighborhoods;
    private String SCOPE;

    public NeighborhoodRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadDataNeighborhoods();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public NeighborhoodDTO saveNeighborhood(NeighborhoodDTO neighborhoodDTO)
            throws NeighborhoodAlreadyExistException {
        boolean exists = existsNeighborhood(neighborhoodDTO.getName());

        if(exists) {
            throw new NeighborhoodAlreadyExistException(neighborhoodDTO.getName());
        }

        int newId = this.neighborhoods.size() + 1;
        neighborhoodDTO.setId(newId);
        neighborhoods.put(neighborhoodDTO.getId(), neighborhoodDTO);

        this.saveData();

        return neighborhoodDTO;
    }

    private boolean existsNeighborhood(String name) {
        return neighborhoods.values().stream()
                .anyMatch(neighborhoodDTO -> neighborhoodDTO.getName().equals(name));
    }

    @Override
    public NeighborhoodDTO getNeighborhoodByName(String neighborhood) throws NeighborhoodNotFoundException {
        loadDataNeighborhoods();

        return neighborhoods.values().stream()
                .filter(neighborhoodDTO -> neighborhoodDTO.getName().equals(neighborhood))
                .findFirst().orElseThrow(() -> new NeighborhoodNotFoundException(neighborhood));
    }

    private void loadDataNeighborhoods() {
        List<NeighborhoodDTO> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<NeighborhoodDTO>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.neighborhoods = toNeighborhoodMap(loadedData);
    }

    private Map<Integer, NeighborhoodDTO> toNeighborhoodMap(List<NeighborhoodDTO> list) {
        Map<Integer, NeighborhoodDTO> map = new HashMap<>();
        for(NeighborhoodDTO dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json");
            objectMapper.writeValue(file, this.neighborhoods);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
