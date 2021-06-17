package com.example.challenge2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentSizesDTO {
    private String name;
    List<SizeResponseDTO> environments;
}
