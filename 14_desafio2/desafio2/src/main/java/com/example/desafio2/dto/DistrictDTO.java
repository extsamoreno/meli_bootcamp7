package com.example.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
	@NotNull(message = "El barrio no puede estar vacío.")
	@Size(max = 45)
	String district_name;

	@NotNull(message = "El precio de un barrio no puede estar vacío.")
	@DecimalMax(value = "4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
	@DecimalMin(value = "0.0")
	Double district_price;
}
