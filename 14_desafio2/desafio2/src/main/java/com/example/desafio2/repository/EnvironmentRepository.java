package com.example.desafio2.repository;

import com.example.desafio2.model.Environment;
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
public class EnvironmentRepository implements IRepository<Environment> {

	List<Environment> environments;
	int ids = 0;

	@PostConstruct
	@Override
	public void loadDatabase() {
		File file = null;

		try {
			file = ResourceUtils.getFile("classpath:environments.json");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not find environments.json.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Environment>> typeReference = new TypeReference<>() {};
		environments = new ArrayList<>();

		try {
			environments = objectMapper.readValue(file, typeReference);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not read from environments database.");
		}

		ids = environments.size();
	}

	@Override
	public Environment findByID(int id) {
		return environments.stream().filter(e -> e.getId() == id)
									.findAny()
									.orElse(null);
	}

	@Override
	public Environment findByName(String name) {
		return environments.stream().filter(e -> e.getName().equals(name))
									.findAny()
									.orElse(null);
	}

	@Override
	public void add(Environment item) {
		item.setId(++ids);
		environments.add(item);
	}

	@Override
	public List<Environment> getItems() {
		return environments;
	}
}
