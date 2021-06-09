package com.example.desafio1.repository;

import com.example.desafio1.exception.ProductIDAllReadyInDatabaseException;
import com.example.desafio1.model.Product;
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
public class ProductRepository implements IRepository<Product> {
	List<Product> products;

	@PostConstruct
	@Override
	public void loadDatabase() {
		File file = null;

		try {
			file = ResourceUtils.getFile("classpath:products.json");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not find products.json.");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Product>> typeReference = new TypeReference<>() {};
		products = new ArrayList<>();

		try {
			products = objectMapper.readValue(file, typeReference);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Error] Could not read from products database.");
		}
	}

	public void registerProduct(Product product) throws ProductIDAllReadyInDatabaseException {
		if (products.stream().filter(p -> p.getProductID() == product.getProductID())
							 .findAny()
							 .orElse(null) != null) {

			throw new ProductIDAllReadyInDatabaseException(product.getProductID());
		}

		products.add(product);
	}
}
