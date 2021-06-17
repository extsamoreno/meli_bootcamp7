package com.meli.tucasita.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyWithEnvAndMetersDTO {
    private String name;
    private List<EnvironmentResponseDTO> environments= new ArrayList<>();

    public void addEnvDTO(EnvironmentResponseDTO e){
        environments.add(e);
    }
}
