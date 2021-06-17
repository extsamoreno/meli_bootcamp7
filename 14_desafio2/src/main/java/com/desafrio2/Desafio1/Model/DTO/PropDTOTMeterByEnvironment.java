package com.desafrio2.Desafio1.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropDTOTMeterByEnvironment {
    private String name;
    private List<EnvironmentDTO> environments;
}
