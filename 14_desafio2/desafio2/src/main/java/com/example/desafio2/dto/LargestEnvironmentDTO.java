package com.example.desafio2.dto;

import com.example.desafio2.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LargestEnvironmentDTO {

	EnvironmentDTO environment;
	double squareMeters;
}
