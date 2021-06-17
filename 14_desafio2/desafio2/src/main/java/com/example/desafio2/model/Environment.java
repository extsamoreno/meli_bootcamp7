package com.example.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
	int id;
	String name;
	double width;
	double height;
}
