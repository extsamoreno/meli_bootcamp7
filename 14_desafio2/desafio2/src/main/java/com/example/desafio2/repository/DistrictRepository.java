package com.example.desafio2.repository;

import com.example.desafio2.model.District;
import org.springframework.stereotype.Repository;

@Repository
public class DistrictRepository implements IRepository<District> {

	@Override
	public void loadDatabase() {

	}

	@Override
	public District findByID(int id) {
		return null;
	}

	@Override
	public District findByName(String name) {
		return null;
	}
}
