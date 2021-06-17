package com.example.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstateDTO {
	@NotNull(message = "El nombre de la propiedad no puede estar vacío.")
	@Pattern(regexp = "[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
	@Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
	String prop_name;

	@NotNull
	DistrictDTO district;

	@NotNull
	List<@NotNull EnvironmentDTO> environments;
}
