package com.example.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentsSquareMetersDTO {
	List<@NotNull EnvironmentDTO> environments;
}
