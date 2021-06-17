package com.example.challenge2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EnvironmentSizesDTO {
    private String name;
    List<SizeResponseDTO> environments;
}
