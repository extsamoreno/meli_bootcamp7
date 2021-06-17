package com.example.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

	@NotNull(message = "El nombre del ambiente no puede estar vacío.")
	@Pattern(regexp = "[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula.")
	@Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
	String environment_name;

	@NotNull(message = "El ancho del ambiente no puede estar vacío.")
	@DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
	double environment_width;

	@NotNull(message = "El largo del ambiente no puede estar vacío.")
	@DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
	double environment_length;
}
