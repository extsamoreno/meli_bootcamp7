package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	int productID;
	String productName;
	String type;
	String brand;
	String color;
	String notes;
}
