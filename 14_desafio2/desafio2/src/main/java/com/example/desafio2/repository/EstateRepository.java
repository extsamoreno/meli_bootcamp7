package com.example.desafio2.repository;

import com.example.desafio2.exception.IDNotFoundException;
import com.example.desafio2.exception.NameNotFoundException;
import com.example.desafio2.model.Estate;
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
public class EstateRepository implements IRepository<Estate> {

	List<Estate> estates;
	int ids = 0;

	@PostConstruct
	@Override
	public void loadDatabase() {
		File file = null;

		try {
			file = ResourceUtils.getFile("classpath:estates.json");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not find estates.json.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Estate>> typeReference = new TypeReference<>() {};
		estates = new ArrayList<>();

		try {
			estates = objectMapper.readValue(file, typeReference);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not read from estates database.");
		}

		ids = estates.size();
	}

	@Override
	public Estate findByID(int id) throws IDNotFoundException {
		return estates.stream().filter(e -> e.getId() == id)
							   .findAny()
							   .orElseThrow(() -> new IDNotFoundException(id));
	}

	@Override
	public Estate findByName(String name) throws NameNotFoundException {
		return estates.stream().filter(e -> e.getName().equals(name))
							   .findAny()
							   .orElseThrow(() -> new NameNotFoundException(name));
	}

	@Override
	public void add(Estate item) {
		item.setId(++ids);
		estates.add(item);
	}

	@Override
	public List<Estate> getItems() {
		return estates;
	}
}
