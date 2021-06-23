package com.desafio2.demo.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropDTOTMeterByEnvironment {
    private String name;
    private List<EnvironmentDTOResponse> environments;
}