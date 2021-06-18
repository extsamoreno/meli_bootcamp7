package com.desafio2.demo.repository;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.service.INeighborhoodService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

    @Repository
    public class NeighborhoodRepository implements INeighborhoodRepository {
        private Map<Integer, Neighborhood> neighborhoods;
        private String SCOPE;

        public NeighborhoodRepository() {
            Properties properties = new Properties();

            try {
                properties.load(new ClassPathResource("application.properties").getInputStream());
                this.SCOPE = properties.getProperty("api.scope");
                this.loadDataNeighborhoods();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Neighborhood saveNeighborhood(Neighborhood neighborhood)
                throws NeighborhoodAlreadyExistException {
            boolean exists = existsNeighborhood(neighborhood.getName());

            if (exists) {
                throw new NeighborhoodAlreadyExistException(neighborhood.getName());
            }

            int newId = this.neighborhoods.size() + 1;
            neighborhood.setId(newId);
            neighborhoods.put(neighborhood.getId(), neighborhood);

            this.saveData();

            return neighborhood;
        }

        private boolean existsNeighborhood(String name) {
            return neighborhoods.values().stream()
                    .anyMatch(neighborhood -> neighborhood.getName().equals(name));
        }

        @Override
        public Neighborhood getNeighborhoodByName(String neighborhood) throws NeighborhoodNotFoundException {
            loadDataNeighborhoods();

            return neighborhoods.values().stream()
                    .filter(neighborhoods -> neighborhoods.getName().equals(neighborhood))
                    .findFirst().orElseThrow(() -> new NeighborhoodNotFoundException(neighborhood));
        }

        private void loadDataNeighborhoods() {
            List<Neighborhood> loadedData = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();
            File file;
            try {
                file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json");
                loadedData = objectMapper.readValue(file, new TypeReference<List<Neighborhood>>() {
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Fail while initializing DB, check the files.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Fail while initializing DB, check your JSON.");
            }

            this.neighborhoods = toNeighborhoodMap(loadedData);
        }

        private Map<Integer, Neighborhood> toNeighborhoodMap(List<Neighborhood> list) {
            Map<Integer, Neighborhood> map = new HashMap<>();
            for (Neighborhood dto : list) {
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
                System.out.println("Fail while initializing DB, check the files.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Fail while initializing DB, check your JSON.");
            }
        }
    }
