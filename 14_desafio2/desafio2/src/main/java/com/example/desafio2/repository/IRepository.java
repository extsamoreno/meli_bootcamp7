package com.example.desafio2.repository;

import com.example.desafio2.exception.IDNotFoundException;
import com.example.desafio2.exception.NameNotFoundException;
import com.example.desafio2.model.Estate;

import java.util.List;

public interface IRepository<T> {
	public void loadDatabase();

	T findByID(int id) throws IDNotFoundException;

	T findByName(String name) throws NameNotFoundException;

	void add(T item);

	List<T> getItems();
}
