package com.example.desafio2.repository;

import com.example.desafio2.model.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepository implements IRepository<District> {

	List<District> districts;
	int ids = 0;

	@PostConstruct
	@Override
	public void loadDatabase() {
		File file = null;

		try {
			file = ResourceUtils.getFile("classpath:districts.json");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not find districts.json.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<District>> typeReference = new TypeReference<>() {};
		districts = new ArrayList<>();

		try {
			districts = objectMapper.readValue(file, typeReference);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not read from districts database.");
		}

		ids = districts.size();
	}

	@Override
	public District findByID(int id) {
		return districts.stream().filter(e -> e.getId() == id)
								 .findAny()
								 .orElse(null);
	}

	@Override
	public District findByName(String name) {
		return districts.stream().filter(e -> e.getName().equals(name))
								 .findAny()
								 .orElse(null);
	}

	@Override
	public void add(District item) {
		item.setId(++ids);
		districts.add(item);
	}

	@Override
	public List<District> getItems() {
		return districts;
	}
}
